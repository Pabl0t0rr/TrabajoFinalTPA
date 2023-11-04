package tiendaOnline;

public class Compra {
    public void completarCompra(carritoCompra carrito, Pago metodoPago) {
        double total = carrito.calcularCostoTotal();
        // Lógica para finalizar la compra con el método de pago proporcionado
        metodoPago.procesarPago();
        
        for (Producto producto : carrito.getProductosCarrito()) {
            // Actualizar el stock después de la compra
            producto.restarStock(1); // Suponiendo que se compra una unidad de cada producto
        }

        // Otros procesos como generar una confirmación de la compra, etc.
    }
}
