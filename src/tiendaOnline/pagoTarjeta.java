package tiendaOnline;

public class pagoTarjeta extends Pago {
    private String numeroTarjeta;
    private String fechaVencimiento;
    private int codigoSeguridad;

    public pagoTarjeta(String numeroTarjeta, String fechaVencimiento, int codigoSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

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

    private boolean validarTarjeta() {
        // Lógica para validar la tarjeta (simulada)
        // Aquí podrías integrarte con una pasarela de pagos real para la validación
        return numeroTarjeta.length() == 16 && fechaVencimientoValida(this.fechaVencimiento) && codigoSeguridad > 99 && codigoSeguridad < 1000;
    }

    private boolean fechaVencimientoValida(String fechaVencimiento) {
        // Lógica para validar la fecha de vencimiento (simulada)
        // Aquí se podría verificar que la fecha no esté pasada
        return true; // Suponiendo que la fecha de vencimiento es válida
    }
}
