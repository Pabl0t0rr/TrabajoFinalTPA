package tiendaOnline;

public interface seguimientoPedido {
    void verEstadoPedido();
    void actualizarEstadoPedido(int numeroPedido, String nuevoEstado);
    boolean verificarDisponibilidadProducto(Producto producto);
    // Otros métodos relacionados con el seguimiento de pedidos
}
