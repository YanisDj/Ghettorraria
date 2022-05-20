package ghettorraria.vue;

import ghettorraria.modele.Bloc;
import ghettorraria.modele.Terrain;
import javafx.collections.ObservableList;
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
        ObservableList<Bloc[]> codesTuiles = terrain.getCodesTuiles();
        for (Bloc[] ligne : codesTuiles) {
            for (Bloc tuile : ligne) {
                if (tuile.getId()>=0) {
                    paneTerrain.getChildren().add(new ImageView("ressources/" + tuile.getId() + ".png"));
                }
                else {
                    paneTerrain.getChildren().add(new ImageView());
                }
            }

        }

    }

}