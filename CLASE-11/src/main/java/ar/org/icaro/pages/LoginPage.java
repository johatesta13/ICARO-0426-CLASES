package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private static final String URL = "https://www.saucedemo.com/";

    private By campoUsuario = By.id("user-name");
    private By campoPasword = By.id("password");
    private  By BtnLogin = By.id("login-button");
    private By contendorError = By.xpath("//div[@class='error-message-container error']");


    //CONSTRUCTOR

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Navegacion

    public void goTo(){
        driver.get(URL);
    }

    //Acciones en la pagina

    public LoginPage enterUsuario(String username){

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario));
        input.clear();
        input.sendKeys(username);
        return this;
    }

    public LoginPage enterPass(String pass){

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(campoPasword));
        input.clear();
        input.sendKeys(pass);
        return this;
    }

    public  InventoryPage  clickLogin(){
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(BtnLogin));
        btn.click();
        return new InventoryPage(driver);
    }

    public InventoryPage LoginAs(String usuario, String contra){
        return enterUsuario(usuario).enterPass(contra).clickLogin();
    }


    // Carga credenciales invalidas

    public LoginPage loginExpetedERROR(String usuario, String Contr){
        return enterUsuario(usuario).enterPass(Contr);
    }

    //Verificacion

    public boolean IsErrorDisplayed(){
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(contendorError));
            return error.isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public boolean isUsernameFieldDisplayed() {
        try {
            return driver.findElement(campoUsuario).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordFieldDisplayed() {
        try {
            return driver.findElement(campoPasword).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return driver.findElement(BtnLogin).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentUrl() { //modificador de acceso de la URL
        return driver.getCurrentUrl();
    }

}
