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
 * La clase abstracta Pago es la plantilla base para los diferentes métodos de pago.
 */
public abstract class Pago {
    /**
     * Método abstracto para procesar el pago.
     * Se espera que las clases hijas implementen este método con la lógica específica del tipo de pago.
     */
    public abstract void procesarPago();
}

