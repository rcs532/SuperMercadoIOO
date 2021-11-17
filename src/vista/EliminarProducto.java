package vista;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;

import negocio.ProductoView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigoProducto;
	private JButton btnEliminarProducto;
	private JButton iblCancelar;

	
	public EliminarProducto() {
		setTitle("Eliminar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panelProducto = new JPanel();
		panelProducto.setBackground(Color.WHITE);
		panelProducto.setBounds(10, 98, 479, 111);
		contentPane.add(panelProducto);
		
		JLabel iblCodProd = new JLabel("Codigo Producto");
		iblCodProd.setBounds(10, 48, 108, 14);
		contentPane.add(iblCodProd);
		
		codigoProducto = new JTextField();
		codigoProducto.setBounds(128, 45, 136, 20);
		contentPane.add(codigoProducto);
		codigoProducto.setColumns(10);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductoView miProd = Sistema.getInstancia().buscarProductoView(codigoProducto.getText());
					String message = miProd.toString();
					int input = JOptionPane.showConfirmDialog(null, 
			                "Borrara el siguiente Producto\n" + message, "\nSelect an Option...",JOptionPane.OK_CANCEL_OPTION);
					if(input==0) {
						Sistema.getInstancia().eliminarProducto(codigoProducto.getText());
						dispose();
					}
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "El producto no existe, revisar codigo ingresado.");
				}
			}
		});
		btnEliminarProducto.setBounds(10, 239, 165, 23);
		contentPane.add(btnEliminarProducto);
		
		iblCancelar = new JButton("Cancelar");
		iblCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		iblCancelar.setBounds(227, 239, 114, 23);
		contentPane.add(iblCancelar);
		
		JButton btnBuscarProducto = new JButton("Buscar Producto"); //Muestra el producto en el content pane 
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductoView miProducto = Sistema.getInstancia().buscarProductoView(codigoProducto.getText());
				panelProducto.revalidate();
				panelProducto.repaint();
			    contentPane.revalidate(); 
			    contentPane.repaint();
				if(miProducto!=null) {//si  se encontro el producto
					String descripcion = "Marca: " + miProducto.getMarca() + " Proveedor: " + miProducto.getProveedor().getMail() + " Codigo: " + miProducto.getCodigo();
					JLabel lblMensaje = new JLabel(descripcion);
					lblMensaje.setBounds(10, 43, 133, 14);
					panelProducto.add(lblMensaje);

				}else {
					JOptionPane.showMessageDialog(null, "Ingrese primero un codigo");
				}
				
			}
		});
		btnBuscarProducto.setBounds(308, 44, 181, 23);
		contentPane.add(btnBuscarProducto);
		

		
	}
}
