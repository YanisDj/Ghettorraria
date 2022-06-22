package ghettorraria.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.*;

import ghettorraria.modele.Bloc;
import ghettorraria.modele.Joueur;
import ghettorraria.modele.Terrain;
import ghettorraria.modele.item.CapriSun;
import ghettorraria.modele.item.Kebab;
import ghettorraria.modele.item.Pioche;

public class JoueurTest {

    //initialisation des variables
    Terrain terrain = new Terrain();
    Joueur joueur = new Joueur(terrain, null);
    Bloc bloc = new Bloc(1,0);
    Pioche pioche = new Pioche();
    CapriSun caprisun = new CapriSun();
    Kebab kebab = new Kebab();
    
    @Test
    public void utiliserPiocheEnMainTest(){
        terrain.getCodesTuiles().set(5, bloc);
        
        joueur.setObjetMainPourTest(pioche);
        joueur.utiliser(160,0);
        assertEquals(5, bloc.getPv());
    }

    @Test
    public void utiliserNourritureEnMainTest(){
        terrain.getCodesTuiles().set(5, bloc);

        joueur.setObjetMainPourTest(caprisun);
        joueur.utiliser(160,0);
        assertEquals(50, joueur.getPv());

        joueur.setObjetMainPourTest(kebab);
        joueur.utiliser(160,0);
        assertEquals(100, joueur.getPv());

        //test si le joueur a deja les pv au max
        joueur.setObjetMainPourTest(caprisun);
        joueur.utiliser(160,0);
        assertEquals(100, joueur.getPv());
        joueur.setObjetMainPourTest(kebab);
        joueur.utiliser(160,0);
        assertEquals(100, joueur.getPv());
    }
}
