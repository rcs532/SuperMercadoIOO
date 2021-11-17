package negocio;

public class ItemVenta {
	
	//atributos
	private Producto producto;
	private int cantidad;
	
	//constructor
	public ItemVenta(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	//getters y setters

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemVenta [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
