package tiendaOnline;

import java.util.ArrayList;

/**
 * La clase carritoCompra representa el carrito de compras en la tienda online.
 */
public class carritoCompra implements seguimientoPedido {
    private ArrayList<Producto> productosEnCarrito = new ArrayList<>();

    /**
     * Obtiene la lista de productos en el carrito.
     *
     * @return La lista de productos en el carrito.
     */
    public ArrayList<Producto> getProductosCarrito() {
        return productosEnCarrito;
    }

    /**
     * Agrega un producto al carrito.
     *
     * @param producto El producto a agregar al carrito.
     */
    public void agregarProducto(Producto producto) {
        this.productosEnCarrito.add(producto);
    }

    /**
     * Elimina un producto del carrito.
     *
     * @param producto El producto a eliminar del carrito.
     */
    public void eliminarProducto(Producto producto) {
        this.productosEnCarrito.remove(producto);
    }

    /**
     * Calcula el costo total de los productos en el carrito.
     *
     * @return El costo total de los productos en el carrito.
     */
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
        // En el contexto del carrito de compras, muestra los productos añadidos y su cantidad
        for (Producto producto : productosEnCarrito) {
            System.out.println("Producto: " + producto.getNombre() + " - Cantidad: " + producto.getCantidadEnStock());
        }
    }

    @Override
    public void actualizarEstadoPedido(int numeroPedido, String nuevoEstado) {
        // Lógica para actualizar el estado de un pedido
        // En este contexto del carrito no hay pedidos gestionados, imprime un mensaje indicando esta situación
        System.out.println("No hay pedidos asociados a este carrito para actualizar su estado.");
    }

    @Override
    public boolean verificarDisponibilidadProducto(Producto producto) {
        // Lógica para verificar la disponibilidad de un producto en el carrito
        return productosEnCarrito.contains(producto);
    }
}
