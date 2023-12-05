/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author pablo
 */

import java.util.ArrayList;
import java.util.List;
import interfaz.Observador;

import java.util.ArrayList;
import java.util.List;

public class SujetoObservable {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void quitarObservador(Observador observador) {
        observadores.remove(observador);
    }

    protected void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}