package negocio;

public class ProveedorView {
	//atributos
	private String cuit;
	private String razonSocial;
	private String domicilio;
	private String telefono;
	private String mail;
	private boolean estado;
	
	//constructor
	
	public ProveedorView(String cuit, String razonSocial, String domicilio, String telefono, String mail) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}

	public String getCuit() {
		return cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	public boolean isEstado() {
		return estado;
	}
	
	
	
}
