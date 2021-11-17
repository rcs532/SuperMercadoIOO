package controlador;
import java.time.LocalDate;

import java.util.ArrayList;

import negocio.Caja;
import negocio.CajaView;
import negocio.ItemVenta;
import negocio.Producto;
import negocio.ProductoView;
import negocio.Proveedor;
import negocio.ProveedorView;
import negocio.Venta;
import negocio.VentaView;

public class Sistema {
	//atributos
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Producto> productos;
	private ArrayList<Caja> cajas;
	private ArrayList<Venta> ventas;
	private static Sistema instancia;//porque no necesito que haya una instancia de la clase viva
	
	//Constructor
	private Sistema() {
		proveedores = new ArrayList<Proveedor>();
		productos = new ArrayList<Producto>();
		cajas = new ArrayList<Caja>();
		ventas = new ArrayList<Venta>();
		cargaInicial();
	}
	private void cargaInicial() {
		crearProveedor("1","Empresario","Pinares de Uyuca","22304025","kellogs@mail.com");
		crearProveedor("2","Empresario","Comayaguela","22405678","cocaCola@mail.com");
		crearProveedor("3","Empresario","San Pedro Sula","23407890","nestle@mail.com");
		crearProveedor("4","Empresario","Barrio San Miguel","2563789","cerveceriaHondureña@mail.com");
		//String codigo, String descripcion,String marca, String cuitProv, float precio, int stock, int minimo,int pedidoRepo
		crearProducto("1","CornFlakes","Kellogs","1",100,1,2,10);
		crearProducto("2","Soda","Coca Cola","2",40,20,4,10);
		crearProducto("3","Nesquick chocolate","Nestle","3",70,20,3,10);
		crearProducto("4","Cerveza Barena","Cerverceria Hondureña","4",30,50,2,10);
		//LocalDate fecha, int numCaja, String nomCajero, float saldoIni
		abrirCaja(LocalDate.now(), 1, "Roberto", 20);
		abrirCaja(LocalDate.now(),2,"Mauricio",100);
		abrirCaja(LocalDate.now(),3,"Nestor",10);
		abrirCaja(LocalDate.now(),4,"Paula",40);
		
		
		
	}
	
	public static Sistema getInstancia() {
		if(instancia==null) {//si nunca se creo nada
			instancia = new Sistema(); //la creo
		}
		return instancia;//la retorno
	}
	
	//setters y getters

	
	//metodos de negocio:
	/*--------------------------------------------------------------------------------------------------------------*/
	//proveedores
	
	
	//Me falta crear los views
	//
	
	public void crearProveedor(String cuit, String razonSocial, String domicilio, String telefono, String mail) {
		//primero busco si existe un proveedor con ese cuit
		if(buscarProveedor(cuit)==null) {//si no existe
			Proveedor proveedor = new Proveedor(cuit, razonSocial,domicilio, telefono, mail);
			proveedores.add(proveedor);
		}
	}
	
	private Proveedor buscarProveedor(String cuit) {
		int flag = 0;
		Proveedor proveedor = null;
		for(int i=0; i<proveedores.size() && flag==0; i++) {
			if(proveedores.get(i).getCuit().equals(cuit)) {
				flag=1;
				proveedor = proveedores.get(i);
			}
		}
		
		return proveedor;
	}
	
	
	
	public void modificarProveedor(String cuit, String razonSocial, String domicilio, String telefono, String mail) {
		Proveedor auxProv = buscarProveedor(cuit);
		if(auxProv!=null) {
			auxProv.modificarProv(razonSocial, domicilio, telefono, mail);
		}
	}
	
