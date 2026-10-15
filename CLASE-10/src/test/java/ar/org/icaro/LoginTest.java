package ar.org.icaro;

import ar.org.icaro.pages.InventoryPage;
import ar.org.icaro.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    private static final Log log = LogFactory.getLog(LoginTest.class);
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

        loginPage.goTo();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(3000);

        if(driver !=null){
            driver.quit();

        }


    }

    //LOGIN CON POM

    @Test
    public void LoginExitosoConPOM(){

        InventoryPage inventoryPage = loginPage.LoginAs("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isOnInventoryPage(),"Deberia haber iniciado sesion correctamente");
        Assert.assertEquals(inventoryPage.getInventoryTitle(), "Products", "Deberia ser el titulo esperado");
    }


}
