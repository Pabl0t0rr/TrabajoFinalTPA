package tiendaOnline;

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
