package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //LOCALIZADOR

    private By pageTitle = By.className("title");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Metodo de verificacion

    public boolean isOnInventoryPage(){ //para validar que este la página inventario visible

        try{wait.until(ExpectedConditions.urlContains("inventory"));
            return true;
        }catch (Exception e){
            return false;}
    }

    //Getter para obtener el titulo de la pagina

    public String getInventoryTitle(){
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));

        return title.getText();
    }

}
