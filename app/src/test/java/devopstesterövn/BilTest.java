package devopstesterövn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilTest {

     Bil bil;

     @BeforeEach
    void setUp(){
         bil = new Bil();
     }

    @Test
    void testBilExist(){
        assertNotNull(bil);
    }

    @Test
    void testBilHarLyse(){
         assertNotNull(bil.getFramljus());
        assertNotNull(bil.getBakljus());
    }

    @Test
    @DisplayName("Lyset ska gå att sätta på")
    void testLjusPå(){
         bil.getFramljus().setOn(true);
         bil.getBakljus().setOn(true);
         assertTrue(bil.getFramljus().isOn());
         assertTrue(bil.getBakljus().isOn());
    }

    @Test
    @DisplayName("Lyset ska gå att slå av")
    void testLjusAv(){
        bil.getFramljus().setOn(false);
        bil.getBakljus().setOn(false);
        assertFalse(bil.getFramljus().isOn());
        assertFalse(bil.getBakljus().isOn());
    }

    @Test
    @DisplayName("Bilen ska ha halvljus")
    void testHalvljus(){
        bil.getFramljus().setLjusTyp(Ljustyp.HALVLJUS);
        assertEquals(Ljustyp.HALVLJUS,bil.getFramljus().getLjusTyp());
    }

    @Test
    @DisplayName("Bilen ska ha helljus")
    void testHelljus(){
        bil.getFramljus().setLjusTyp(Ljustyp.HELLJUS);
        assertEquals(Ljustyp.HELLJUS,bil.getFramljus().getLjusTyp());
    }

    @Test
    void testBilHarBakLyse(){
        assertNotNull(bil.getBakljus());
    }


}