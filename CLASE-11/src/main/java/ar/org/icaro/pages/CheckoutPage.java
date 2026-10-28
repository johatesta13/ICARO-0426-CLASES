package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{


    private By firstNameField = By.id("first-name");
    private By LastNameField = By.id("last-name");
    private By ZipCodeField = By.id("postal-code");
    private By CancelBtn = By.id("cancel");
    private By ContinueBtn = By.id("continue");
    private By ErrorMsg = By.cssSelector("h3[data-test='error']");

    // Step 2 de la pagina de checkout

    private By finishButton = By.id("finish");
    private By summarySubtotal =By.className("summary_subtotal_label");
    private By summaryTax = By.className("summary_tax_label");
    private By summarytotal = By.className("summary_total_label");


    //Step 3 de la pagina de checkout
    private By confirmation = By.className("complete-header");
    private By Textadicional = By.className("complete-text");
    private By backHome = By.id("back-to-products");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String texto){
        type(firstNameField, texto);
        return this;
    }
    public CheckoutPage enterLastName (String texto){
        type(LastNameField, texto);
        return this;
    }
    public CheckoutPage enterPostalCode (String texto){
        type(ZipCodeField, texto);
        return this;
    }

    public CheckoutPage clickContinue(){
        click(ContinueBtn);
        return this;
    }

    public CartPage clickCancel(){
        click(CancelBtn);
        return new CartPage(driver);
    }

    public CheckoutPage completeFormCheckout(String Nombre, String Apellido, String CP){
        enterFirstName(Nombre);
        enterLastName(Apellido);
        enterPostalCode(CP);
        clickContinue();
        return this;
    }

    //Resumen de la compra
    public CheckoutPage clickFinish(){
        click(finishButton);
        return this;
    }

    public String getSubtotal(){

        return getText(summarySubtotal);
    }

    public String getTax(){

        return getText(summaryTax);
    }
    public String gettotal(){

        return getText(summarytotal);
    }

    //Ultimo step confirmacion de la orden

    public String getConfirmationMessage(){

        return getText(confirmation);
    }
    public String GetConfirmationText(){

        return getText(Textadicional);
    }

    public InventoryPage clickBackHome(){
        click(backHome);
        return new InventoryPage(driver);
    }

    //Metodos de validacion
    public boolean IsorderComplete(){
        try {
            String message = getConfirmationMessage();

            return message.contains("Thank you");
        }catch (Exception e){
            return false;
        }
    }

    public boolean IsErrorMessegeDisplayed(){
        return isElementVisible(ErrorMsg);
    }


}
