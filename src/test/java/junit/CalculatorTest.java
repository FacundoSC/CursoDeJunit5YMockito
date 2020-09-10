package junit;

import junit.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator instancia;
   static Calculator instanciaEstatica;
    int x, y;




    @BeforeAll
    public static void beforeAllTest(){
        instanciaEstatica = new Calculator();
        System.out.println("@BeforeAll --> beforeAllTest()");

    }
    @BeforeEach
    public void setUp(){
        instancia = new Calculator();
        x =6 ;
        y = 2;
        System.out.println("@BeforeEach --> setUp()");
    }

    @AfterEach
    public void tearDown(){
        this.instancia= null;
        System.out.println("@AfterEach --> tearDown()");
    }

    @AfterAll
    public static void afterAllTest(){
        instanciaEstatica = new Calculator();
        System.out.println("@afterAllTest() --> afterAllTest()");

    }





    @Test
    @DisplayName(" nombre del display")
    public void calculatorNotNullTest(){
        assertNotNull(instanciaEstatica,"la referencia al objeto junit.Calculator es null");
        assertNotNull(this.instancia,"la referencia al objeto Calculator es null");
        System.out.println("@Test -->  calculatorNotNullTest()");
    }

    @Test
    public void addValidPositiveResultTest(){

        int esperado = 5;
        int actual = instancia.add(3,2);
        assertEquals(esperado,actual,"el resultado esperado y el actual  de la suma no coinsiden");
        System.out.println("@Test --> addValidPositiveResultTest()");
    }

    @Test
    public void addAssertAllTest(){

        assertAll(
                ()-> assertEquals(3,3),
                ()->assertEquals(3,1),
                ()->assertEquals(5,2)
                );
    }

    @Test
    public void addValidNegativeResultTest(){

        int esperado = -1;
        int actual = instancia.add(-3,2);
        assertEquals(esperado,actual,"el resultado esperado y el actual  de la suma no coinciden");
        System.out.println("@Test --> addValidNegativeResultTest())");
    }

    @Test
    public void assertTypesTest(){

        assertTrue(1==1);

        assertFalse(1==2);

        assertNotEquals(1,2,"los numeros son iguales");

        assertSame(this.instancia,this.instancia);

        assertEquals(1.2,1.6,0.5,"no son iguales");
        System.out.println("@Test --> assertTypesTest(");
    }

    @Test
    public void divide_InvalidInputTest(){

        int esperado = 3;
        if(y == 0){ this.divideZero_InvalidInputTest_ExceptionOutput();}
        else {
            int actual = instancia.divide(x, y);
            assertEquals(esperado,actual,"el resultado esperado y actual de la división no coinciden");
            System.out.println("@Test --> divide_InvalidInputTest()");
        }
    }


    @Test
    private void divideZero_InvalidInputTest_ExceptionOutput(){
        assertThrows(ArithmeticException.class,()->instancia.divideZero(x,y));
        System.out.println("@Test --> divideZero_InvalidInputTest_ExceptionOutput()");
        System.out.println("el denominador es cero");
    }


    @Test
    public void divide_InvalidInputZeroTest(){
        int esperado = 3;
        if(y == 0){ this.divideZero_InvalidInputTest_ExceptionOutput();}
        else {
            int actual = instancia.divide(x, y);
            assertEquals(esperado,actual,"el resultado esperado y actual de la división no coinciden");
            System.out.println("@Test --> divide_InvalidInputTest()");
        }
    }


    @Nested
     public class addTest{
        @Test
        public void add_Positive_Test(){
            assertEquals(30,instancia.add(15,15));
        }
        @Test
        public void add_Negative_Test(){
            assertEquals(-30,instancia.add(-15,-15));
        }
        @Test
        public void add_cero_Test(){
            assertEquals(0,instancia.add(0,0));
        }

    }


    @MethodSource("addSorceData")

    @ParameterizedTest(name ="{index} : a={0},b={1},suma={2}")
    public void addParameterizedTest(int a ,int c,int suma){
        assertEquals(suma,instanciaEstatica.add(a,c),"el resultado esperado y el actual  de la suma no coinsiden");

    }


 private static Stream<Arguments> addSorceData(){
    return Stream.of(
            Arguments.of(6,2,8),
            Arguments.of(-6,-2,-8),
            Arguments.of(-6,2,-4),
            Arguments.of(6,-2,4),
            Arguments.of(6,0,6)
            );
 }

    @Test
    public void logTimeTest(){

        assertTimeout(Duration.ofMillis(500),()->instanciaEstatica.longTimeTask(),"la ejecución demoro mas de el tiempo estimado");

    }
        @ParameterizedTest(name = "{index} : esperado={0},actual={1}")
        @DisplayName("calculate string length")
        @MethodSource("lengthString")
        void lengthOfStrings(int esperado, int actual) throws Exception {
            Assertions.assertEquals(esperado, actual);
        }

    private static Stream<Arguments> lengthString(){
        return Stream.of(
                Arguments.of(0,"".length()),
                Arguments.of(4,"java".length()),
                Arguments.of(6,"groovy".length()),
                Arguments.of(2,"go".length())
        );
    }



}
