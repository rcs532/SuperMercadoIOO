package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CrearVenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numCaja;
	private JTextField nombreCajero;
	private JTextField numVenta;


	public CrearVenta() {
		setTitle("Iniciar Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroCaja = new JLabel("Numero de Caja");
		lblNumeroCaja.setBounds(10, 47, 151, 14);
		contentPane.add(lblNumeroCaja);
		
		numCaja = new JTextField();
		numCaja.setBounds(171, 44, 148, 20);
		contentPane.add(numCaja);
		numCaja.setColumns(10);
		
		JLabel lblNombreCajero = new JLabel("Nombre Cajero");
		lblNombreCajero.setBounds(10, 113, 151, 14);
		contentPane.add(lblNombreCajero);
		
		nombreCajero = new JTextField();
		nombreCajero.setBounds(171, 110, 148, 20);
		contentPane.add(nombreCajero);
		nombreCajero.setColumns(10);
		
		JButton btnIniciarVenta = new JButton("Iniciar Venta");
		btnIniciarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LocalDate fecha = LocalDate.now();
					int numeroVenta = Integer.parseInt(numVenta.getText());
					Sistema.getInstancia().crearVenta(fecha, Integer.parseInt(numCaja.getText()), nombreCajero.getText(), numeroVenta); //fecha, numerocaja, cajero, numeroventa
					
					escanearProductos ventana = new escanearProductos(numeroVenta);
					ventana.setVisible(true);
					dispose();
				}catch(Exception n) {
					JOptionPane.showMessageDialog(null, "Ingreso de datos invalido, intente de nuevo.");
				}
			

				
			}
		});
		btnIniciarVenta.setBounds(171, 222, 121, 23);
		contentPane.add(btnIniciarVenta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCancelar.setBounds(375, 222, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNumeroVenta = new JLabel("Numero de venta");
		lblNumeroVenta.setBounds(10, 174, 151, 14);
		contentPane.add(lblNumeroVenta);
		
		numVenta = new JTextField();
		numVenta.setBounds(171, 171, 148, 20);
		contentPane.add(numVenta);
		numVenta.setColumns(10);
		
		
		
		
	}
}
