package negocio;

public class ProductoView {
	//atributos
	private String codigo;
	private String descripcion;
	private String marca;
	private Proveedor proveedor;
	private float precio;
	private int stock;
	private int stockMinimo;
	private int pedidoRepo;
	private boolean estado;
	
	
	//constructor
	public ProductoView(String codigo, String descripcion, String marca, Proveedor proveedor, float precio, int stock,
			int stockMinimo, int pedidoRepo) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.proveedor = proveedor;
		this.precio = precio;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
		this.pedidoRepo = pedidoRepo;
	}


	public String getCodigo() {
		return codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getMarca() {
		return marca;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public float getPrecio() {
		return precio;
	}


	public int getStock() {
		return stock;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public int getPedidoRepo() {
		return pedidoRepo;
	}


	public boolean isEstado() {
		return estado;
	}
	
	

}
