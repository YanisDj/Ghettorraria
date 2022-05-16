
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

import Sprint1.modele.Joueur;
import Sprint1.modele.Terrain;
import Sprint1.vue.TerrainVue;
import Sprint1.Main;


public class Controleur implements Initializable {

    private Terrain terrain;
    private Joueur joueur;

    @FXML
    private TilePane paneTerrain;
    
    @FXML
    private BorderPane Border1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        terrain = new Terrain();
        TerrainVue terrainVue = new TerrainVue(terrain, paneTerrain);
        terrainVue.dessinerTerrain();
        
        joueur=new Joueur(10, 20);
        Image imagejoueur = new Image("ressources/joueurtest.png");
        ImageView joueurmap = new ImageView(imagejoueur);
        
        joueurmap.translateXProperty().bind(joueur.xProperty());
        joueurmap.translateYProperty().bind(joueur.yProperty());
        Border1.getChildren().add(joueurmap);
       
        Border1.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

        
			@Override
			public void handle(KeyEvent key) {
				if(key.getCode()==KeyCode.D) {
					joueur.deplacementdroite();
				}
				if(key.getCode()==KeyCode.Q) {
					joueur.deplacementgauche();
				}
				
				
			}

        	});
				
	
        		
        
      
   		
        
    }
    
    
}
