package ghettorraria.vue;

import java.util.ArrayList;

import ghettorraria.modele.Terrain;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TerrainVue {

    private Terrain terrain;
    private TilePane paneTerrain;

    public TerrainVue(Terrain terrain, TilePane paneTerrain) {
        super();
        this.terrain = terrain;
        this.paneTerrain = paneTerrain;
    }

    public void dessinerTerrain() {
        ArrayList<Integer> codesTuiles = terrain.getCodesTuiles();
        for (int i : codesTuiles) {
            switch (i) {
                case -1:
                    paneTerrain.getChildren().add(new ImageView());
                    break;
                default:
                    paneTerrain.getChildren().add(new ImageView("ressources/"+i+".png"));
                    break;
            }
        }

    }

}