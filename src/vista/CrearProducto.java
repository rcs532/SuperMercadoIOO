package vista;

import java.awt.*;

import javax.swing.JFrame;

import controlador.Sistema;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearProducto extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField codigo;
	private JTextField marca;
	private JTextField cuit;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockMinimo;
	private JTextField pedidoRepo;


	public CrearProducto() {
		setTitle("Crear Producto");
		setBounds(100, 100, 993, 481);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 52, 83, 14);
		getContentPane().add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(122, 49, 227, 20);
		getContentPane().add(codigo);
		codigo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 140, 83, 14);
		getContentPane().add(lblMarca);
		
		marca = new JTextField();
		marca.setBounds(122, 137, 227, 20);
		getContentPane().add(marca);
		marca.setColumns(10);
		
		JLabel lblCuitProveedor = new JLabel("CUIT proveedor");
		lblCuitProveedor.setBounds(10, 235, 109, 14);
		getContentPane().add(lblCuitProveedor);
		
		cuit = new JTextField();
		cuit.setBounds(122, 232, 227, 20);
		getContentPane().add(cuit);
		cuit.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 321, 49, 14);
		getContentPane().add(lblPrecio);
		
		precio = new JTextField();
		precio.setBounds(122, 318, 155, 20);
		getContentPane().add(precio);
		precio.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(440, 52, 94, 14);
		getContentPane().add(lblDescripcion);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setBackground(Color.LIGHT_GRAY);
		descripcion.setLineWrap(true);
		descripcion.setBounds(570, 47, 305, 83);
		getContentPane().add(descripcion);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(440, 204, 49, 14);
		getContentPane().add(lblStock);
		
		stock = new JTextField();
		stock.setBounds(570, 201, 96, 20);
		getContentPane().add(stock);
		stock.setColumns(10);
		
		JLabel lblStockMinimo = new JLabel("Stock minimo");
		lblStockMinimo.setBounds(440, 268, 83, 14);
		getContentPane().add(lblStockMinimo);
		
		stockMinimo = new JTextField();
		stockMinimo.setBounds(570, 265, 96, 20);
		getContentPane().add(stockMinimo);
		stockMinimo.setColumns(10);
		
		JLabel lblPedidoRepo = new JLabel("Pedido Reposicion");
		lblPedidoRepo.setBounds(440, 321, 120, 14);
		getContentPane().add(lblPedidoRepo);
		
		pedidoRepo = new JTextField();
		pedidoRepo.setBounds(570, 318, 96, 20);
		getContentPane().add(pedidoRepo);
		pedidoRepo.setColumns(10);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.getInstancia().crearProducto(codigo.getText(), descripcion.getText(), marca.getText(), cuit.getText(), Float.parseFloat(precio.getText()),Integer.parseInt(stock.getText()),Integer.parseInt(stockMinimo.getText()),Integer.parseInt(pedidoRepo.getText()));
					JOptionPane.showMessageDialog(null, "Producto creado con exito!");
					dispose();
					
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos");
				}
			}
		});
		btnCrearProducto.setBounds(103, 390, 128, 23);
		getContentPane().add(btnCrearProducto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(275, 390, 89, 23);
		getContentPane().add(btnCancelar);

	}
}
