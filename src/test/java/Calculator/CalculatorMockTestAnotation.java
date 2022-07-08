package Calculator;

import mockito.Add;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
 class CalculatorMockTestAnotation {
    @InjectMocks
    private Calculator calculator ;
    @Mock
    private Suma suma;

 /**
    // patrones para trabajar con mockito  en pruebas unitarias.

    //Arrage   o      //Given
    //Act (action)   //When
    //Assert          //Then
   **/
        @BeforeEach
        public void setUp(){
            MockitoAnnotations.openMocks(this);
            //  MockitoAnnotations.initMocks(this);
        }

        @Test
        public void addTest(){
            calculator.setA(3);
            calculator.setB(5);
            calculator.add();
            Mockito.verify(suma).operar(3,5);
        }





    }
