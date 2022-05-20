package ghettorraria.modele;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Collisions {

    private Bloc bloc;
    private Terrain terrain;

    public Collisions(Bloc bloc, Terrain terrain) {
        this.bloc = bloc;
        this.terrain = terrain;
    }

    public Collisions(Bloc bloc) {
        this.bloc = bloc;
    }

    public boolean solide() {
        boolean estSolide;
        if (this.bloc.getId() != -1) {
            estSolide = true;
        } else {
            estSolide = false;
        }
        return estSolide;
    }

    public ArrayList<Rectangle> getRectangles() {
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

        for (int ligne = 0; ligne < this.terrain.getHauteur(); ligne++) {
            for (int colonne = 0; colonne < this.terrain.getLargeur(); colonne++) {
                if (this.terrain.getCodesTuiles().get(ligne)[colonne].getId() != -1) {
                    rectangles.add(new Rectangle(colonne * 32, ligne * 32, 32, 32));
                }
            }
        }

        return rectangles;
    }

}
