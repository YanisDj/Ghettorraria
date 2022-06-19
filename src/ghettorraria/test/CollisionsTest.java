package ghettorraria.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

import ghettorraria.modele.Bloc;
import ghettorraria.modele.Collisions;

public class CollisionsTest {
    
    Bloc blocT = new Bloc(1, 0, 0);
    Bloc blocF = new Bloc(-1, 0, 1);
    Collisions colT = new Collisions(blocT);
    Collisions colF = new Collisions(blocF);

    @Test
    public void solideTest(){
        assertTrue(colT.solide());
        assertFalse(colF.solide());
    }
}
