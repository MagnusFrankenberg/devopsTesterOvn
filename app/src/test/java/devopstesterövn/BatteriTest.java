package devopstesterövn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteriTest {

    Bil bil;
    Batteri batteri;


    @BeforeEach
    void setUp() {
        bil = new Bil();
        bil.setStarted(true);
        batteri = bil.getBatteri();
    }

    @Test
    @DisplayName("När Bilen Körs Drar Batteri")
    void testdrarBatteriKörs() {
        assertEquals(100,batteri.getBatteriNivå());
        bil.användPedal(Pedaler.GAS);
        bil.användPedal(Pedaler.GAS);
        assertEquals(80,batteri.getBatteriNivå());
    }

    @Test
    @DisplayName("Framlyse drar batteri")
    void testFramlyseDrarBatteri() {
        assertEquals(100,batteri.getBatteriNivå());
        bil.getFramljus().setOn(true);
        assertEquals(95,batteri.getBatteriNivå());
    }

    @Test
    @DisplayName("Baklyse drar batteri")
    void testBaklyseDrarBatteri() {
        assertEquals(100,batteri.getBatteriNivå());
        bil.getBakljus().setOn(true);
        assertEquals(95,batteri.getBatteriNivå());
    }

    @Test
    @DisplayName("Varningslyse drar batteri")
    void testVarningslyseDrarBatteri() {
        assertEquals(100,batteri.getBatteriNivå());
        bil.getVarningsBlinkers().setOn(true);
        assertEquals(95,batteri.getBatteriNivå());
    }

    @Test
    @DisplayName("Bromsljus drar batteri")
    void testBromsljusDrarBatteri() {
        assertEquals(100,batteri.getBatteriNivå());
        bil.getBromsljus().setOn(true);
        assertEquals(95,batteri.getBatteriNivå());
    }






}