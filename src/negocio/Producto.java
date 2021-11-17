package negocio;

public class Producto {
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
	public Producto(String codigo, String descripcion, String marca, Proveedor proveedor, float precio, int stock,
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

	// getters y setter

	public String getCodigo() {
		return codigo;
	}
	


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public int getPedidoRepo() {
		return pedidoRepo;
	}


	public void setPedidoRepo(int pedidoRepo) {
		this.pedidoRepo = pedidoRepo;
	}
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	//metodos de negocio
	


	public void modificarProd(String descripcion, String marca, Proveedor proveedor, float precio, int stock, int minimo, int pedidoRepo) {
		if(descripcion!=null) {
			this.descripcion = descripcion;
		}
		if(marca!=null) {
			this.marca = marca;
		}
		if(proveedor != null) {
			this.proveedor = proveedor;
		}
		if(precio != 0) {
			this.precio = precio;
		}
		if(stock != 0) {
			this.stock = stock;
		}
		if(minimo != 0) {
			this.stockMinimo = minimo;
		}
		if(pedidoRepo != 0) {
			this.pedidoRepo = pedidoRepo;
		}
	}
		
	public boolean validarCodProd(String cod) {
		if((this.codigo).equalsIgnoreCase(cod)) {
			return true; 
		}else {
			return false;
		}
	}
	
	public boolean validarProveedor(String cuit) {
		if(this.proveedor.getCuit().equals(cuit)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void actualizarStock(int cantidad) {
		this.stock -=cantidad;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", marca=" + marca + ", proveedor="
				+ proveedor.getCuit() + ", precio=" + precio + ", stock=" + stock + ", stockMinimo=" + stockMinimo
				+ ", pedidoRepo=" + pedidoRepo + "]";
	}
	
	public ProductoView getView()
	{
		return (new ProductoView(codigo,descripcion,marca,proveedor,precio,stock,stockMinimo,pedidoRepo));
	}
	
	
}
	
	
	
	
	
	
	
	

