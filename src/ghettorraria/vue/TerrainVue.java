package ghettorraria.vue;

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
        int[] codesTuiles = terrain.getCodesTuiles();
        for (int i : codesTuiles) {
            System.out.println(i);
            switch (i) {
                case 0:
                    paneTerrain.getChildren().add(new ImageView());
                    break;
                default:
                    paneTerrain.getChildren().add(new ImageView("ressources/"+i+".png"));
                    break;
            }
        }

    }

}