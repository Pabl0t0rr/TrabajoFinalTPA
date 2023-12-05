/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author pablo
 */

import interfaz.Observador;

public class UsuarioNotificacion implements Observador {
    private String nombreUsuario;

    public UsuarioNotificacion(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Usuario " + nombreUsuario + ": " + mensaje);
    }
}
