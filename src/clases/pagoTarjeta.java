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
 * La clase pagoTarjeta representa un tipo de pago con tarjeta.
 */
public class pagoTarjeta extends Pago {
    private String numeroTarjeta;
    private String fechaVencimiento;
    private int codigoSeguridad;

    /**
     * Constructor de pago con tarjeta.
     *
     * @param numeroTarjeta     El número de la tarjeta.
     * @param fechaVencimiento  La fecha de vencimiento de la tarjeta.
     * @param codigoSeguridad   El código de seguridad de la tarjeta.
     */
    public pagoTarjeta(String numeroTarjeta, String fechaVencimiento, int codigoSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

    /**
     * Valida la tarjeta.
     *
     * @return true si la tarjeta es válida, de lo contrario false.
     */
    private boolean validarTarjeta() {
        // Lógica para validar la tarjeta (simulada)
        // Aquí podrías integrarte con una pasarela de pagos real para la validación
        return numeroTarjeta.length() == 16 && fechaVencimientoValida(this.fechaVencimiento) && codigoSeguridad > 99 && codigoSeguridad < 1000;
    }

    /**
     * Verifica si la fecha de vencimiento de la tarjeta es válida.
     *
     * @param fechaVencimiento La fecha de vencimiento a validar.
     * @return true si la fecha de vencimiento es válida, de lo contrario false.
     */
    private boolean fechaVencimientoValida(String fechaVencimiento) {
        // Lógica para validar la fecha de vencimiento (simulada)
        // Aquí se podría verificar que la fecha no esté pasada
        return true; // Suponiendo que la fecha de vencimiento es válida
    }

    /**
     * Procesa el pago con tarjeta.
     */
    @Override
    public void procesarPago() {
        // Lógica para procesar el pago con tarjeta
        // Aquí se simula una validación básica de la tarjeta y se muestra un mensaje
        if (validarTarjeta()) {
            System.out.println("¡Pago procesado exitosamente con la tarjeta " + this.numeroTarjeta + "!");
        } else {
            System.out.println("Error: No se pudo procesar el pago. Por favor, revise la información de la tarjeta.");
        }
    }
    
    
}

