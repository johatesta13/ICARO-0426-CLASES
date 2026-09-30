package ar.org.icaro;

public class Usuario {

    private String username;
    private String password;
    private boolean estaLogueado;


    public Usuario(){}


    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
        this.estaLogueado = false;

    }

    public boolean login(String passwordIngresado){
        if(this.password.equals(passwordIngresado)){

            this.estaLogueado = true;
            return true;
        }

        return false;
    }


    public void logout(){
        this.estaLogueado = false;
    }


    public boolean esValido(){
        return username!= null && !username.isEmpty() &&
                password!=null && password.length() >=4;
    }


    public String getUsername() {
        return username;
    }

    public boolean isEstaLogueado() {
        return estaLogueado;
    }
}


