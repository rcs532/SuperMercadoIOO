package negocio;

public class Proveedor {
	//atributos
	private String cuit;
	private String razonSocial;
	private String domicilio;
	private String telefono;
	private String mail;
	private boolean estado;
	
	//constructor
	
	public Proveedor(String cuit, String razonSocial, String domicilio, String telefono, String mail) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	////getters y setters

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	//metodos de negocio
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void modificarProv(String razonSocial, String domicilio, String telefono, String mail){
		if(razonSocial != null) {
			this.razonSocial = razonSocial;
		}
		if(domicilio !=null) {
			this.domicilio = domicilio;
		}
		if(telefono !=null) {
			this.telefono = telefono;
		}
		if(mail!=null) {
			this.mail = mail;
		}
	}

	@Override
	public String toString() {
		return "Proveedor [cuit=" + cuit + ", razonSocial=" + razonSocial + ", domicilio=" + domicilio + ", telefono="
				+ telefono + ", mail=" + mail + "]";
	}
	
	public ProveedorView getView()
	{
		return (new ProveedorView(cuit,razonSocial,domicilio,telefono,mail));
	}
	
	
	
	
	
	
	
	
}
