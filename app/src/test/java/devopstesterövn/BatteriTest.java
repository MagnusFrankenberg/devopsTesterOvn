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

}