package devopstesterövn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaddareTest {

    Laddare laddare;
    Bil bil;

    @BeforeEach
    void setUp(){
        laddare = new Laddare();
        bil = new Bil();
    }

    @Test
    @DisplayName("Laddaren laddar Bilar")
    void testLaddarenLaddarBilar(){
        bil.getBatteri().setBatteriNivå(10);
        assertEquals(10,bil.getBatteri().getBatteriNivå());
        laddare.setAnslutenBil(bil);
        laddare.laddaBilensBatteri();
        assertEquals(100,bil.getBatteri().getBatteriNivå());
    }

    @Test
    @DisplayName("Det går att ansluta bilar")
    void testDetGårAttAnslutaBilar(){
        laddare.setAnslutenBil(bil);
        assertNotNull(laddare.getAnslutenBil());
    }

    @Test
    @DisplayName("Om En Bil Är Ansluten Kan Den Laddas")
    void testOmEnBilÄRAnslutenKanDenLaddas(){
        bil.getBatteri().setBatteriNivå(10);
        laddare.setAnslutenBil(bil);
        laddare.laddaBilensBatteri();
        assertEquals(100,bil.getBatteri().getBatteriNivå());
    }

    @Test
    @DisplayName("Om en bil är fullladdad slutar laddningen automatiskt")
    void testLaddningSlutarAutomatisktNärFullladdad(){
        bil.getBatteri().setBatteriNivå(10);
        laddare.setAnslutenBil(bil);
        laddare.laddaBilensBatteri();
        assertEquals(100,bil.getBatteri().getBatteriNivå());
        assertFalse(laddare.isLaddar());
    }

    @Test
    @DisplayName("Hur många iterationer krävs för att ladda")
    void testLaddarenSägerAntaletIterationerFörAttLadda(){
        bil.getBatteri().setBatteriNivå(15);
        laddare.setAnslutenBil(bil);
        assertEquals(9,laddare.iterationsNeeded());
    }

    @Test
    @DisplayName("När laddningen är klar skrivs kostnaden ut")
    void testPrisetSkrivsUtNärLaddningKlar(){
        bil.getBatteri().setBatteriNivå(10);
        laddare.setAnslutenBil(bil);
        assertEquals("Pris: 45",laddare.laddaBilensBatteri());
    }

}