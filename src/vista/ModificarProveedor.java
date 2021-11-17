package vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controlador.Sistema;

import negocio.ProveedorView;


import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProveedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cuit;
	private JTextField razonSocial;
	private JLabel lblDomicilio;
	private JTextField domicilio;
	private JLabel lblTelefono;
	private JTextField telefono;
	private JLabel lblMail;
	private JTextField mail;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnBuscar;


	/**
	 * Create the frame.
	 */
	public ModificarProveedor() {
		setTitle("Modificar Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCUIT = new JLabel("CUIT");
		lblCUIT.setBounds(10, 33, 155, 14);
		contentPane.add(lblCUIT);
		
		cuit = new JTextField();
		cuit.setBounds(226, 30, 284, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);
		
		JLabel lblRazonSocial = new JLabel("Razon Social");
		lblRazonSocial.setBounds(10, 89, 155, 14);
		contentPane.add(lblRazonSocial);
		
		razonSocial = new JTextField();
		razonSocial.setBounds(226, 86, 284, 20);
		contentPane.add(razonSocial);
		razonSocial.setColumns(10);
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 156, 155, 14);
		contentPane.add(lblDomicilio);
		
		domicilio = new JTextField();
		domicilio.setBounds(226, 153, 284, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 221, 155, 14);
		contentPane.add(lblTelefono);
		
		telefono = new JTextField();
		telefono.setBounds(226, 218, 284, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 283, 155, 14);
		contentPane.add(lblMail);
		
		mail = new JTextField();
		mail.setBounds(226, 280, 284, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int input = JOptionPane.showConfirmDialog(null, 
			                "Do you want to proceed?", "Select an Option...",JOptionPane.OK_CANCEL_OPTION);
					// 0=yes, 1=no, 2=cancel
					if(input==0) {
						Sistema.getInstancia().modificarProveedor(cuit.getText(),razonSocial.getText(),domicilio.getText(),telefono.getText(),mail.getText());
						dispose();
					}
					
					
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Datos invalidos, por favor revisar");
				}
				
			}
		});
		btnModificar.setBounds(322, 331, 89, 43);
		contentPane.add(btnModificar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(421, 331, 89, 43);
		contentPane.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cuit.getText().compareToIgnoreCase("")!=0) {
					ProveedorView miProv = Sistema.getInstancia().buscarProveedorView(cuit.getText());
					razonSocial.setText(miProv.getRazonSocial());
					domicilio.setText(miProv.getDomicilio());
					telefono.setText(miProv.getTelefono());
					mail.setText(miProv.getMail());
					
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese un cuit primero");
				}
			}
		});
		btnBuscar.setBounds(223, 331, 89, 43);
		contentPane.add(btnBuscar);
	}

}
