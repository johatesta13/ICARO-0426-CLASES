public class For2_GenerarRegistrosPrueba {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            String email = "usuario" + i + "@testmail.com";
            insertarUsuarioDePrueba(email);
        }
    }

    private static void insertarUsuarioDePrueba(String email) {
        // método que inserta en la BD de test
        System.out.println("Insertando usuario de prueba: " + email);
    }
}
