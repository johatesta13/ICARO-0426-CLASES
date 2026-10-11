package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSauceDemoTest {

    private WebDriver driver;

    //url de sauce demo

    private static final String BASE_URL = "https://www.saucedemo.com/";

    private static final String USUARIO_STANDARD = "standard_user";
    private static final String USUARIO_BLOQUEADO = "locked_out_user";
    private static final String PASSWORD_CORRECTA = "secret_sauce";
    private static final String PASSWORD_INCORRECTA = "private";

    @BeforeClass
    public void SetUp(){
        //ACA se busca la version compatible con el navegador y descarga automaticamente, la guarda en cache
        WebDriverManager.chromedriver().setup();


        //Crear la instancia del navegador, esto va a abrir una nueva pestaña del navegador


        driver = new ChromeDriver();

        //Maximizar la ventana

        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void IraLogin(){

        driver.get(BASE_URL);
    }

    @Test
    public void loginExitoso(){
        WebElement campoUsuario = driver.findElement(By.id("user-name"));
        campoUsuario.sendKeys(USUARIO_STANDARD);

        //Escribimos contraseña

        WebElement campoPassword = driver.findElement(By.id("password"));
        campoPassword.sendKeys(PASSWORD_CORRECTA);

        WebElement boton = driver.findElement(By.id("login-button"));
        boton.click();

        String urlactual = driver.getCurrentUrl();

        Assert.assertTrue(urlactual.contains("inventory.html"),"Deberia poder ver la pagina principal de inventario");

        System.out.println("Login exitoso, el usuario pudo ingresar");

    }

    @Test
    public void LoginconCredencialesInvalidas(){

        driver.findElement(By.id("user-name")).sendKeys(USUARIO_STANDARD);
        driver.findElement(By.id("password")).sendKeys(PASSWORD_INCORRECTA);
        driver.findElement(By.id("login-button")).click();

        WebElement contenedorError = driver.findElement(By.className("error-message-container"));

        Assert.assertTrue(contenedorError.isDisplayed(), "Deberiamos ver mensaje de error");

        String urlactual = driver.getCurrentUrl();


        Assert.assertFalse(urlactual.contains("inventory.html"),"No deberia iniciar sesion con credenciales incorrectas");
    }
}
