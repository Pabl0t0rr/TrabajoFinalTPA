package tiendaOnline;

public class Producto {
	private String nombre;
	private double precio;
	private int cantidadEnStock;
	private String descripcion;

	public Producto(String nombre, double precio, int cantidadEnStock,String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.descripcion= descripcion;
	}

	// Getters y Setters para los atributos nombre, precio y cantidadEnStock
	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public int getCantidadEnStock() {
		return this.cantidadEnStock;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void agregarStock(int cantidad) {
		// Lógica para aumentar la cantidad de stock del producto
		this.cantidadEnStock += cantidad;
	}

	public void restarStock(int cantidad) {
		// Lógica para reducir la cantidad de stock del producto
		this.cantidadEnStock -= cantidad;
	}

	public void actualizarPrecio(double nuevoPrecio) {
		// Lógica para cambiar el precio del producto
		this.precio = nuevoPrecio;
	}

	public void mostrarInformacion() {
		// Método para mostrar la información del producto
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Precio: " + this.precio);
		System.out.println("Cantidad en Stock: " + this.cantidadEnStock);
		System.out.println("Descripcion del producto : "+ this.descripcion);
	}

	public boolean buscarPorPalabra(String palabraBuscada) {
		if (nombre.toLowerCase().contains(palabraBuscada.toLowerCase())) {
			return true;
		}
		return false;
	}
}

