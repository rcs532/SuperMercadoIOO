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



import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import java.awt.event.ActionEvent;

public class InformeDiarioCaja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField año;
	private JTextField dia;
	private JTextField mes;
	private JTextField cajero;
	private JTextField numeroCaja;


	/**
	 * Create the frame.
	 */
	public InformeDiarioCaja() {
		setTitle("Emitir Informe Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 867, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(199, 35, 107, 14);
		contentPane.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(447, 35, 75, 14);
		contentPane.add(lblMes);
		
		JLabel lblAño = new JLabel("A\u00F1o");
		lblAño.setBounds(706, 35, 58, 14);
		contentPane.add(lblAño);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(30, 57, 49, 14);
		contentPane.add(lblFecha);
		
		dia = new JTextField();
		dia.setBounds(89, 54, 237, 20);
		contentPane.add(dia);
		dia.setColumns(10);
		
		mes = new JTextField();
		mes.setBounds(352, 54, 226, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		año = new JTextField();
		año.setBounds(602, 54, 226, 20);
		contentPane.add(año);
		año.setColumns(10);
		
		JLabel lblCajero = new JLabel("Cajero");
		lblCajero.setBounds(28, 112, 58, 14);
		contentPane.add(lblCajero);
		
		cajero = new JTextField();
		cajero.setBounds(89, 109, 528, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);
		
		JLabel lblNumCaja = new JLabel("Numero de Caja");
		lblNumCaja.setBounds(5, 167, 126, 14);
		contentPane.add(lblNumCaja);
		
		numeroCaja = new JTextField();
		numeroCaja.setBounds(188, 164, 149, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(54, 253, 690, 214);
		contentPane.add(panelVentas);
		
		JButton btnBuscarInforme = new JButton("Buscar Informe");
		btnBuscarInforme.setBounds(154, 219, 152, 23);
		btnBuscarInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//busca el informe y lo muestra por pantalla
				Sistema miSistema = Sistema.getInstancia();
				String cajeroS = cajero.getText();
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
					encontradas = miSistema.informeDiarioCaja(cajeroS, Integer.parseInt(numCaja), fecha);	
				}else if(numCaja.compareToIgnoreCase("")!=0 && fecha==null && cajeroS.compareToIgnoreCase("")==0) {
					encontradas = miSistema.informeDiarioCaja(Integer.parseInt(numCaja));
				}else if(numCaja.compareToIgnoreCase("")!=0  && fecha!=null && cajeroS.compareToIgnoreCase("")==0) {
					encontradas = miSistema.informeDiarioCaja(fecha,Integer.parseInt(numCaja));
				}else if(numCaja.compareToIgnoreCase("")!=0 && fecha==null && cajeroS.compareToIgnoreCase("")!=0) {
					encontradas = miSistema.informeDiarioCaja(cajeroS,Integer.parseInt(numCaja));
				}else if(numCaja.compareToIgnoreCase("")==0 && fecha!=null && cajeroS.compareToIgnoreCase("")!=0) {
					encontradas = miSistema.informeDiarioCaja(cajeroS,fecha);
				}else if(numCaja.compareToIgnoreCase("")==0 && fecha!=null && cajeroS.compareToIgnoreCase("")==0) {
					encontradas = miSistema.informeDiarioCaja(fecha);
				}else if(numCaja.compareToIgnoreCase("")==0 && fecha==null && cajeroS.compareToIgnoreCase("")!=0) {
					encontradas = miSistema.informeDiarioCaja(cajeroS);
				}
				panelVentas.repaint();
				panelVentas.revalidate();
				panelVentas.removeAll();
				String[] columnNames = {"Fecha", "Cajero", "# Caja", "Saldo Inicial", "Saldo Final"};
				final JTable table = new JTable(encontradas,columnNames);
				table.setPreferredScrollableViewportSize(new Dimension(500, 80));
				JScrollPane scrollpane = new JScrollPane(table);
				panelVentas.add(scrollpane, BorderLayout.CENTER);
				
				contentPane.revalidate();
			    contentPane.repaint();
			    
			    //otro truco por si no funciona es recorrer el arreglo e ir agregando labels al content pane
				
			}	
		});
		contentPane.add(btnBuscarInforme);
		
		JButton btnCancelarBusqueda = new JButton("Cancelar");
		btnCancelarBusqueda.setBounds(466, 219, 115, 23);
		btnCancelarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancelarBusqueda);
		
		
		
		
	}

}