	public void eliminarProveedor(String cuit) {//como se que un proveedor no tiene productos asociados?
		int flag=0;
		for(int i=0; i<productos.size() && flag==0; i++) {
			if(productos.get(i).validarProveedor(cuit)) {
				
				flag=1;
				productos.get(i).setEstado(false);//decir que esta en falso este que lo pongo inactivo
			}
		}
		if(flag==0) {//no se encontro un producto con ese proveedor
			Proveedor auxProv = buscarProveedor(cuit);
			proveedores.remove(auxProv);
		}
		
	}
	/*--------------------------------------------------------------------------------------------------------------*/
	//productos
	
	
	public void crearProducto(String codigo, String descripcion,String marca, String cuitProv, float precio, int stock, int minimo,int pedidoRepo) {
		Producto produAux = buscarProducto(codigo);
		Proveedor provAux = buscarProveedor(cuitProv);
		
		
		if(produAux==null && provAux!=null) {//si no existe un producto de ese tipo, y el proveedor existe... lo creo
			Producto producto = new Producto(codigo, descripcion, marca, provAux, precio, stock, minimo, pedidoRepo);
			productos.add(producto);
		}
	}
	
	private Producto buscarProducto(String codigo) {
		int flag = 0;
		Producto prodAux = null;
		for(int i=0; i<productos.size() && flag==0; i++) {
			if(productos.get(i).getCodigo().equals(codigo)) {
				flag=1;
				prodAux = productos.get(i);
			}
		}
		
		return prodAux;
	}
	
	public void modificarProducto(String codProd, String descripcion, String marca, String cuitProv, float precio, int stock, int minimo, int pedidoRepo) {
		Proveedor auxProv = buscarProveedor(cuitProv);
		Producto auxProd = buscarProducto(codProd);
		
		if(auxProd!=null) {
			auxProd.modificarProd(descripcion, marca, auxProv, precio, stock, minimo, pedidoRepo);
		}
		
	}
	
	public Object[][] mostrarInfoStockProductos() {
		ArrayList<Producto> prodSinStock = new ArrayList<Producto>();
		
		for(int i=0; i<productos.size(); i++) {
			if(productos.get(i).getStock() <= productos.get(i).getStockMinimo()) {
				prodSinStock.add(productos.get(i));
			}
		}
		//matriz cuadrada proveedor nombre codProd proveedor marca
		
		Object[][] data = new Object[prodSinStock.size()][4];
		int i=0;
		for(Producto prod: prodSinStock) {
			data[i][0] = prod.getCodigo();
			data[i][1] = prod.getMarca();
			data[i][2] = prod.getProveedor().getMail();
			data[i][3] = prod.getPrecio();
			i++;		
		}
		
		return data;
		
		
	}
	
	public void eliminarProducto(String codProd) {
		int flag = 0;
		Producto prod = buscarProducto(codProd);
		for(int i=0; i<ventas.size() && flag==0;i++) {
			if(ventas.get(i).existeProducto(prod)==true) { // esta asociado a una venta
				flag=1;
				prod.setEstado(false); //eliminacion logica
			}
		}
		if(flag==0) { //el producto no esta asociado a ninguna venta
			productos.remove(prod);
		}
	}
	
	/*--------------------------------------------------------------------------------------------------------------*/
	//Caja
	public void abrirCaja(LocalDate fecha, int numCaja, String nomCajero, float saldoIni) {
		if(buscarCaja(numCaja) == null) {
			Caja cajaAux = new Caja(fecha, numCaja, nomCajero, saldoIni);
			cajas.add(cajaAux);
		}
	}
	
	private Caja buscarCaja(int numCaja) {
		Caja cajaAux = null;
		
		if(numCaja!=0) {
			int flag = 0;
			for(int i=0; i<cajas.size() && flag==0; i++) {
				if(cajas.get(i).getNumeroCaja()==numCaja) {
					flag=1;
					cajaAux = cajas.get(i);
				}
			}
			
		}
		return cajaAux;

	}
	

