package ar.org.icaro;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeMethod
    public void SetUp(){

        usuario = new Usuario("Juan" , "123456");
    }

    @Test
    public void ValidarInicioDeSesion(){
        boolean resultado = usuario.login("123456");
        Assert.assertTrue(resultado,"La contraseña es incorrecta");

        Assert.assertTrue(usuario.isEstaLogueado(),"El usuario no se logueo de manera correcta");



    }

    @Test
    public void ValidarInicioDeSesionConCredencialesInvalidas(){
        boolean resultado = usuario.login("hdhgdgdgd");

        Assert.assertFalse(resultado, "El usuario ingreso la contraseña correcta");

        Assert.assertFalse(usuario.isEstaLogueado(),"El usuario si se pudo loguear con la credencial invalida");

    }

}
