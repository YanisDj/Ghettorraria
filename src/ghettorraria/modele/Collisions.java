package ghettorraria.modele;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Collisions {

    private Bloc bloc;
    private Terrain terrain;

    public Collisions(Terrain terrain) {
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

        for (Bloc bloc : this.terrain.getCodesTuiles()) {
            if (bloc.getId() != -1) {
                rectangles.add(new Rectangle(bloc.getX(), bloc.getY(), 32, 32));
            }
        }

        return rectangles;
    }

}
