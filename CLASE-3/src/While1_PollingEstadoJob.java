public class While1_PollingEstadoJob {
    public static void main(String[] args) throws InterruptedException {
        String estado = "PENDIENTE";
        int intentos = 0;

        while (!estado.equals("COMPLETADO") && intentos < 10) {
            estado = consultarEstadoJob();
            intentos++;
            System.out.println("Intento " + intentos + " - estado: " + estado);
            Thread.sleep(1000);
        }
    }

    private static String consultarEstadoJob() {
        // simula ir a buscar el status real (API, GCP logs, etc.)
        return "PENDIENTE";
    }
}
