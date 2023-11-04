package tiendaOnline;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    // Getters y Setters para los atributos nombre, precio y cantidadEnStock
    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidadEnStock() {
        return this.cantidadEnStock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }
    
    public void restarStock(int cantidad) {
        // Lógica para reducir la cantidad de stock del producto
        this.cantidadEnStock -= cantidad;
    }

    // Otros posibles métodos para la clase Producto:

    public void agregarStock(int cantidad) {
        // Lógica para aumentar la cantidad de stock del producto
        this.cantidadEnStock += cantidad;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        // Lógica para cambiar el precio del producto
        this.precio = nuevoPrecio;
    }

    public void mostrarInformacion() {
        // Método para mostrar la información del producto
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Cantidad en Stock: " + this.cantidadEnStock);
    }

    // Podrían agregarse más métodos según las necesidades específicas de la aplicación
}
