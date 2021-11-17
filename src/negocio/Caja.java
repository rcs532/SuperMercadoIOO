package negocio;

import java.time.LocalDate;
import java.util.ArrayList;


public class Caja {
	//atributos
	private LocalDate fecha;
	private int numeroCaja;
	private String nombreCajero;
	private float saldoInicial;
	private float saldoFinal;
	private ArrayList<Venta> ventas;
	


	//constructor
	public Caja(LocalDate fecha, int numeroCaja, String nombreCajero, float saldoInicial) {
		super();
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.saldoInicial = saldoInicial;
		ventas = new ArrayList<Venta>();
		saldoFinal = this.saldoInicial;
	}
	
	//setters y getters

	public float getSaldoFinal() {
		return saldoFinal;
	}
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public void setSaldoFinal(float saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public float getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	//metodos de negocio
	
	
	public void addVenta(Venta venta) {
		ventas.add(venta);
		this.saldoFinal += venta.calcularTotal();//actualizo el saldo final
		
	}
	
	/*
	public float calcularVuelto(float efectivo, float total) {
		if(total==efectivo) {
			return 0;
		}else {
			
			return efectivo-total;
		}
	}*/
	
	public boolean cumploComb(String cajero, int numCaja) { //combinacion cajero , numero caja
		return this.nombreCajero.equalsIgnoreCase(cajero) && this.numeroCaja == numCaja;
	}
	
	public boolean cumploComb(String cajero, LocalDate fecha) { //combinacion cajero fecha
		return this.fecha.isEqual(fecha) && this.nombreCajero.equalsIgnoreCase(cajero);
	
	}
	
	public boolean cumploComb(LocalDate fecha, int numCaja) { // combinacion fecha, numCaja
		return this.fecha.isEqual(fecha) && this.numeroCaja==numCaja;
	}
	
	public boolean cumploComb(String cajero, int numCaja, LocalDate fecha) { // combinacion 3
		return  this.fecha.isEqual(fecha) && this.numeroCaja==numCaja && this.nombreCajero.equalsIgnoreCase(cajero);
	}

	@Override
	public String toString() {
		return "Caja [fecha=" + fecha + ", numeroCaja=" + numeroCaja + ", nombreCajero=" + nombreCajero
				+ ", saldoInicial=" + saldoInicial + ", saldoFinal=" + saldoFinal + ", ventas=" + ventas + "]\n";
	}
	
	
	
	
	public CajaView getView()
	{
		return (new CajaView(fecha,numeroCaja, nombreCajero,saldoInicial, saldoFinal, ventas));
	}
	

	
	
	
}
