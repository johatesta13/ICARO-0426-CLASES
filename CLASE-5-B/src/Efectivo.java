public class Efectivo extends MedioDePago{

    public Efectivo(String titular, double monto) {
        super(titular,monto);
    }



    @Override
    public void procesarPago() {
        System.out.printf("Pago en efectivo de %s: $%.2f (con 10%% de descuento)%n",
                titular, monto * 0.9);
    }

}
