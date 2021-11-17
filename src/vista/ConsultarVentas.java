package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;


import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import java.awt.event.ActionEvent;

public class ConsultarVentas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dia;
	private JTextField mes;
	private JTextField año;
	private JTextField nombreCajero;
	private JTextField numeroCaja;
	

	public ConsultarVentas() {
		setTitle("Consultar Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 47, 65, 14);
		contentPane.add(lblFecha);
		
		dia = new JTextField();
		dia.setBounds(85, 44, 96, 20);
		contentPane.add(dia);
		dia.setColumns(10);
		
		mes = new JTextField();
		mes.setBounds(245, 44, 96, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		año = new JTextField();
		año.setBounds(410, 44, 96, 20);
		contentPane.add(año);
		año.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dia");
		lblNewLabel.setBounds(85, 19, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mes");
		lblNewLabel_1.setBounds(245, 19, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o");
		lblNewLabel_2.setBounds(410, 19, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNombreCajero = new JLabel("Cajero");
		lblNombreCajero.setBounds(10, 136, 65, 14);
		contentPane.add(lblNombreCajero);
		
		nombreCajero = new JTextField();
		nombreCajero.setBounds(104, 133, 209, 20);
		contentPane.add(nombreCajero);
		nombreCajero.setColumns(10);
		
		JLabel lblNumeroCaja = new JLabel("Numero Caja");
		lblNumeroCaja.setBounds(10, 229, 84, 14);
		contentPane.add(lblNumeroCaja);
		
		numeroCaja = new JTextField();
		numeroCaja.setBounds(104, 226, 84, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBounds(10, 280, 705, 172);
		contentPane.add(panelResultados);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Sistema miSistema  = Sistema.getInstancia();
					String cajeroS = nombreCajero.getText();
					String añoS = año.getText();
					String diaS = dia.getText();
					String mesS = mes.getText();
					String numCaja =numeroCaja.getText();
					LocalDate fecha = null;
					Object[][] encontradas  = null;
					
					if(añoS.compareToIgnoreCase("")!=0 && mesS.compareToIgnoreCase("")!=0 && diaS.compareToIgnoreCase("")!=0) {
						fecha = LocalDate.of(Integer.parseInt(añoS), Integer.parseInt(mesS), Integer.parseInt(diaS));
					}else {
						fecha=null;
					}
					
					
					if(numCaja.compareToIgnoreCase("")!=0 && fecha!=null && cajeroS.compareToIgnoreCase("")!=0) {
						encontradas = miSistema.consultarVentas(cajeroS, Integer.parseInt(numCaja), fecha);	
					}else if(numCaja.compareToIgnoreCase("")!=0 && fecha==null && cajeroS.compareToIgnoreCase("")==0) {
						encontradas = miSistema.consultarVentas(Integer.parseInt(numCaja));
					}else if(numCaja.compareToIgnoreCase("")!=0  && fecha!=null && cajeroS.compareToIgnoreCase("")==0) {
						encontradas = miSistema.consultarVentas(Integer.parseInt(numCaja),fecha);
					}else if(numCaja.compareToIgnoreCase("")!=0 && fecha==null && cajeroS.compareToIgnoreCase("")!=0) {
						encontradas = miSistema.consultarVentas(cajeroS,Integer.parseInt(numCaja));
					}else if(numCaja.compareToIgnoreCase("")==0 && fecha!=null && cajeroS.compareToIgnoreCase("")!=0) {
						encontradas = miSistema.consultarVentas(cajeroS,fecha);
					}else if(numCaja.compareToIgnoreCase("")==0 && fecha!=null && cajeroS.compareToIgnoreCase("")==0) {
						encontradas = miSistema.consultarVentas(fecha);
					}else if(numCaja.compareToIgnoreCase("")==0 && fecha==null && cajeroS.compareToIgnoreCase("")!=0) {
						encontradas = miSistema.consultarVentas(cajeroS);
					}
					if(encontradas!=null) {
						panelResultados.repaint();
						panelResultados.revalidate();
						panelResultados.removeAll();
						String[] columnNames = {"Fecha", "Cajero", "# Caja", "# Venta", "Total"};
						final JTable table = new JTable(encontradas,columnNames);
						table.setPreferredScrollableViewportSize(new Dimension(500, 80));
						JScrollPane scrollpane = new JScrollPane(table);
						panelResultados.add(scrollpane,BorderLayout.CENTER);
						contentPane.revalidate();
					    contentPane.repaint();
					}else {
						JOptionPane.showMessageDialog(null, "No hay ventas");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ingreso de datos invalido, o vacio. Intente de nuevo");
				}
			}
		});
		btnConsultar.setBounds(245, 225, 116, 23);
		contentPane.add(btnConsultar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(410, 225, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}

}
