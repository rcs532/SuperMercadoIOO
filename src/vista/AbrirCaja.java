package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AbrirCaja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreCajero;
	private JTextField numeroCaja;
	private JLabel lblSaldoIni;
	private JTextField saldoInicial;
	private JButton btnCrearCaja;
	private JButton btnCancelarCaja;



	/**
	 * Create the frame.
	 */
	public AbrirCaja() {
		setTitle("Abrir Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombreCajero = new JLabel("Nombre Cajero");
		GridBagConstraints gbc_lblNombreCajero = new GridBagConstraints();
		gbc_lblNombreCajero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCajero.gridx = 1;
		gbc_lblNombreCajero.gridy = 1;
		contentPane.add(lblNombreCajero, gbc_lblNombreCajero);
		
		nombreCajero = new JTextField();
		GridBagConstraints gbc_nombreCajero = new GridBagConstraints();
		gbc_nombreCajero.insets = new Insets(0, 0, 5, 5);
		gbc_nombreCajero.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreCajero.gridx = 2;
		gbc_nombreCajero.gridy = 1;
		contentPane.add(nombreCajero, gbc_nombreCajero);
		nombreCajero.setColumns(10);
		
		JLabel lblNumeroCaja = new JLabel("Numero Caja");
		GridBagConstraints gbc_lblNumeroCaja = new GridBagConstraints();
		gbc_lblNumeroCaja.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroCaja.gridx = 1;
		gbc_lblNumeroCaja.gridy = 3;
		contentPane.add(lblNumeroCaja, gbc_lblNumeroCaja);
		
		numeroCaja = new JTextField();
		GridBagConstraints gbc_numeroCaja = new GridBagConstraints();
		gbc_numeroCaja.insets = new Insets(0, 0, 5, 5);
		gbc_numeroCaja.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroCaja.gridx = 2;
		gbc_numeroCaja.gridy = 3;
		contentPane.add(numeroCaja, gbc_numeroCaja);
		numeroCaja.setColumns(10);
		
		lblSaldoIni = new JLabel("Saldo Inicial");
		GridBagConstraints gbc_lblSaldoIni = new GridBagConstraints();
		gbc_lblSaldoIni.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldoIni.gridx = 1;
		gbc_lblSaldoIni.gridy = 5;
		contentPane.add(lblSaldoIni, gbc_lblSaldoIni);
		
		saldoInicial = new JTextField();
		GridBagConstraints gbc_saldoInicial = new GridBagConstraints();
		gbc_saldoInicial.insets = new Insets(0, 0, 5, 5);
		gbc_saldoInicial.fill = GridBagConstraints.HORIZONTAL;
		gbc_saldoInicial.gridx = 2;
		gbc_saldoInicial.gridy = 5;
		contentPane.add(saldoInicial, gbc_saldoInicial);
		saldoInicial.setColumns(10);
		
		btnCrearCaja = new JButton("Crear Caja");
		btnCrearCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					LocalDate fecha = LocalDate.now();
					int input = JOptionPane.showConfirmDialog(null, 
			                "Esta seguro en abrir la caja?\n", "\nSelect an Option...",JOptionPane.OK_CANCEL_OPTION);
					if(input==0) {
						Sistema.getInstancia().abrirCaja(fecha, Integer.parseInt(numeroCaja.getText()),nombreCajero.getText(),Float.parseFloat(saldoInicial.getText()));
						dispose();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ingreso de datos invalido, intente de nuevo.");
				}
			}
		});
		GridBagConstraints gbc_btnCrearCaja = new GridBagConstraints();
		gbc_btnCrearCaja.insets = new Insets(0, 0, 0, 5);
		gbc_btnCrearCaja.gridx = 1;
		gbc_btnCrearCaja.gridy = 7;
		contentPane.add(btnCrearCaja, gbc_btnCrearCaja);
		
		btnCancelarCaja = new JButton("Cancelar");
		btnCancelarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelarCaja = new GridBagConstraints();
		gbc_btnCancelarCaja.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarCaja.gridx = 2;
		gbc_btnCancelarCaja.gridy = 7;
		contentPane.add(btnCancelarCaja, gbc_btnCancelarCaja);
		
		
		
	}

}
