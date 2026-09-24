package EntradasCine.src;

public class Main {

    public static void main(String[] args) {

        Funcion funcion = new Funcion(false);

        try {

            funcion.reservarAsiento();
            funcion.reservarAsiento();

        } catch (AsientoOcupadoException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (FuncionFinalizadaException e) {

            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("Gracias por utilizar nuestro sistema.");
    }
}
