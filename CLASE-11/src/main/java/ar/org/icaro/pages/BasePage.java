package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;



    //constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    //Metodos comunes entre mis clases o pages

    protected void click (By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    } // click(btnlogin)

    public void type(By locator, String text){

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }//type(campousuario,"standard_user")


    public String getText(By locator){
        return
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isElementVisible(By locator){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public boolean waitUrlContains(String text){
        try {
            wait.until(ExpectedConditions.urlContains(text));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    protected String getcurrentUrl(){
        return driver.getCurrentUrl();
    }


}
