package ghettorraria.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

import ghettorraria.modele.Bloc;


public class CollisionsTest {
    
    Bloc blocT = new Bloc(1,0);
    Bloc blocF = new Bloc(-1,1);
    @Test
    public void solideTest(){
        assertTrue(blocT.estSolide());
        assertFalse(blocF.estSolide());
    }
}
