package vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;

import negocio.CajaView;
import negocio.Venta;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CerrarCaja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numeroCaja;



	/**
	 * Create the frame.
	 */
	public CerrarCaja() {
		setTitle("Cerrar Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCerrarCaja = new JLabel("Numero de Caja:");
		lblCerrarCaja.setBounds(10, 43, 133, 14);
		contentPane.add(lblCerrarCaja);
		
		numeroCaja = new JTextField();
		numeroCaja.setBounds(139, 40, 112, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);

		
		JButton btnCerrarCaja = new JButton("Cerrar Caja");
		btnCerrarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((numeroCaja.getText()).equalsIgnoreCase("")==false) {
					int input = JOptionPane.showConfirmDialog(null, 
			                "Seguro que quiere cerrar la caja?\n", "\nSelect an Option...",JOptionPane.OK_CANCEL_OPTION);
					if(input==0) {
						try {
							CajaView cajaView = Sistema.getInstancia().cerrarCaja(Integer.parseInt(numeroCaja.getText()));
							ArrayList<Venta> encontradas = cajaView.getVentas();
							
							
							//
							Venta[] ventas = encontradas.toArray(new Venta[encontradas.size()]);
							JList<Venta> list = new JList<>(ventas);
	
							JLabel lblSaldoIni = new JLabel("Saldo Inicial: " + String.valueOf(cajaView.getSaldoInicial()));
							lblSaldoIni.setBounds(10, 63, 133, 14);
							contentPane.add(lblSaldoIni);
							
							JLabel lblSaldoFin = new JLabel("Saldo Final: " + String.valueOf(cajaView.getSaldoFinal()));
							lblSaldoFin.setBounds(10, 83, 133, 14);
							contentPane.add(lblSaldoFin);
	
						    JScrollPane scrollPane = new JScrollPane(list);  
	
						    contentPane.add(scrollPane);
						    contentPane.revalidate(); 
						    contentPane.repaint();
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Ingreso de datos invalido, intente de nuevo.");
						}
						
						
						
					}
					
					
					//este aun no se si funciona bien visiblemente
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese un numero de caja!");
				}

			}
		});
		btnCerrarCaja.setBounds(284, 39, 167, 23);
		contentPane.add(btnCerrarCaja);
		
		
		
		
		
	}
}
