package vista;
import controlador.Sistema;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearProveedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cuit;
	private JTextField razonSocial;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField mail;

	
	/**
	 * Create the frame.
	 */
	public CrearProveedor() {
		setTitle("Crear Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 681, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCUIT = new JLabel("CUIT");
		lblCUIT.setBounds(10, 53, 109, 14);
		contentPane.add(lblCUIT);
		
		cuit = new JTextField();
		cuit.setBounds(129, 53, 355, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);
		
		JLabel lblRazonSocial = new JLabel("Razon Social");
		lblRazonSocial.setBounds(10, 114, 109, 14);
		contentPane.add(lblRazonSocial);
		
		razonSocial = new JTextField();
		razonSocial.setBounds(129, 111, 355, 20);
		contentPane.add(razonSocial);
		razonSocial.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 175, 109, 14);
		contentPane.add(lblDomicilio);
		
		domicilio = new JTextField();
		domicilio.setBounds(129, 172, 355, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 236, 109, 14);
		contentPane.add(lblTelefono);
		
		telefono = new JTextField();
		telefono.setBounds(129, 233, 355, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 297, 109, 14);
		contentPane.add(lblMail);
		
		mail = new JTextField();
		mail.setBounds(129, 294, 355, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnCrearProveedor = new JButton("Crear Proveedor");
		btnCrearProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Sistema.getInstancia().crearProveedor(cuit.getText(),razonSocial.getText(),domicilio.getText(), telefono.getText(), mail.getText());//creo mi proveedor
				dispose();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ingreso de datos invalido, revise los campos!");
				}
			}
		});
		btnCrearProveedor.setBounds(129, 350, 144, 39);
		contentPane.add(btnCrearProveedor);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(395, 350, 89, 39);
		contentPane.add(btnCancelar);
	}
}
