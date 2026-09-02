public class For1_RecorrerDataset {
    public static void main(String[] args) {
        String[] usuarios = {"user1", "user2", "user_invalido", "user_bloqueado"};

        for (int i = 0; i < usuarios.length; i++) {
            System.out.println("Probando login con: " + usuarios[i]);
            // login(usuarios[i]);
        }
    }
}
