package mockito;

import Calculator.ValidNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AddTest {
    //Arrage
    @InjectMocks
    private  Add add ;
    @Mock
    private ValidNumber validNumber;
    @Mock
    private Print print;

    @Captor
    private ArgumentCaptor<Integer> capturador;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addTest(){
        /* patron when  then Return */
        for ( int i =0 ; i<=10 ; i++) {
            when(validNumber.isNumber(i)).thenReturn(true);
        }
        assertEquals(12,add.add(3,9));
    }

    @Test
    public void addPatronWhenReturnMethodRealTest(){
        when(validNumber.isNumber(3)).thenCallRealMethod();
        assertEquals(true,validNumber.isNumber(3));

        when(validNumber.isNumber("3")).thenCallRealMethod();
        assertEquals(false,validNumber.isNumber("3"));

    }

     @Test
    public void addDoubletoIntTest(){
         Answer<Integer> answer = new Answer<Integer>() {
             @Override
             public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                 return 7;
             }
         };
         when(validNumber.doubleTointeger(7.7)).thenAnswer(answer);
         assertEquals(14, add.addInt(7.7,7.7));
     }

     // patrones para trabajar con mockito  en pruebas unitarias.

    //Arrage   o      //Given
    //Act (action)   //When
    //Assert          //Then
    @Test
    public void patterTest(){
        //Arrage
        when(validNumber.isNumber(4)).thenReturn(true);
        when(validNumber.isNumber(5)).thenReturn(true);
        //Act
        int resultado = add.add(4,5);
        //Assert
        assertEquals(9,resultado);
    }

    @Test
    public void patterBDDTest(){
        //Given
        given(validNumber.isNumber(4)).willReturn(true);
        given(validNumber.isNumber(5)).willReturn(true);
        //When
        int resultado = add.add(4,5);
        //Then
        assertEquals(9,resultado);
    }
    @Test
    public void argumentMarcherTest(){
        //Given
        given(validNumber.isNumber(anyInt())).willReturn(true);
        //When
        int resultado = add.add(4,5);
        //Then
        assertEquals(9,resultado);
    }

    @Test
    public void addPrintTest(){
        //Given
        given(validNumber.isNumber(4)).willReturn(true);
        given(validNumber.isNumber(5)).willReturn(true);
        //When
        add.addMessage(4,5);
        //then
        //verify(validNumber).checkNumber(4);
        //verify(validNumber).checkNumber(5);
        //verify(validNumber, times(2)).checkNumber(4);
        //verify(validNumber,never()).checkNumber(-99);
        //verify(validNumber,atLeastOnce()).checkNumber(4);
        //verify(validNumber,atLeast(1)).checkNumber(5);
        //verify(validNumber,atMostOnce()).checkNumber(4);
        verify(validNumber,atMost(2)).isNumber(4);
        verify(print).showMessage(9);
        verify(print,never()).showError();
    }

    @Test
    public void captorTest(){
        //given
        given(validNumber.isNumber(4)).willReturn(true);
        given(validNumber.isNumber(5)).willReturn(true);
        //when
        add.addMessage(4,5);
        //then
        verify(print).showMessage(capturador.capture());
        assertEquals(capturador.getValue(),9);
    }

    //given
    @Spy
    List <String> spyList = new ArrayList<>();
    @Mock
    List<String> mockList = new ArrayList<>();

    @Test
    public void spyTest() {
        //when
        spyList.add("1");
        spyList.add("2");
        //then
        verify(spyList).add("1");
        verify(spyList).add("2");
        assertEquals(2,spyList.size());
    }

    @Test
    public void mockTest() {
       given(mockList.size()).willReturn(2);
        //when
        mockList.add("1");
        mockList.add("2");
        mockList.add("3");


        //then
        verify(mockList).add("1");
        verify(mockList).add("2");
        assertEquals(3,mockList.size());
        /* falla , porque   con mock se mockean todos los metodos
         y sin embargo cuando se usa un spy (espia) funciona como un mock , pero
          los metodos funcionan como los reales
         */
    }


}