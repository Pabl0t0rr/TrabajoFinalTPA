package tiendaOnline;

/**
 * La interfaz seguimientoPedido proporciona métodos para el seguimiento de pedidos en la tienda online.
 */
public interface seguimientoPedido {
	/**
	 * Muestra el estado actual del pedido.
	 */
	void verEstadoPedido();

	/**
	 * Actualiza el estado de un pedido dado por su número identificador.
	 *
	 * @param numeroPedido El número identificador del pedido a actualizar.
	 * @param nuevoEstado  El nuevo estado que se asignará al pedido.
	 */
	void actualizarEstadoPedido(int numeroPedido, String nuevoEstado);

	/**
	 * Verifica la disponibilidad de un producto en el inventario.
	 *
	 * @param producto El producto a verificar en el inventario.
	 * @return true si el producto está disponible, de lo contrario false.
	 */
	boolean verificarDisponibilidadProducto(Producto producto);
}
