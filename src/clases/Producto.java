package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * La clase Producto representa un artículo disponible para la venta en la tienda online.
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;
    private String descripcion;
    private String categoria;

    /**
     * Constructor de la clase Producto.
     *
     * @param nombre          El nombre del producto.
     * @param precio          El precio del producto.
     * @param cantidadEnStock La cantidad disponible en stock del producto.
     * @param descripcion     La descripción del producto.
     * @param categoria       La categoría del producto.
     */
    public Producto(String nombre, double precio, int cantidadEnStock, String descripcion, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidadEnStock() {
        return this.cantidadEnStock;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getCategoria() {
        return categoria;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarStock(int cantidad) {
        this.cantidadEnStock += cantidad;
    }

    public void restarStock(int cantidad) {
        this.cantidadEnStock -= cantidad;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + cantidadEnStock);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Categoría: " + categoria);
    }

    /**
     * Busca una palabra clave en el nombre del producto.
     *
     * @param palabraBuscada La palabra a buscar en el nombre del producto.
     * @return true si la palabra buscada se encuentra en el nombre del producto, de lo contrario false.
     */
    public boolean buscarPorPalabra(String palabraBuscada) {
        return nombre.toLowerCase().contains(palabraBuscada.toLowerCase());
    }

    /**
     * Representación de cadena del producto.
     *
     * @return Una cadena que representa el producto.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPrecio: " + precio + "\nStock: " + cantidadEnStock +
                "\nDescripción: " + descripcion + "\nCategoría: " + categoria;
    }
    
}
