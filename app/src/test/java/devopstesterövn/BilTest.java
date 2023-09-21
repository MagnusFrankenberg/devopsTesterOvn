package devopstesterövn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilTest {

    Bil bil;

    @BeforeEach
    void setUp() {
        bil = new Bil();
    }

    @Test
    void testBilExist() {
        assertNotNull(bil);
    }

    @Test
    void testBilHarLyse() {
        assertNotNull(bil.getFramljus());
        assertNotNull(bil.getBakljus());
    }

    @Test
    @DisplayName("Lyset ska gå att sätta på")
    void testLjusPå() {
        bil.getFramljus().setOn(true);
        bil.getBakljus().setOn(true);
        assertTrue(bil.getFramljus().isOn());
        assertTrue(bil.getBakljus().isOn());
    }

    @Test
    @DisplayName("Lyset ska gå att slå av")
    void testLjusAv() {
        bil.getFramljus().setOn(false);
        bil.getBakljus().setOn(false);
        assertFalse(bil.getFramljus().isOn());
        assertFalse(bil.getBakljus().isOn());
    }

    @Test
    @DisplayName("Bilen ska ha halvljus")
    void testHalvljus() {
        bil.getFramljus().setLjusTyp(Ljustyp.HALVLJUS);
        assertEquals(Ljustyp.HALVLJUS, bil.getFramljus().getLjusTyp());
    }

    @Test
    @DisplayName("Bilen ska ha helljus")
    void testHelljus() {
        bil.getFramljus().setLjusTyp(Ljustyp.HELLJUS);
        assertEquals(Ljustyp.HELLJUS, bil.getFramljus().getLjusTyp());
    }

    @Test
    @DisplayName("Bilen ska ha baklyse")
    void testBilHarBakLyse() {
        assertNotNull(bil.getBakljus());
    }

    @Test
    @DisplayName("Bilen ska gå att starta")
    void testKanBilenStartas() {
        bil.setStarted(true);
        assertTrue(bil.isStarted());
    }

    @Test
    @DisplayName("När bilen stängs av ska lysena släckas")
    void testLjusenAvNärBilenStängsAv() {
        bil.setStarted(true);
        bil.setFramljusIsOn(true);
        bil.setBakljusIsOn(true);
        assertTrue(bil.getFramljus().isOn());
        assertTrue(bil.getBakljus().isOn());
        bil.setStarted(false);
        assertFalse(bil.getFramljus().isOn());
        assertFalse(bil.getBakljus().isOn());
    }

    @Test
    @DisplayName("När bilen är avstängd kan lysen ej sättas på")
    void testLysenKanEjSättasPåNärBilÄrAv() {
        bil.setStarted(false);
        assertFalse(bil.isStarted());
        bil.setFramljusIsOn(true);
        bil.setBakljusIsOn(true);
        assertFalse(bil.getFramljus().isOn());
        assertFalse(bil.getBakljus().isOn());
    }

    @Test
    @DisplayName("Varningsblinkers ska alltid gå att använda")
    void testVarningsblinkers() {
        bil.setStarted(true);
        bil.setVarningsBlinkersIsOn(true);
        assertTrue(bil.getVarningsBlinkers().isOn());
        bil.setStarted(false);
        assertTrue(bil.getVarningsBlinkers().isOn());
        bil.setVarningsBlinkersIsOn(false);
        assertFalse(bil.getVarningsBlinkers().isOn());
        bil.setVarningsBlinkersIsOn(true);
        assertTrue(bil.getVarningsBlinkers().isOn());
    }

    @Test
    @DisplayName("Bilen ska kunna gasa")
    void testBilenkanGasa() {
        bil.användPedal(Pedaler.GAS);
        assertEquals(bil.getPedaler(), Pedaler.GAS);
    }

    @Test
    @DisplayName("Bilen ska max köra 180")
    void testLimitKöra180() {
        bil.setHastighet(200);
        assertEquals(180, bil.getHastighet());
        bil.användPedal(Pedaler.GAS);
        assertEquals(180, bil.getHastighet());
    }

    @Test
    @DisplayName("Bromsa till hastighet 0")
    void testBromsTillNoll(){
        bil.setHastighet(180);
        bil.användPedal(Pedaler.BROMS_STOPP);
        assertEquals(0,bil.getHastighet());
    }

    @Test
    @DisplayName("Om bromsa mer än 0 bilen går bakåt")
    void testBromsaMerÄnNoll(){
        bil.setHastighet(10);
        bil.användPedal(Pedaler.BROMS);
        assertEquals(Riktning.BAKÅT,bil.getRiktning());
    }

}