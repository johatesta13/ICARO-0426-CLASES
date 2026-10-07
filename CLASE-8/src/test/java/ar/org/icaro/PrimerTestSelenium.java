package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PrimerTestSelenium {

    private WebDriver driver;


    @BeforeClass
    public void SetUp(){
 //ACA se busca la version compatible con el navegador y descarga automaticamente, la guarda en cache
        WebDriverManager.chromedriver().setup();


        //Crear la instancia del navegador, esto va a abrir una nueva pestaña del navegador


        driver = new ChromeDriver();

        //Maximizar la ventana

        driver.manage().window().maximize();


    }


    @Test
    public void NavegarASauceDemo(){

        //Metodo para ir a la pagina
        driver.get("https://www.saucedemo.com/");

        //Obtener el titulo

        String titulo = driver.getTitle();

        Assert.assertEquals(titulo, "Swag Labs","El titulo no coincide");

        System.out.println("Navegamos a sauce demo de manera correcta");



    }


    

    @AfterClass
    public void tearDown() throws InterruptedException{

        Thread.sleep(3000);

        if(driver !=null){
            driver.quit();

        }


    }


}
