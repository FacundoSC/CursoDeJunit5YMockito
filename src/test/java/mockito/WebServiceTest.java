package mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class WebServiceTest {
    @InjectMocks
    private WebService webService;
    @Mock
    private Callback callback;

    @BeforeEach
    public void setUp(){
        webService = new WebService();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void loginValidate(){
        assertTrue(webService.checkLogin("Facundo","1234"));
    }


    @Test
    public void loginErrorValidate(){
        assertFalse(webService.checkLogin("Maria","AAA"));
    }

    @Test
    public void loginValidCallbackTest(){
        webService.login("Facundo","1234",callback);
        Mockito.verify(callback).onSuccess("Correct User");

    }

    @AfterEach
    public void tearDown(){
        webService = new WebService();
    }

}