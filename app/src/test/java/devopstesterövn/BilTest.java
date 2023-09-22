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
    @DisplayName("Bilen ska gå att starta")
    void testKanBilenStartas() {
        bil.setStarted(true);
        assertTrue(bil.isStarted());
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
    @DisplayName("Bil ska bara bromsa till noll")
    void testBromsaBaraTillNoll(){
        bil.setHastighet(10);
        bil.användPedal(Pedaler.BROMS);
        assertEquals(0, bil.getHastighet());
    }

    @Test
    @DisplayName("Bil ska ha växel med drive/reverse")
    void testVäxel() {
        bil.setVäxel(Växel.DRIVE);
        assertEquals(Växel.DRIVE,bil.getVäxel());
        bil.setVäxel(Växel.REVERSE);
        assertEquals(Växel.REVERSE,bil.getVäxel());
    }

    @Test
    @DisplayName("Baklänges ska kunna bromsa till noll")
    void testBaklängesBromsTillNoll() {
        bil.setVäxel(Växel.REVERSE);
        bil.setHastighet(10);
        assertEquals(Riktning.BAKÅT,bil.getRiktning());
        bil.användPedal(Pedaler.BROMS);
        assertEquals(0, bil.getHastighet());
    }

    @Test
    @DisplayName("Bilen ska ha ett batteri")
    void testFinnsBatteri() {
        assertNotNull(bil.getBatteri());
    }

    @Test
    @DisplayName("Batteri Slut -> ej öka hastigheten")
    void testbatteriSlutEjÖkaHastighet() {
        bil.getBatteri().setBatteriNivå(0);
        bil.setHastighet(50);
        bil.användPedal(Pedaler.GAS);
        assertEquals(50,bil.getHastighet());
    }


}