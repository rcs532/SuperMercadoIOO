package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

public class CajaView {
	//atributos
	private LocalDate fecha;
	private int numeroCaja;
	private String nombreCajero;
	private float saldoInicial;
	private float saldoFinal;
	private ArrayList<Venta> ventas;
	


	//constructor
	public CajaView(LocalDate fecha, int numeroCaja, String nombreCajero, float saldoInicial, float saldoFinal, ArrayList<Venta> ventas) {
		super();
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.saldoInicial = saldoInicial;
		this.ventas = ventas;
		this.saldoFinal = saldoFinal;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public int getNumeroCaja() {
		return numeroCaja;
	}



	public String getNombreCajero() {
		return nombreCajero;
	}



	public float getSaldoInicial() {
		return saldoInicial;
	}



	public float getSaldoFinal() {
		return saldoFinal;
	}



	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	
	
}
