public class MedioDePago {

    protected String titular;
    protected double monto;

    public MedioDePago(String titular, double monto){

        this.titular= titular;
        this.monto = monto;
    }

    //METODOS SOBRECARGADOS

    public void procesarPago(){

        System.out.println("Provesando el pago de $ " + monto);
    }


    public void procesarPago(double montoextra){

        this.monto += montoextra;
        System.out.println("Se agrego un monto extra de $ " + montoextra);


        procesarPago();

    }

    public void procesarPago(double montoextra, String motivo){

        System.out.println("Procesando el pago con el motivo " + motivo);

        procesarPago(montoextra);
    }


}


