package tiendaOnline;

/**
 * La clase Pieza representa un producto de tipo pieza en la tienda online.
 * Extiende la clase Producto y hereda sus atributos y métodos.
 */
class Pieza extends Producto {
    /**
     * Constructor para la clase Pieza.
     *
     * @param nombre      El nombre de la pieza.
     * @param precio      El precio de la pieza.
     * @param stock       La cantidad en stock de la pieza.
     * @param descripcion Una breve descripción de la pieza.
     */
    public Pieza(String nombre, double precio, int stock, String descripcion) {
        super(nombre, precio, stock, descripcion, "Pieza");
    }
}
