package tiendaOnline;

/**
 * La clase Producto representa un artículo disponible para la venta en la tienda online.
 */
public class Producto {
	private String nombre;
	private double precio;
	private int cantidadEnStock;
	private String descripcion;
	private String categoria;

	/**
	 * Constructor de la clase Producto.
	 *
	 * @param nombre          El nombre del producto.
	 * @param precio          El precio del producto.
	 * @param cantidadEnStock La cantidad disponible en stock del producto.
	 * @param descripcion     La descripción del producto.
	 * @param categoria       La categoría del producto.
	 */
	public Producto(String nombre, double precio, int cantidadEnStock, String descripcion, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	// Getters y Setters para los atributos nombre, precio, cantidadEnStock y descripcion
	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public int getCantidadEnStock() {
		return this.cantidadEnStock;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getCategoria() {
		return categoria;
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

	/**
	 * Aumenta la cantidad de stock del producto.
	 *
	 * @param cantidad La cantidad a agregar al stock del producto.
	 */
	public void agregarStock(int cantidad) {
		this.cantidadEnStock += cantidad;
	}

	/**
	 * Reduce la cantidad de stock del producto.
	 *
	 * @param cantidad La cantidad a restar del stock del producto.
	 */
	public void restarStock(int cantidad) {
		this.cantidadEnStock -= cantidad;
	}

	/**
	 * Actualiza el precio del producto.
	 *
	 * @param nuevoPrecio El nuevo precio a establecer para el producto.
	 */
	public void actualizarPrecio(double nuevoPrecio) {
		this.precio = nuevoPrecio;
	}

	/**
	 * Muestra la información del producto por consola.
	 */
	public void mostrarInformacion() {
		// Lógica para mostrar información del producto
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Stock: " + cantidadEnStock);
		System.out.println("Descripción: " + descripcion);
		System.out.println("Categoría: " + categoria);
	}

	/**
	 * Busca una palabra clave en el nombre del producto.
	 *
	 * @param palabraBuscada La palabra a buscar en el nombre del producto.
	 * @return true si la palabra buscada se encuentra en el nombre del producto, de lo contrario false.
	 */
	public boolean buscarPorPalabra(String palabraBuscada) {
		if (nombre.toLowerCase().contains(palabraBuscada.toLowerCase())) {
			return true;
		}
		return false;
	}

	public void reducirStock(int cantidad) {
	    if (cantidadEnStock >= cantidad) {
	        cantidadEnStock -= cantidad;
	    } else {
	        // Puedes manejar esto de acuerdo a tus necesidades, como lanzar una excepción o mostrar un mensaje de error.
	        System.out.println("No hay suficiente stock disponible para reducir.");
	    }
	}
}
