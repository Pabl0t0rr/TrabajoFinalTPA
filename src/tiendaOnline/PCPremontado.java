package tiendaOnline;

/**
 * La clase PCPremontado representa un producto de tipo PC premontado en la tienda online.
 * Extiende la clase Producto y hereda sus atributos y métodos.
 */
class PCPremontado extends Producto {
    /**
     * Constructor para la clase PCPremontado.
     *
     * @param nombre      El nombre del PC premontado.
     * @param precio      El precio del PC premontado.
     * @param stock       La cantidad en stock del PC premontado.
     * @param descripcion Una breve descripción del PC premontado.
     */
    public PCPremontado(String nombre, double precio, int stock, String descripcion) {
        super(nombre, precio, stock, descripcion, "PC Premontado");
    }
}
