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
import java.awt.Color;

public class EliminarProveedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField cuit;



	/**
	 * Create the frame.
	 */
	public EliminarProveedor() {
		setTitle("Eliminar Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCUIT = new JLabel("Ingrese el cuit del proveedor a borrar:");
		lblCUIT.setEnabled(false);
		lblCUIT.setBounds(120, 11, 240, 14);
		contentPane.add(lblCUIT);
		
		cuit = new JTextField();
		cuit.setBounds(120, 53, 188, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					ProveedorView miProv = Sistema.getInstancia().buscarProveedorView(cuit.getText());
					String message = miProv.toString();
					int input = JOptionPane.showConfirmDialog(null, 
			                "Borrara el siguiente Proveeedor\n" + message, "\nSelect an Option...",JOptionPane.OK_CANCEL_OPTION);
					if(input==0) {
						Sistema.getInstancia().eliminarProveedor(cuit.getText());
						dispose();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Proveedor no existe");
				}
			}
		});
		btnBorrar.setBounds(120, 170, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(219, 170, 89, 23);
		contentPane.add(btnCancelar);
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBackground(Color.WHITE);
		panelResultado.setBounds(32, 96, 366, 51);
		contentPane.add(panelResultado);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cuit.getText().compareTo("")!=0) {
					ProveedorView miProveedor = Sistema.getInstancia().buscarProveedorView(cuit.getText());
					String descripcion = "Cuit: " + miProveedor.getCuit() + ", Razon Social: " + miProveedor.getRazonSocial() + ", Mail: " + miProveedor.getMail();
					JLabel lblMensaje = new JLabel(descripcion);
					lblMensaje.setBounds(10, 43, 133, 14);
					panelResultado.add(lblMensaje);
				    contentPane.revalidate(); 
				    contentPane.repaint();
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese primero un cuit para buscar");
				}
				
			}
		});
		btnBuscar.setBounds(318, 52, 89, 23);
		contentPane.add(btnBuscar);
	}
}
