package src.vue;

import src.modele.Terrain;
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
		ObservableList<Integer> codesTuiles = terrain.getCodesTuiles();
		for (int tuile : codesTuiles) {
			switch (tuile) {
			case -1:
				paneTerrain.getChildren().add(new ImageView());
				break;
			default:
				paneTerrain.getChildren().add(new ImageView("ressources/" + tuile + ".png"));
				break;
			}
		}

	}






}