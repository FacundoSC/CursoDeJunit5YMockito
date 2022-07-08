package Calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator instancia;
    static Calculator instanciaEstatica;

    @BeforeAll
    public static void beforeAllTest() {
        instanciaEstatica = new Calculator(new Suma(), new Potencia());
        System.out.println("@BeforeAll --> beforeAllTest()");
    }
    @BeforeEach
    public void setUp() {
        instancia = new Calculator(new Suma(),new Potencia());
        System.out.println("@BeforeEach --> setUp()");
    }
    @AfterEach
    public void tearDown() {
        this.instancia = null;
        System.out.println("@AfterEach --> tearDown()");
    }
    @AfterAll
    public static void afterAllTest() {
        instanciaEstatica = null;
        System.out.println("@afterAllTest() --> afterAllTest()");
    }


    @Test
    @DisplayName("test intancia calculator not null")
    public void calculatorNotNullTest() {
        assertNotNull(instanciaEstatica, "la referencia al objeto Calculator es null");
        assertNotNull(this.instancia, "la referencia al objeto Calculator es null");
        System.out.println("@Test -->  calculatorNotNullTest()");
    }

    @Test
    public void addValidPositiveResultTest() {
        int esperado = 5;
        instancia.setB(2);
        instancia.setA(3);
        int actual = instancia.add();
        assertEquals(esperado, actual, "el resultado esperado y el actual  de la suma no coinciden");
        System.out.println("@Test --> addValidPositiveResultTest()");
    }

    @Test
    public void addAssertAllTest() {
        assertAll(
                () -> assertEquals(3, 3),
                () -> assertEquals(3, 3),
                () -> assertEquals(5, 5)
        );
    }

    @Test
    public void addValidNegativeResultTest() {
        int esperado = -1;
        instancia.setB(2);
        instancia.setA(-3);
        int actual = instancia.add();
        assertEquals(esperado, actual, "el resultado esperado y el actual  de la suma no coinciden");
        System.out.println("@Test --> addValidNegativeResultTest())");
    }

    @Test
    public void assertTypesTest() {
        assertTrue(1 == 1," no son iguales los resultados");
        assertFalse(1 == 2);
        assertNotEquals(1, 2, "los numeros son iguales");
        assertSame(this.instancia, this.instancia);
        assertEquals(1.2, 1.6, 0.5, "no son iguales");
        System.out.println("@Test --> assertTypesTest(");
    }

    @Test
    @DisplayName("Test retardo de una tarea")
    public void logTimeTest() {
        assertTimeout(Duration.ofMillis(2100),()-> instanciaEstatica.longTimeTask(), "la ejecución demoro mas de el tiempo estimado");
    }



    @Test
    public void divideTest() {
        int esperado = 3;
        instancia.setA(6);
        instancia.setB(2);
        int actual = instancia.divide();
        assertEquals(esperado, actual, "el resultado esperado y actual de la división no coinciden");
        System.out.println("@Test --> divide_InvalidInputTest()");
    }


    @Test
    @DisplayName("Test division denominador es cero")
    public void divideInZeroTest() {
        instancia.setB(0);
        assertThrows(ArithmeticException.class, () -> instancia.divide());
        System.out.println("@Test --> divideZero_InvalidInputTest_ExceptionOutput()");
        System.out.println("el denominador es cero");
    }




    /***
     * test anidados en una clase
     */

    @Nested
    public class addTest {
        @Test
        public void add_Positive_Test() {
            instancia.setA(10);
            instancia.setB(20);
            assertEquals(30, instancia.add());
        }
        @Test
        public void add_Negative_Test() {
            instancia.setA(-10);
            instancia.setB(-20);
            assertEquals(-30, instancia.add());
        }
        @Test
        public void add_cero_Test() {
            instancia.setA(0);
            instancia.setB(0);
            assertEquals(0, instancia.add());
        }
    }

    @MethodSource("addSorceData")
    @ParameterizedTest(name = "{index} : a={0},b={1},suma={2}")
    public void addParameterizedTest(int a, int c, int suma) {
        instanciaEstatica.setA(a);
        instanciaEstatica.setB(c);
        assertEquals(suma, instanciaEstatica.add(), "el resultado esperado y el actual  de la suma no coinsiden");
    }
    private static Stream<Arguments> addSorceData() {
        return Stream.of(
                Arguments.of(6, 2, 8),
                Arguments.of(-6, -2, -8),
                Arguments.of(-6, 2, -4),
                Arguments.of(6, -2, 4),
                Arguments.of(6, 0, 6)
        );
    }



    @DisplayName("calculate string length")
    @MethodSource("lengthString")
    @ParameterizedTest(name = "{index} : esperado={0},actual={1}")
    public void lengthOfStrings(int esperado, int actual) {
        Assertions.assertEquals(esperado, actual);
    }

    private static Stream<Arguments> lengthString() {
        return Stream.of(
                Arguments.of(0, "".length()),
                Arguments.of(4, "java".length()),
                Arguments.of(6, "groovy".length()),
                Arguments.of(2, "go".length())
        );
    }


}
