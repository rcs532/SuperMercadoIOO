package vista;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;



public class ProductoSinStock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public ProductoSinStock() {
		setTitle("Productos sin stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		Object[][] encontradas = Sistema.getInstancia().mostrarInfoStockProductos();
		if(encontradas != null) {
			try {
				String[] columnNames = {"Codigo", "Marca", "Proveedor", "Precio"};
				final JTable table = new JTable(encontradas,columnNames);
				table.setPreferredScrollableViewportSize(new Dimension(500, 80));
				JScrollPane scrollpane = new JScrollPane(table);
				getContentPane().add(scrollpane,BorderLayout.CENTER);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JLabel lblMensaje = new JLabel("No hay productos sin stock");
			lblMensaje.setBounds(10, 43, 133, 14);
			contentPane.add(lblMensaje);

		}
		
		

	}

}
