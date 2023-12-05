/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author pablo
 */

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
