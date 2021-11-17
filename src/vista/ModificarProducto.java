package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import controlador.Sistema;

import negocio.ProductoView;

import java.awt.Color;

public class ModificarProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigo;
	private JTextField marca;
	private JTextField cuit;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockMinimo;
	private JTextField pedidoRepo;

	public ModificarProducto() {
		setTitle("Modificar Producto");
		setBounds(100, 100, 993, 481);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 52, 83, 14);
		getContentPane().add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(121, 49, 227, 20);
		getContentPane().add(codigo);
		codigo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 140, 83, 14);
		getContentPane().add(lblMarca);
		
		marca = new JTextField();
		marca.setBounds(121, 137, 227, 20);
		getContentPane().add(marca);
		marca.setColumns(10);
		
		JLabel lblCuitProveedor = new JLabel("CUIT proveedor");
		lblCuitProveedor.setBounds(10, 235, 106, 14);
		getContentPane().add(lblCuitProveedor);
		
		cuit = new JTextField();
		cuit.setBounds(121, 232, 227, 20);
		getContentPane().add(cuit);
		cuit.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 321, 49, 14);
		getContentPane().add(lblPrecio);
		
		precio = new JTextField();
		precio.setBounds(121, 318, 155, 20);
		getContentPane().add(precio);
		precio.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(440, 52, 94, 14);
		getContentPane().add(lblDescripcion);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setBackground(Color.WHITE);
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
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int input = JOptionPane.showConfirmDialog(null, 
			                "Esta seguro que quiere modificar el producto?\n", "\nSelect an Option...",JOptionPane.OK_CANCEL_OPTION);
					if(input==0) {
						Sistema.getInstancia().modificarProducto(codigo.getText(), descripcion.getText(), marca.getText(), cuit.getText(), Float.parseFloat(precio.getText()),Integer.parseInt(stock.getText()),Integer.parseInt(stockMinimo.getText()),Integer.parseInt(pedidoRepo.getText()));
					}
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos");
				}
			}
		});
		btnModificarProducto.setBounds(246, 390, 144, 23);
		getContentPane().add(btnModificarProducto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(440, 390, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(codigo.getText().compareToIgnoreCase("")!=0) {
					ProductoView miProd = Sistema.getInstancia().buscarProductoView(codigo.getText());
					//ProveedorView miProv = Sistema.getInstancia()
					marca.setText(miProd.getMarca());
					cuit.setText(miProd.getProveedor().getCuit());
					precio.setText(String.valueOf(miProd.getPrecio()));
					stock.setText(String.valueOf(miProd.getStock()));
					stockMinimo.setText(String.valueOf(miProd.getStockMinimo()));
					pedidoRepo.setText(String.valueOf(miProd.getPedidoRepo()));
					descripcion.setText(miProd.getDescripcion());
					
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese un codigo antes de buscar");
				}
			}
		});
		btnBuscar.setBounds(121, 390, 96, 23);
		getContentPane().add(btnBuscar);
		
		
		
	}

}
