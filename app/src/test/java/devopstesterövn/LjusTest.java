package devopstesterövn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LjusTest {


    Bil bil;
    Framljus framljus;
    Bakljus bakljus;
    VarningsBlinkers varningsBlinkers;

    @BeforeEach
    void setUp() {
        bil = new Bil();
        framljus = bil.getFramljus();
        bakljus = bil.getBakljus();
        varningsBlinkers = bil.getVarningsBlinkers();
    }

    @Test
    @DisplayName("Bil har lyse")
    void testBilHarLyse() {
        assertNotNull(framljus);
        assertNotNull(bakljus);
    }

    @Test
    @DisplayName("Lyset ska gå att sätta på")
    void testLjusPå() {
        bil.setStarted(true);
        framljus.setOn(true);
        bakljus.setOn(true);
        assertTrue(framljus.isOn());
        assertTrue(bakljus.isOn());
    }

    @Test
    @DisplayName("Lyset ska gå att slå av")
    void testLjusAv() {
        framljus.setOn(false);
        bakljus.setOn(false);
        assertFalse(framljus.isOn());
        assertFalse(bakljus.isOn());
    }

    @Test
    @DisplayName("Bilen ska ha halvljus")
    void testHalvljus() {
        framljus.setLjusTyp(Ljustyp.HALVLJUS);
        assertEquals(Ljustyp.HALVLJUS, framljus.getLjusTyp());
    }

    @Test
    @DisplayName("Bilen ska ha helljus")
    void testHelljus() {
        framljus.setLjusTyp(Ljustyp.HELLJUS);
        assertEquals(Ljustyp.HELLJUS, framljus.getLjusTyp());
    }

    @Test
    @DisplayName("Bilen ska ha baklyse")
    void testBilHarBakLyse() {
        assertNotNull(bakljus);
    }

    @Test
    @DisplayName("När bilen stängs av ska lysena släckas")
    void testLjusenAvNärBilenStängsAv() {
        bil.setStarted(true);
        framljus.setOn(true);
        bakljus.setOn(true);
        assertTrue(framljus.isOn());
        assertTrue(bakljus.isOn());
        bil.setStarted(false);
        assertFalse(framljus.isOn());
        assertFalse(bakljus.isOn());
    }


    @Test
    @DisplayName("När bilen är avstängd kan lysen ej sättas på")
    void testLysenKanEjSättasPåNärBilÄrAv() {
        bil.setStarted(false);
        assertFalse(bil.isStarted());
        framljus.setOn(true);
        bakljus.setOn(true);
        assertFalse(framljus.isOn());
        assertFalse(bakljus.isOn());
    }

    @Test
    @DisplayName("Varningsblinkers ska alltid gå att använda")
    void testVarningsblinkers() {
        bil.setStarted(true);
        varningsBlinkers.setOn(true);
        assertTrue(varningsBlinkers.isOn());
        bil.setStarted(false);
        assertTrue(varningsBlinkers.isOn());
        varningsBlinkers.setOn(false);
        assertFalse(varningsBlinkers.isOn());
        varningsBlinkers.setOn(true);
        assertTrue(varningsBlinkers.isOn());
    }

}