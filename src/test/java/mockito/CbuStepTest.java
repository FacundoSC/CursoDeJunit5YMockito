package mockito;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CbuStepTest {
    CbuStep cbu;

    @BeforeEach
     public void setUp(){

       cbu = new CbuStep();
    }

    @Test
    public void cbuTest() {
        String entidad = "28505909";
        assertEquals("CBU OK",cbu.validarDigitoVerificadorBloque1(entidad));
    }

    @AfterEach
    public void tearDown(){
        cbu = null;
    }

}