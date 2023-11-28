package tiendaOnline;

public interface EstrategiaDescuento {
    double aplicarDescuento(double precioOriginal);
}

// Implementación con descuento fijo
class DescuentoFijo implements EstrategiaDescuento {
    private double porcentajeDescuento;

    public DescuentoFijo(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double precioOriginal) {
        return precioOriginal - (precioOriginal * (porcentajeDescuento / 100));
    }
}
