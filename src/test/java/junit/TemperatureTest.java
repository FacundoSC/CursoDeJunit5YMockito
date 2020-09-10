package junit;

import junit.Temperature;
import org.junit.jupiter.api.*;

public class TemperatureTest {
    Temperature tempC ;

    @BeforeEach
    public void setUp(){
        tempC = new Temperature();
        System.out.println("@BeforeEach -> setUp()");
    }


    @Test
    public void cToFaTest() {
        float tempExp = 34.7f;
        Assertions.assertEquals(tempExp, tempC.convertCelsiusToFahrenheitTemperature(1.5f), "los valores de temperatura no son iguales");
        System.out.println("@Test-> cToFaTest()");
    }



    @AfterEach
    public void tearDown() {
       tempC =null;
       System.out.println("@AfterEach -> tearDown()");
    }






}
