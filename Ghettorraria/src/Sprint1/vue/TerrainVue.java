package Sprint1.vue;

import Sprint1.modele.Terrain;
import javafx.scene.image.Image;
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
        int[][] codesTuiles = terrain.getCodesTuiles();
        Image terre = new Image("ressources/rooted_dirt.png");
        Image terreHerbe = new Image("ressources/grass_block_side.png");
        Image ciel = new Image("ressources/ciel.png");
        for (int[] i : codesTuiles){
            for (int j : i) {
            	System.out.println(j);
                switch (j) {
                    case 0 : paneTerrain.getChildren().add(new ImageView());
                    break;
                    case 1 : paneTerrain.getChildren().add(new ImageView(terre));
                    break;
                    case 2 : paneTerrain.getChildren().add(new ImageView(terreHerbe));
                    break;
                    case 3 : paneTerrain.getChildren().add(new ImageView(ciel));
                    break;
                }
  
            }
        }
	}
	
	
	
	
}
