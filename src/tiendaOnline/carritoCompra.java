package tiendaOnline;

import java.util.ArrayList;

/**
 * La clase carritoCompra representa el carrito de compras en la tienda online.
 */
public class carritoCompra{
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
}