	//fechas, cajero o número de caja 
	public Object[][] informeDiarioCaja(LocalDate fecha){ //para fecha
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.getFecha().isEqual(fecha)) {
				encontradas.add(laCaja);
			}
		}
		
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	public Object[][] informeDiarioCaja(String nomCajero){ //para cajero
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.getNombreCajero().equalsIgnoreCase(nomCajero)) {
				encontradas.add(laCaja);
			}
		}
		
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	
	public Object[][] informeDiarioCaja(int numCaja){ // para numCaja
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.getNumeroCaja() == numCaja) {
				encontradas.add(laCaja);
			}
		}
		
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	
	public Object[][] informeDiarioCaja(String nomCajero, int numCaja, LocalDate fecha){ //para las 3
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.cumploComb(nomCajero, numCaja, fecha)) {
				encontradas.add(laCaja);
			}
		}
		
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	public Object[][] informeDiarioCaja(String nomCajero, int numCaja){ //para las 3
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.cumploComb(nomCajero, numCaja)) {
				encontradas.add(laCaja);
			}
		}
		
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	public Object[][] informeDiarioCaja(String nomCajero, LocalDate fecha){ //para las 3
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.cumploComb(nomCajero, fecha)) {
				encontradas.add(laCaja);
			}
		}
		
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	public Object[][] informeDiarioCaja(LocalDate fecha, int numCaja){ //para las 3
		ArrayList<Caja> encontradas = new ArrayList<Caja>();
		for(Caja laCaja: cajas) {
			if(laCaja.cumploComb(fecha, numCaja)) {
				encontradas.add(laCaja);
			}
		}
		//fecha cajero numeroCaja saldoInicial ventas saldo final
		Object[][] data = new Object[encontradas.size()][5];
		int i=0;
		for(Caja cajas: encontradas) {
			data[i][0] = cajas.getFecha().toString();
			data[i][1] = cajas.getNombreCajero();
			data[i][2] = cajas.getNumeroCaja();
			data[i][3] = cajas.getSaldoInicial();
			data[i][4] = cajas.getSaldoFinal();
			i++;		
		}
		
		return data;
	}
	
	
	
	public CajaView cerrarCaja(int numCaja){ //muestra por pantalla la las ventas (que la caja conoce), saldoIni, saldoFinal
		Caja cajaAux = buscarCaja(numCaja);
		
		
		return cajaAux.getView();
		
		
	}
	
	
	/*--------------------------------------------------------------------------------------------------------------*/
	//Ventas
	
	
	//para filtrar, cada Clase debe tener la combinacion de filtros correspondiente cumploFiltro(filtro1, filtro2)
	
	public Object[][] consultarVentas(LocalDate fecha){//por fecha
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.getFecha().isEqual(fecha)) {
				consultadas.add(laVenta);
			}
		}
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
	}
	public Object[][] consultarVentas(String cajero){//por cajero
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.getNombreCajero().equalsIgnoreCase(cajero)) {
				consultadas.add(laVenta);
			}
		}
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
	}
	public Object[][] consultarVentas(int numCaja){//por numCaja
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.getNumeroCaja()==numCaja) {
				consultadas.add(laVenta);
			}
		}
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
	}
	public Object[][]consultarVentas(String nomCajero, int numCaja){//por cajero y numcaja
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.cumploComb(nomCajero, numCaja)) {
				consultadas.add(laVenta);
			}
		}
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
	}
	public Object[][] consultarVentas(String nomCajero, LocalDate fecha){//por cajero y numcaja
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.cumploComb(nomCajero, fecha)) {
				consultadas.add(laVenta);
			}
		}
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
	}
	public Object[][] consultarVentas(int numCaja, LocalDate fecha){//por cajero y numcaja
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.cumploComb(fecha, numCaja)) {
				consultadas.add(laVenta);
			}
		}
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
	}
	public Object[][] consultarVentas(String nomCajero, int numCaja, LocalDate fecha){//por cajero y numcaja
		ArrayList<Venta> consultadas = new ArrayList<Venta>();
		for(Venta laVenta: ventas) {
			if(laVenta.cumploComb(nomCajero, numCaja, fecha)) {
				consultadas.add(laVenta);
			}
		}
		//fecha cajero numeroCaja numero venta total
		Object[][] data = new Object[consultadas.size()][5];
		int i=0;
		for(Venta venta: consultadas) {
			data[i][0] = venta.getFecha().toString();
			data[i][1] = venta.getNombreCajero();
			data[i][2] = venta.getNumeroCaja();
			data[i][3] = venta.getNumeroVenta();
			data[i][4] = venta.getTotal();
			i++;		
		}
		
		return data;
		
	}
	
	
	
	public void crearVenta(LocalDate fecha, int numeroCaja, String nombreCajero,int numeroVenta) {
		Venta ventaAux = new Venta(fecha, numeroCaja, nombreCajero, numeroVenta);
		this.ventas.add(ventaAux);
	}
	
	private Venta buscarVenta(int numVenta) {
		Venta venta = null;
		
		for(Venta sale : ventas) {
			if(sale.getNumeroVenta() == numVenta) {
				venta  = sale;
			}
		}
		
		return venta;
	}
	
	public void escanearProducto(String codProd, int cant, int numVenta ) {
		//confecciona el item venta para agregar a mi venta
		Venta venta = buscarVenta(numVenta);
		
		
		Producto prodAux = buscarProducto(codProd); // tengo el producto
		
		venta.agregarItemVenta(prodAux, cant); //lo agrego a la venta     
		                                                                
		//prodAux.actualizarStock(cant); //actualizo el stock del producto, este deberia hacerlo hasta confirmar la venta
		
		venta.calcularTotal();
	}
	
	public void actualizarStockPorItems(Venta venta) { //con este actualizo el stock
		ArrayList<ItemVenta> items = venta.getItemVentas();
		for(ItemVenta item: items) {
			int cambio = item.getProducto().getStock()-item.getCantidad();
			item.getProducto().setStock(cambio); //aqui se hace el cambio
			
		}
	}
	
	public float finalizarVenta(int numVenta, float totalEfectivo) { //cierra la venta y retorna el vuelto
		
		Venta venta = buscarVenta(numVenta);
		Caja cajaAux  = buscarCaja(venta.getNumeroCaja());
		
		
		actualizarStockPorItems(venta); //ahora actualizo el stock de la venta hasta confirmarla
		
				
		float totalVenta = venta.calcularTotal();//esto esta ok
		
		
		
		
		float vuelto =venta.calcularVuelto(totalEfectivo, totalVenta);
		
		cajaAux.addVenta(venta); // añado la venta a la caja actualizando el saldo final
		
		return vuelto;
		
	}
	
	public void borrarVenta(int numeroVenta) {
		Venta miVenta = buscarVenta(numeroVenta);
		ventas.remove(miVenta);
	}
	
	public int cantidadVentas() {
		return this.ventas.size();
	}
	
	@Override
	public String toString() {
		return "Sistema [proveedores=" + proveedores + ",\n productos=" + productos + ",\n cajas=" + cajas + "]";
	}
	
	
	//todos los buscar View
	
	public ProveedorView buscarProveedorView(String cuit) {
		Proveedor miProv = buscarProveedor(cuit);
		if (miProv!=null)
			return miProv.getView();
		return null;
	}
	
	public CajaView buscarCajaView(int numCaja) {
		Caja miCaja = buscarCaja(numCaja);
		if(miCaja!=null) {
			return miCaja.getView();
		}
		return null;
	}
	
	public ProductoView buscarProductoView(String codigo) {
		Producto miProd = buscarProducto(codigo);
		if(miProd!=null) {
			return miProd.getView();
			
		}
		return null;
	}
	
	public VentaView buscarVentaView(int numVenta) {
		Venta miVenta = buscarVenta(numVenta);
		if(miVenta!=null) {
			return miVenta.getView();
		}
		return null;
	}
	
	
	
	
	
}
