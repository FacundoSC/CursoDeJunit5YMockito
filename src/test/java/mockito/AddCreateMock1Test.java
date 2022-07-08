package mockito;

import Calculator.ValidNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AddCreateMock1Test {

    private Add add;
    private ValidNumber validNumber;

    /***
     * lo que podemos hacer es  burlar  al objeto Add , para que en vez de recibir un validNumber
     * reciba un mock, con el objetivo que probar la funcionalidad de  add sin  importar la funcionalidad
     * de los objetos  de los cuales esta instancia depende. validNumber es en este ejemplo un objeto del cual depende
     * el objeto add
     *
     */
    @BeforeEach
    void setUp() {
        validNumber = Mockito.mock(ValidNumber.class);
        add = new Add(validNumber);
    }
    @Test
    public void addTest(){
       add.add(3,2);
       Mockito.verify(validNumber).isNumber(3); // lo hace con el primer elemento
       //Mockito.verify(validNumber).checkNumber(2);
    }

    @AfterEach
    void tearDown() {
        add = null;
    }
}