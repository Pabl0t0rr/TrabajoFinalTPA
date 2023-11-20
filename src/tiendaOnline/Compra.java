package tiendaOnline;

/**
 * La clase Compra representa el proceso de completar una compra en la tienda online.
 */
public class Compra {

	/**
	 * Completa la compra utilizando el carrito de compras y un método de pago.
	 *
	 * @param carrito     El carrito de compras que contiene los productos a comprar.
	 * @param metodoPago  El método de pago a utilizar para la compra.
	 */
	public void completarCompra(carritoCompra carrito, Pago metodoPago) {
		// Lógica para finalizar la compra con el método de pago proporcionado
		metodoPago.procesarPago();

		for (Producto producto : carrito.getProductosCarrito()) {
			// Actualizar el stock después de la compra
			producto.restarStock(1); // Suponiendo que se compra una unidad de cada producto
		}
	}
}