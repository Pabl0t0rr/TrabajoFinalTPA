package tiendaOnline;

import java.util.ArrayList;

public class carritoCompra implements seguimientoPedido {
	private ArrayList<Producto> productosEnCarrito = new ArrayList<>();

	public ArrayList<Producto> getProductosCarrito() {
		return productosEnCarrito;
	}

	public void agregarProducto(Producto producto) {
		this.productosEnCarrito.add(producto);
	}

	public void eliminarProducto(Producto producto) {
		this.productosEnCarrito.remove(producto);
	}

	public double calcularCostoTotal() {
		double costoTotal = 0;
		for (Producto producto : productosEnCarrito) {
			costoTotal += producto.getPrecio();
		}
		return costoTotal;
	}

	@Override	
	public void verEstadoPedido() {
		// Lógica para ver el estado del pedido
		// En el contexto del carrito de compras, podrías mostrar los productos añadidos y su cantidad
		for (Producto producto : productosEnCarrito) {
			System.out.println("Producto: " + producto.getNombre() + " - Cantidad: " + producto.getCantidadEnStock());
		}
	}

	@Override
	public void actualizarEstadoPedido(int numeroPedido, String nuevoEstado) {
		// Lógica para actualizar el estado de un pedido
		// Se podría asociar el número de pedido con un estado, pero en este contexto del carrito no hay pedidos gestionados
		// Aquí puedes agregar la lógica según lo que se requiera al actualizar el estado de un pedido.
		// Por ejemplo, si se tuviera una lista de pedidos, podrías buscar el pedido con el número proporcionado y actualizar su estado.
		// En este contexto de carrito, puedes imprimir un mensaje indicando que no hay pedidos asociados.
		System.out.println("No hay pedidos asociados a este carrito para actualizar su estado.");
	}

	@Override
	public boolean verificarDisponibilidadProducto(Producto producto) {
		// Lógica para verificar la disponibilidad de un producto en el carrito
		return productosEnCarrito.contains(producto);
	}

}

