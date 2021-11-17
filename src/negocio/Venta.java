package negocio;


import java.time.LocalDate;

import java.util.ArrayList;


public class Venta {
	//atributos
	private int numeroVenta;
	private LocalDate fecha;
	private int numeroCaja;
	private String nombreCajero;
	private ArrayList<ItemVenta> itemVentas;
	private float total;
	
	//Constructor
	public Venta(LocalDate fecha, int numeroCaja, String nombreCajero,int numeroVenta) {
		super();
		itemVentas = new ArrayList<ItemVenta>();
		this.numeroVenta = numeroVenta;
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
	}
	
	
	//getters y setters
	public int getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
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
	
	public float getTotal() {
		return total;
	}
	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public ArrayList<ItemVenta> getItemVentas() {
		return itemVentas;
	}

	public void setItemVentas(ArrayList<ItemVenta> itemVentas) {
		this.itemVentas = itemVentas;
	}
	
	
	//metodos de negocio
	
	public float calcularTotal() {
		float total = 0;
		
		for(var i=0; i<this.itemVentas.size(); i++) { //producto * cantidad
			total+= (itemVentas.get(i).getProducto().getPrecio()) *  (itemVentas.get(i).getCantidad());
		}
		this.total = total;
		return total;
		
	}
	
	public void agregarItemVenta(Producto producto, int cant) {
		ItemVenta item = new ItemVenta(producto, cant);
		itemVentas.add(item);
	}
	
	public boolean existeProducto(Producto aux) {
		int flag=0;
		boolean resultado = false;
		for(int i=0; i<itemVentas.size() && flag==0;i++) {
			if(itemVentas.get(i).getProducto().equals(aux)) {
				flag=1;
				resultado = true;
			}
		}
		return resultado;
	}
	
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
		return "Venta [numeroVenta=" + numeroVenta + ", fecha=" + fecha + ", nombreCajero=" + nombreCajero
				+ ", itemVentas=" + itemVentas + "] \n";
	}
	
	public float calcularVuelto(float efectivo, float total) {
		if(total==efectivo) {
			return 0;
		}else {
			//this.saldoInicial-=efectivo-total;
			return efectivo-total;
		}
	}
	
	public VentaView getView()
	{
		return (new VentaView(fecha,numeroCaja,nombreCajero,numeroVenta,total));
	}
	
	
	
	
	
	
}
