package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    private By pageTitle = By.className("title");
    private By checkoutBtn = By.id("checkout");
    private By continueShopBtn = By.id("continue-shopping");
    //FIND ELEMENTS
    private By cart_items = By.className("cart_item");

    //Remove btn, hacemos por css selector para borrar cualquier elemento
    //no uno en particular
    private By removeBtn = By.cssSelector("button[id^='remove']");

    private By itemName = By.className("inventory_item_name");

    private By itemPrices = By.className("inventory_item_price");




    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOncartPage(){
        return waitUrlContains("cart");

    }

    public String getTitle(){
        return getText(pageTitle);
    }

    //METODO PARA CONTAR LOS ITEMS DEL CARRITO
    public int GetitemCount(){
        List<WebElement>items = driver.findElements(cart_items);
        return items.size();
    }

    public boolean isCartEmpty(){
        return GetitemCount() == 0;
    }


    //Navegacion hacia otras paginas

    public InventoryPage continueShopping(){
        click(continueShopBtn);
        return new InventoryPage(driver);
    }

    public CheckoutPage checkoutBtn(){
        click(checkoutBtn);
        return new CheckoutPage(driver);
    }



    //METODOS PARA MANEJAR ITEMS
    public CartPage removeFirstItem(){

        List<WebElement> buttons = driver.findElements(removeBtn);

        if(!buttons.isEmpty()){
            buttons.get(0).click();
        }
        return this;
    }

    public CartPage removeAllItems(){
        List<WebElement> buttons = driver.findElements(removeBtn);
        for(WebElement button : buttons ){
            button.click();
        }
        return this;
    }


}
