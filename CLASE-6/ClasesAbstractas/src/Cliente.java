abstract class Cliente {

    protected String nombre;
    protected String dni;
    protected double saldo;


    public Cliente(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
        this.saldo = 0.00;


    }


    public void depositar(double monto){
        this.saldo += monto;
        System.out.println("Deposito realizado. Saldo actual $ " + saldo);
    }

    public void mostrarInfo(){

        System.out.println("CLIENTE: " + " " + nombre + "DNI: " + " " +  dni + " " + "SALDO: " + saldo );
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    abstract public void retirar();

}
