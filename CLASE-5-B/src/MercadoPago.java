public class MercadoPago extends MedioDePago{

    private String alias;


    public MercadoPago(String titular, double monto, String alias){

        super(titular,monto);
        this.alias = alias;
    }

    @Override
    public void procesarPago(){

        System.out.printf("Pago procesado por mercado pago",
               alias, titular, monto);
    }
}
