package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

public class VentaView {
	//atributos
	private int numeroVenta;
	private LocalDate fecha;
	private int numeroCaja;
	private String nombreCajero;
	private ArrayList<ItemVenta> itemVentas;
	private float total;
	
	//Constructor
	public VentaView(LocalDate fecha, int numeroCaja, String nombreCajero,int numeroVenta, float total) {
		super();
		itemVentas = new ArrayList<ItemVenta>();
		this.numeroVenta = numeroVenta;
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.total = total;
	}

	public int getNumeroVenta() {
		return numeroVenta;
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

	public ArrayList<ItemVenta> getItemVentas() {
		return itemVentas;
	}

	public float getTotal() {
		return total;
	}
	public float calcularTotal() {
		float total = 0;
		
		for(var i=0; i<this.itemVentas.size(); i++) { //producto * cantidad
			total+= (itemVentas.get(i).getProducto().getPrecio()) *  (itemVentas.get(i).getCantidad());
		}
		this.total = total;
		return total;
		
	}
	
	
	
}
