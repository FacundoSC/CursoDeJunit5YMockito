package Calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorMockTest {
    Calculator calculator;
    Suma suma;
    Potencia potencia;

    /***
     * lo que podemos hacer es  burlar  al objeto Add , para que en vez de recibir un validNumber
     * reciba un mock, con el objetivo que probar la funcionalidad de  add sin  importar la funcionalidad
     * de los objetos  de los cuales esta instancia depende. validNumber es en este ejemplo un objeto del cual depende
     * el objeto add
     *
     */
    @BeforeEach
    void setUp() {
        suma = Mockito.mock(Suma.class);
        potencia = Mockito.mock(Potencia.class);
        calculator = new Calculator(suma,potencia);
    }

    /**
     * verifico que solamente pase esos valores
     * no la operacion
     */
    @Test
    public void addTest(){
        calculator.setA(3);
        calculator.setB(5);
        calculator.add();
        Mockito.verify(suma).operar(3,5);
    }

    @Test
    public void addTestMockeado(){
     when(suma.operar(3,5)).thenReturn(90);
     calculator.setA(3);
     calculator.setB(5);
     assertEquals(90,calculator.add(),"no son iguales");
    }

    @Test
    @DisplayName(" Test Mockeado de la funcionalidad potencia")
    public void powMockeado(){
        when(potencia.operar(3,5)).thenReturn(3000);
        calculator.setA(3);
        calculator.setB(5);
        assertEquals(3000,calculator.potencia());
    }

    @Test
    @DisplayName(" Test  de la funcionalidad potencia Original")
    public void powOriginal() {
        when(potencia.operar(3, 5)).thenCallRealMethod();
        calculator.setA(3);
        calculator.setB(5);
        assertEquals(243,calculator.potencia());
    }


        @AfterEach
    void tearDown() {
        calculator = null;
    }
}
