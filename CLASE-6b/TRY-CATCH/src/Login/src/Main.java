package Login.src;

public class Main {

    public static void main(String[] args) {

        LoginService login = new LoginService();
        LoginService login2 = new LoginService();
        LoginService login3 = new LoginService();

        try {

            //login.iniciarSesion("admin", "12345");
            login2.iniciarSesion("admin","1234");
            login3.iniciarSesion("usuariooo","1234");

        } catch (LoginException e) {

            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("El programa continúa ejecutándose.");
    }
}
