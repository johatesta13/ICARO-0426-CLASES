package ar.org.icaro;

import ar.org.icaro.pages.CartPage;
import ar.org.icaro.pages.CheckoutPage;
import ar.org.icaro.pages.InventoryPage;
import ar.org.icaro.pages.LoginPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlujoCompletoSauceDemo {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void SetUp(){
        //ACA se busca la version compatible con el navegador y descarga automaticamente, la guarda en cache
        WebDriverManager.chromedriver().setup();


        //Crear la instancia del navegador, esto va a abrir una nueva pestaña del navegador


        driver = new ChromeDriver();

        //Maximizar la ventana

        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(3000);

        if(driver !=null){
            driver.quit();

        }
    }

    @Test
    public void CompraCompletaE2E(){


        System.out.println("PASO 1: Login");
        InventoryPage inventoryPage = loginPage.goTo().LoginAs("standard_user","secret_sauce");

        Assert.assertTrue(inventoryPage.isOnInventoryPage(),"Deberia estar en la pagina de inventario");

        //Paso 2 agregar productos al carrito

        System.out.println("PASO 2: AGREGANDO ARTICULOS AL CARRITO");

        inventoryPage.agregarRemera().agregarLuzbici();

        Assert.assertEquals(inventoryPage.getCartBadge(),2,"El carrito deberia tener dos articulos");

        System.out.println("Productos agregados correctamente");

        //PAS0 3: IR AL CARRITO
        System.out.println("PASO 3: IR AL CARRITO");
        CartPage cart = inventoryPage.goToCart();

        Assert.assertTrue(cart.isOncartPage(),"Deberia estar en la pagina de carrito");

       Assert.assertEquals(cart.GetitemCount(),2,"En el carrito deberian estar los articulos agregados anteriormente");

        System.out.println("El carrito sigue teniendo dos items");

        //CHECKOUT
        System.out.println("PASO 4: IR AL CHECKOUT");
        CheckoutPage checkoutPage = cart.checkoutBtn();
        System.out.println("Viaje al checkout");

        //Paso 5 completar info
        System.out.println("PASO 5: LLENANDO EL FORMULARIO DE CHECKOUT");
        checkoutPage.completeFormCheckout("JUAN","PEREZ","59000");
        System.out.println("Primera parte del checkout completada");

        //Paso 6
        System.out.println("PASO 6: HACER CLICK EN FINALIZAR");
        checkoutPage.clickFinish();
        Assert.assertTrue(checkoutPage.IsorderComplete(),"Fallo al crear la orden");
        Assert.assertEquals(checkoutPage.getConfirmationMessage(),"Thank you for your order!","El mensaje esperado es diferente");

        System.out.println("FLUJO FINALIZADO EXITOSO");

        System.out.println("FIN DEL TEST E2E");



    }
}
