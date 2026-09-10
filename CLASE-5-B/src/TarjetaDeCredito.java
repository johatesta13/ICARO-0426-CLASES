// ===== SUBCLASE 1 =====
class TarjetaCredito extends MedioDePago {
    private int cuotas;

    public TarjetaCredito(String titular, double monto, int cuotas) {
        super(titular, monto);
        this.cuotas = cuotas;
    }

    // SOBREESCRITURA (override): redefine el comportamiento del padre
    @Override
    public void procesarPago() {
        double valorCuota = monto / cuotas;
        System.out.printf("Pago con tarjeta de %s: $%.2f en %d cuotas de $%.2f%n",
                titular, monto, cuotas, valorCuota);
    }
}
