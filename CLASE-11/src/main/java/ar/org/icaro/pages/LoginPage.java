package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.openmbean.TabularDataSupport;
import java.time.Duration;

public class LoginPage extends BasePage{
    
    private static final String URL = "https://www.saucedemo.com/";

    private By campoUsuario = By.id("user-name");
    private By campoPasword = By.id("password");
    private  By BtnLogin = By.id("login-button");
    private By contendorError = By.xpath("//div[@class='error-message-container error']");


    //CONSTRUCTOR nuevo con herencia 

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Navegacion

    public LoginPage goTo(){
        driver.get(URL);
        return this;
    }

    //Acciones en la pagina

    public LoginPage enterUsuario(String username){

        type(campoUsuario,username);
        return this;
    }

    public LoginPage enterPass(String pass){

       type(campoPasword,pass);
       return this;
    }

    public  InventoryPage  clickLogin(){
        click(BtnLogin);
        return new InventoryPage(driver);
    }

    public InventoryPage LoginAs(String usuario, String contra){
        enterUsuario(usuario);
        enterPass(contra);
        return clickLogin();
    }


    // Carga credenciales invalidas

    public LoginPage loginExpetedERROR(String usuario, String Contr){
        enterUsuario(usuario);
        enterPass(Contr);
        click(BtnLogin);
        return this;
    }

    //Verificacion

    public boolean IsErrorDisplayed(){
       return isElementVisible(contendorError);
    }

    public boolean isUsernameFieldDisplayed() {
      return isElementVisible(campoUsuario);
    }

    public boolean isPasswordFieldDisplayed() {
        return isElementVisible(campoPasword);
    }

    public boolean isLoginButtonDisplayed() {
     return   isElementVisible(BtnLogin);

    }

    public String getCurrentUrl() { //modificador de acceso de la URL
      return getcurrentUrl();
    }

}
