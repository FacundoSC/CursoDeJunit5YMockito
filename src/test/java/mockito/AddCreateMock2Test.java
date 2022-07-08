package mockito;

import Calculator.ValidNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
class AddCreateMock2Test {
  @InjectMocks
  private  Add add ;
  @Mock
  private ValidNumber validNumber;

  @BeforeEach
    public void setUp(){
      MockitoAnnotations.openMocks(this);
    //  MockitoAnnotations.initMocks(this);
  }

  @Test
    public void addTest(){
    add.add(3,2);
    Mockito.verify(validNumber).isNumber(3);
  }




}