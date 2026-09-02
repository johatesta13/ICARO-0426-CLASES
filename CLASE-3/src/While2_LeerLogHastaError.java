public class While2_LeerLogHastaError {
    public static void main(String[] args) {
        String linea = leerSiguienteLineaDeLog();

        while (linea != null && !linea.contains("ERROR")) {
            linea = leerSiguienteLineaDeLog();
        }

        if (linea != null) {
            System.out.println("Se encontró error: " + linea);
        }
    }

    private static String leerSiguienteLineaDeLog() {
        // simula lectura de una línea de log real
        return null;
    }
}
