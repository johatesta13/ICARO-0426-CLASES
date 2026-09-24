public class TryCatchBasico {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO TRY-CATCH BÁSICO ===\n");

        // SIN manejo de excepciones (comentado porque haría explotar el programa)
        /*
        System.out.println("1. Sin try-catch:");
        int numero = 10;
        int divisor = 0;
        int resultado = numero / divisor; // ❌ Programa explota aquí
        System.out.println("Resultado: " + resultado);
        System.out.println("Esta línea nunca se ejecuta");
        */







        // CON manejo de excepciones
        System.out.println("2. Con try-catch:");


        try {
            int numero = 10;
            int divisor = 0;
            int resultado = numero / divisor; // ❌ Excepción lanzada aquí
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("❌ Error capturado: No se puede dividir por cero");
            System.out.println("Tipo de excepción: " + e.getClass().getName());
            System.out.println("Mensaje: " + e.getMessage());
        }

        System.out.println("✅ El programa continúa ejecutándose después del error");
        System.out.println("✅ Programa finalizado correctamente");
    }
}