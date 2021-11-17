package vista;



import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class escanearProductos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigoProducto;


	public escanearProductos(int numeroVenta) {
		setTitle("Escanear Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 782, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoProducto = new JLabel("Codigo de Producto");
		lblCodigoProducto.setBounds(10, 53, 155, 14);
		contentPane.add(lblCodigoProducto);
		
		codigoProducto = new JTextField();
		codigoProducto.setBounds(175, 50, 96, 20);
		contentPane.add(codigoProducto);
		codigoProducto.setColumns(10);
		
		JLabel lblCantidadProducto = new JLabel("Cantidad de producto");
		lblCantidadProducto.setBounds(10, 136, 155, 14);
		contentPane.add(lblCantidadProducto);
		
		JSpinner cantidadProducto = new JSpinner();
		cantidadProducto.setBounds(175, 133, 96, 20);
		contentPane.add(cantidadProducto);
		JLabel lblResultado = new JLabel("0.0");
		lblResultado.setBounds(392, 136, 96, 14);
		contentPane.add(lblResultado);
		
		JPanel panelProductos = new JPanel();
		panelProductos.setBackground(Color.GRAY);
		panelProductos.setBounds(367, 53, 375, 47);
		contentPane.add(panelProductos);
		
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.getInstancia().escanearProducto(codigoProducto.getText(),(Integer)cantidadProducto.getValue(), numeroVenta);//codProd, int cant, num venta
					lblResultado.setText(String.valueOf(Sistema.getInstancia().buscarVentaView(numeroVenta).getTotal()));
				    contentPane.revalidate(); 
				    contentPane.repaint();
		
				    panelProductos.repaint();
					panelProductos.revalidate();
					panelProductos.removeAll();
					JLabel lblProd = new JLabel("Codigo " + Sistema.getInstancia().buscarProductoView(codigoProducto.getText()).getCodigo() + " Marca " + Sistema.getInstancia().buscarProductoView(codigoProducto.getText()).getMarca() + " Descripcion "+Sistema.getInstancia().buscarProductoView(codigoProducto.getText()).getDescripcion());
					panelProductos.add(lblProd);
					
					contentPane.revalidate();
				    contentPane.repaint();
					
				    
				    
				    
				    
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Producto no existe o ingreso de datos invalido");
				}
			}
		});
		btnAgregarProducto.setBounds(10, 215, 155, 23);
		contentPane.add(btnAgregarProducto);
		
		JButton btnNewButton_1 = new JButton("Cancelar Venta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.getInstancia().borrarVenta(numeroVenta);
				dispose();
			}
		});
		btnNewButton_1.setBounds(192, 215, 148, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Finalizar Transaccion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String monto = JOptionPane.showInputDialog("Ingrese monto dado por el cliente");
					float aux = Float.parseFloat(monto);
					
					float vuelto = Sistema.getInstancia().finalizarVenta(numeroVenta,aux);
					JOptionPane.showMessageDialog(null, "Su vuelto es: " + String.valueOf(vuelto) + ". Gracias por su compra!");
					
					dispose();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ingreso de datos invalido, intente de nuevo.");
				}
			}
		});
		btnNewButton.setBounds(392, 215, 206, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblLabel = new JLabel("Total: ");
		lblLabel.setBounds(339, 136, 49, 14);
		contentPane.add(lblLabel);
		

		
		JLabel lblProductosAgregados = new JLabel("Producto");
		lblProductosAgregados.setBounds(367, 25, 199, 14);
		contentPane.add(lblProductosAgregados);
		

	}
}
