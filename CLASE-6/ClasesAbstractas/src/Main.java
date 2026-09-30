public class Main{

    public void main(){


        Cliente cliente1 = new Cliente("Norma Martinez", "34566799");
        ClienteVip clienteVip = new ClienteVip("Mario Juarez","12345678");

        cliente1.mostrarInfo();


        cliente1.depositar(900.50);
        clienteVip.depositar(900.50);

        System.out.println("MOSTRANDO INFO DE LOS CLIENTES");

        cliente1.mostrarInfo();
        System.out.println();
        clienteVip.mostrarInfo();



    }
}