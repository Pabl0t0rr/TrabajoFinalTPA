package tiendaOnline;

import java.util.ArrayList;

public class carritoCompra implements seguimientoPedido {
    private ArrayList<Producto> productosEnCarrito = new ArrayList<>();

    @Override
    public void verEstadoPedido() {
        // Lógica para ver el estado del pedido
        // En el contexto del carrito de compras, podrías mostrar los productos añadidos y su cantidad
        for (Producto producto : productosEnCarrito) {
            System.out.println("Producto: " + producto.getNombre() + " - Cantidad: " + producto.getCantidadEnStock());
        }
    }

    public ArrayList<Producto> getProductosCarrito() {
        return productosEnCarrito;
    }
    
    // Métodos adicionales relacionados con el carrito de compras

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
    public void actualizarEstadoPedido(int numeroPedido, String nuevoEstado) {
        // Lógica para actualizar el estado de un pedido
        // Esta lógica podría involucrar el cambio de estado del pedido
    }

    @Override
    public boolean verificarDisponibilidadProducto(Producto producto) {
        // Lógica para verificar la disponibilidad de un producto en el carrito
        return productosEnCarrito.contains(producto);
    }

    // Otros métodos del carrito de compras según las necesidades de la aplicación
}
