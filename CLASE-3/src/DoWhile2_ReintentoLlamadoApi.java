public class DoWhile2_ReintentoLlamadoApi {
    public static void main(String[] args) {
        int intento = 0;
        int codigoRespuesta;

        do {
            intento++;
            codigoRespuesta = llamarApi();
            System.out.println("Intento #" + intento + " - código: " + codigoRespuesta);
        } while (codigoRespuesta != 200 && intento < 3);
    }

    private static int llamarApi() {
        // devuelve un código HTTP simulado
        return 500;
    }
}
