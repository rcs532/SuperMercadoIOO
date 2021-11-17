package vista;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;


import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	
	private Sistema miSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		//Instanciar controlador 
		miSistema = Sistema.getInstancia();
		
		//setear titulo ventana
		setTitle("Menu Principal Supermercado ");
		//defino la operacion al apretar la x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 456);
		
		//defino el recuadro gris donde voy a ir metiendo cosas.
		contentPane = new JPanel(){  
		   public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
				MenuPrincipal.class.getResource("/Images/backgroundPic.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
		   }  
       };
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 511, 27);
		contentPane.add(menuBar);
		
		JMenu Cajas = new JMenu("Cajas");
		menuBar.add(Cajas);
		
		JMenuItem mntmAbrirCaja = new JMenuItem("Abrir caja");
		mntmAbrirCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirCaja miVentana = new AbrirCaja();
				miVentana.setVisible(true);
			}
		});
		Cajas.add(mntmAbrirCaja);
		
		JMenuItem mntmInformeDiario = new JMenuItem("Informe diario de caja");
		mntmInformeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeDiarioCaja miVentana = new InformeDiarioCaja();
				miVentana.setVisible(true);
			}
		});
		Cajas.add(mntmInformeDiario);
		
		JMenuItem mntmCerrarCaja = new JMenuItem("Cerrar caja");
		mntmCerrarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerrarCaja miVentana = new CerrarCaja();
				miVentana.setVisible(true);
			}
		});
		Cajas.add(mntmCerrarCaja);
		
		JMenu Ventas = new JMenu("Ventas");
		menuBar.add(Ventas);
		
		JMenuItem mntmCrearVenta = new JMenuItem("Crear Venta");
		mntmCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVenta ventana = new CrearVenta();
				ventana.setVisible(true);
			}
		});
		Ventas.add(mntmCrearVenta);
		
		JMenuItem mntmConsultarVentas = new JMenuItem("Consultar Ventas");
		mntmConsultarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVentas miVentana = new ConsultarVentas();
				miVentana.setVisible(true);
			}
		});
		Ventas.add(mntmConsultarVentas);
		
		JMenu Proveedores = new JMenu("Proveedores");
		menuBar.add(Proveedores);
		
		
		//abro crear proveedor
		JMenuItem mntmCrearProveedor = new JMenuItem("Crear proveedor");
		mntmCrearProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mi logica cuando se haya hecho click
				CrearProveedor miVentana = new CrearProveedor(); // se lo paso por parametro para que pueda usarla
				miVentana.setVisible(true); // la hago visible una vez la creo
			}
		});
		Proveedores.add(mntmCrearProveedor);
		
		JMenuItem mntmModificarProveedor = new JMenuItem("Modificar Proveedor");
		mntmModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProveedor miVentana = new ModificarProveedor();
				miVentana.setVisible(true);
			}
		});
		Proveedores.add(mntmModificarProveedor);
		
		JMenuItem mntmEliminarProveedor = new JMenuItem("Eliminar Proveedor");
		mntmEliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProveedor miVentana = new EliminarProveedor();
				miVentana.setVisible(true);
			}
		});
		Proveedores.add(mntmEliminarProveedor);
		
		JMenu Productos = new JMenu("Productos");
		menuBar.add(Productos);
		
		JMenuItem mntmCrearProducto = new JMenuItem("Crear Producto");
		mntmCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProducto ventana = new CrearProducto();
				ventana.setVisible(true);
			}
		});
		Productos.add(mntmCrearProducto);
		
		JMenuItem mntmModificarProducto = new JMenuItem("Modificar Producto");
		mntmModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto ventana = new ModificarProducto();
				ventana.setVisible(true);
			}
		});
		Productos.add(mntmModificarProducto);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar Producto");
		mntmEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto  ventana = new EliminarProducto();
				ventana.setVisible(true);
			}
		});
		Productos.add(mntmEliminarProducto);
		
		JMenuItem mntmProductosSinStock = new JMenuItem("Informe Productos Stock");
		mntmProductosSinStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductoSinStock ventana = new ProductoSinStock();
				ventana.setVisible(true);
			}
		});
		Productos.add(mntmProductosSinStock);
		
		JMenu Salir = new JMenu("Salir");
		Salir.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(Salir);
		
		JMenuItem mntmSalirdeSistema = new JMenuItem("Salir del sistema");
		mntmSalirdeSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Salir.add(mntmSalirdeSistema);
	}
}
