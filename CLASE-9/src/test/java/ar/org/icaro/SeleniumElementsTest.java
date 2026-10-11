package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumElementsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "https://the-internet.herokuapp.com";


    @BeforeMethod
    public void SetUp(){
        //ACA se busca la version compatible con el navegador y descarga automaticamente, la guarda en cache
        WebDriverManager.chromedriver().setup();


        //Crear la instancia del navegador, esto va a abrir una nueva pestaña del navegador


        driver = new ChromeDriver();

        //Maximizar la ventana

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }

    @Test(priority = 1, description = "Establecemos waits y hacemos manejo de esperas")
    public void esperaExplicita(){

        driver.get(BASE_URL + "/dynamic_loading/1");

        WebElement boton = driver.findElement(By.cssSelector("div[id='start'] button"));
        boton.click();

        //Esperar que aparezca el texto despues del spinner

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        WebElement textofinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));

        Assert.assertEquals(textofinal.getText(),"Hello World!", "Se esperaba que los textos coincidan");

    }


    /*
       Lista de desplegables con la clase select
    *
    *
    *
    * */

        @Test(priority = 2, description = "Seleccionando y manejando elementos dropdown con la clase select")
        public void DropDownText(){

            driver.get(BASE_URL + "/dropdown");

            WebElement dropdown = driver.findElement(By.id("dropdown"));

            Select seleccion = new Select(dropdown);

            seleccion.selectByVisibleText("Option 1");

            String opcionSeleccionada = seleccion.getFirstSelectedOption().getText();

            Assert.assertEquals(opcionSeleccionada, "Option 1", "La opcion esperada no coincide con la seleccionada");


        }


        /*
         * CheckBOX y patron seguro con isSelected()
         *
         * */

        @Test(priority = 3,description = "Trabajando con seleccion en checkboxes")
        public void checkboxTest(){


            driver.get(BASE_URL + "/checkboxes");

            WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

            if(!checkBox1.isSelected()){

                checkBox1.click();
            }

            Assert.assertTrue(checkBox1.isSelected(),"El elemento no pudo ser seleccionado");



        }


        /*
         * MANEJO DE ALERTAS DE JAVASCRIPT
         *
         *
         *
         * */

        @Test(priority = 4, description = "Manejo de alertas de java script")
        public void JavascriptAlerts(){

            driver.get(BASE_URL + "/javascript_alerts");

            WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            confirmButton.click();

            //Esperar a que la alerta este presente

            wait.until(ExpectedConditions.alertIsPresent());

            org.openqa.selenium.Alert alert = driver.switchTo().alert();

            String alertText = alert.getText();

            Assert.assertEquals(alertText,"I am a JS Confirm", "El texto esperado no es el correcto");

            alert.accept();

            WebElement resultText = this.driver.findElement(By.id("result"));
            Assert.assertEquals(resultText.getText(), "You clicked: Ok", "El mensaje resultante de la alerta es incorrecto.");

        }

        @Test(
                priority = 5,
                description = "Gestion de Window Handles para cambiar el foco entre pestanas/ventanas"
        )
        public void multipleWindowsTest() {
            this.driver.get(BASE_URL + "/windows");
            String originalWindowHandle = this.driver.getWindowHandle();
            this.driver.findElement(By.linkText("Click Here")).click();
            this.wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            for(String windowHandle : this.driver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindowHandle)) {
                    this.driver.switchTo().window(windowHandle);
                    break;
                }
            }

            WebElement newWindowHeader = this.driver.findElement(By.tagName("h3"));
            Assert.assertEquals(newWindowHeader.getText(), "New Window", "El encabezado de la nueva ventana no es el esperado.");
            this.driver.close();
            this.driver.switchTo().window(originalWindowHandle);
            Assert.assertEquals(this.driver.getWindowHandle(), originalWindowHandle, "No se regreso correctamente a la ventana original.");
        }

        @Test(
                priority = 6,
                description = "Cambio de contexto a iFrames embebidos y retorno al documento principal"
        )
        public void iframeTest() {
            this.driver.get("https://the-internet.herokuapp.com/iframe");
            this.driver.switchTo().frame("mce_0_ifr");
            WebElement editorBody = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
            Assert.assertEquals(editorBody.getText(), "Your content goes here.", "El texto dentro del iframe no coincide.");
            this.driver.switchTo().defaultContent();
        }

        @Test(
                priority = 7,
                description = "Interacciones avanzadas como Hover con Actions y Scroll con JavascriptExecutor"
        )
        public void actionsAndJsExecutorTest() {
            this.driver.get("https://the-internet.herokuapp.com/hovers");
            WebElement userAvatar = this.driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
            Actions actions = new Actions(this.driver);
            actions.moveToElement(userAvatar).perform();
            WebElement profileLink = this.driver.findElement(By.xpath("//h5[text()='name: user1']"));
            Assert.assertTrue(profileLink.isDisplayed(), "El elemento revelado tras el hover no es visible.");
            JavascriptExecutor js = (JavascriptExecutor)this.driver;
            WebElement footer = this.driver.findElement(By.id("page-footer"));
            js.executeScript("arguments[0].scrollIntoView(true);", new Object[]{footer});
            Assert.assertTrue(footer.isDisplayed(), "El footer no esta visible tras el scroll.");
        }




    }




