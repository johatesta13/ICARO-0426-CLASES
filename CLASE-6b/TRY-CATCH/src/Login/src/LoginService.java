package Login.src;

public class LoginService {

    private final String usuarioCorrecto = "admin";
    private final String passwordCorrecta = "1234";

    public void iniciarSesion(String usuario, String password) throws LoginException {

        if (!usuario.equals(usuarioCorrecto)) {
            throw new LoginException("El usuario ingresado no existe.");
        }

        if (!password.equals(passwordCorrecta)) {
            throw new LoginException("La contraseña es incorrecta.");
        }

        System.out.println("Inicio de sesión exitoso.");
        System.out.println("Bienvenido " + usuario + ".");
    }
}
