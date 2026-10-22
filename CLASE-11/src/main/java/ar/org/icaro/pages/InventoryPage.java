package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage extends BasePage{

    private By pageTitle = By.className("title");
    private By CartIcon = By.className("shopping_cart_link");
    private By addBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By addTshirtBtn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By menuHBtn = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");
    private By cartBadge = By.className("shopping_cart_badge");


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Metodo de verificacion

    public boolean isOnInventoryPage(){ //para validar que este la página inventario visible
          return waitUrlContains("inventory");
    }

    //Getter para obtener el titulo de la pagina

    public String getInventoryTitle(){
       return getText(pageTitle);
    }

    public InventoryPage AniadirMochila(){
        click(addBackPack);
        return this;
    }
    public InventoryPage agregarLuzbici(){
        click(addBikeLight);
        return this;
    }
    public InventoryPage agregarRemera(){
        click(addTshirtBtn);
        return this;
    }
    //Redireccion hacia otras partes del flujo

    public CartPage goToCart(){
        click(CartIcon);
        return new CartPage(driver);
    }

    public LoginPage logout(){
        wait.until(ExpectedConditions.elementToBeClickable(menuHBtn));
        click(menuHBtn);
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        click(logout);

        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("inventory")));
        return new LoginPage(driver);
    }

    public int getCartBadge(){
        try {
            String cartbadge = getText(cartBadge);
            return Integer.parseInt(cartbadge);
        }catch (Exception e){
            return 0;
        }

    }




}
