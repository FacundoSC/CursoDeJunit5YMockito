package mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ValidNumberTest {
    private ValidNumber validatorNumber;

    @BeforeEach
    public void setUp(){
        validatorNumber = new ValidNumber();
    }

    @Test
     public void checkNumberValid(){
        assertTrue(validatorNumber.checkNumber(5),"el  numero  ingresado no es valido");
    }

    @Test
    public void checkNumberNegativeValid(){
        assertFalse(validatorNumber.checkNumber(-5),"el numero ingresado es valido ");
    }
    @Test
    public void checkStringValid(){
        assertFalse(validatorNumber.checkNumber("5"),"el numero ingresado es valido");
    }

   @Test
    public void ckeckZeroValidObjectTest() {
        assertEquals(true, validatorNumber.checkZero(-30));
    }

    @Test
    public void ckeckZeroInvalidObjectTest()
    {
        assertEquals(false, validatorNumber.checkZero("facundo"));
    }

    @Test
    public void ckeckZeroCeroNumberTest()
    {
        assertThrows(ArithmeticException.class,()->validatorNumber.checkZero(0));
    }


    @Test
    @Deprecated
    public void ckeckZeroCeroNumberPatronWhenThrowExceptionTest()
    {
       when(validatorNumber.checkZero(0)).thenThrow(new ArithmeticException());
       try{
           validatorNumber.checkZero(0);
       }
       catch (ArithmeticException exceptionMockeada){
           assertEquals(ArithmeticException.class,exceptionMockeada.getClass());

       }
    }

    @Test
    public void ckeckZeroCeroNumberMessageTest()
    {
        ArithmeticException thrown = assertThrows(ArithmeticException.class,()->validatorNumber.checkZero(0));
        assertEquals("no se puede recibir un cero", thrown.getMessage());
    }

    @Test
    public void ckeckZeroCeroNumberMessage2Test()
    {
        try {
            validatorNumber.checkZero(0);
            fail("se envio el valor cero");
             }
        catch ( ArithmeticException ex){
             assertEquals("no se puede recibir un cero",ex.getMessage());
           }
    }

    @Test
    public void  doubleToIntegerTest(){
        assertEquals(9,validatorNumber.doubleTointeger(9.99999));
    }

    @Test
    public void  doubleToIntegerErrorTest(){
        assertEquals(0,validatorNumber.doubleTointeger("9.99999"));
    }


    @AfterEach
    public void tearDown(){
        this.validatorNumber = null;
    }

}