public class DoWhile1_ReintentoConsultaBD {
    public static void main(String[] args) {
        int intento = 0;
        boolean exito = false;

        do {
            intento++;
            exito = ejecutarConsultaBD();
            System.out.println("Intento #" + intento + " - éxito: " + exito);
        } while (!exito && intento < 3);
    }

    private static boolean ejecutarConsultaBD() {
        // puede fallar por timeout, por ejemplo
        return false;
    }
}



