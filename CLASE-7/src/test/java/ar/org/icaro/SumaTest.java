package ar.org.icaro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumaTest {

    @Test
    public void ValidarSumaCero(){
        MATEMATICA m= new MATEMATICA();

      int resultado=  m.suma(5,0);

        Assert.assertEquals(resultado,5,"El resultado al sumar 0 deberia ser el mismo numero");
    }
}
