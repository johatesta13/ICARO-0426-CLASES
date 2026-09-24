package BANCO.src;

public class Main {

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria(10000);

        try {
            cuenta.retirar(3000);
            //Saldo en 7mil

            cuenta.retirar(9000);



        } catch (SaldoInsuficienteException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}
