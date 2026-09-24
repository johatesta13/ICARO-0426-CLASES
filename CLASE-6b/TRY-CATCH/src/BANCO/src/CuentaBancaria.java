package BANCO.src;

public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }




    public void retirar(double monto) throws SaldoInsuficienteException {

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        if (monto > saldo) {
            throw new SaldoInsuficienteException("No posee saldo suficiente para realizar el retiro.");
        }

        saldo -= monto;

        System.out.println("Retiro realizado correctamente.");
        System.out.println("Saldo restante: $" + saldo);
    }
}
