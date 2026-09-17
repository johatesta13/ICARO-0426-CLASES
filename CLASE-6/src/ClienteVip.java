public class ClienteVip extends Cliente{

    private double tasaPreferencial;


    public ClienteVip(String nombre, String dni) {
        super(nombre, dni);
        this.tasaPreferencial = 0.05;
    }

    //Sobrescritura del metodo depositar

    @Override
    public void depositar(double monto){

        double montoConBonificacion = monto + tasaPreferencial;

        this.saldo += montoConBonificacion;

        System.out.println("DEPOSITO VIP REALIZADO CON BONIFICACION DEL " + (tasaPreferencial * 100) + "%");

        System.out.println("Saldo actual: $" + saldo);

    }

    @Override
    public void mostrarInfo(){

        System.out.println("⭐️ Cliente VIP ⭐️");
        super.mostrarInfo();
    }
}
