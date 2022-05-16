
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

import Sprint1.modele.Joueur;
import Sprint1.modele.Terrain;
import Sprint1.vue.TerrainVue;


public class Controleur implements Initializable {

    private Terrain terrain;
    private Joueur joueuraffiche;

    @FXML
    private TilePane paneTerrain;
    
    @FXML
    private BorderPane Border1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        terrain = new Terrain();
        TerrainVue terrainVue = new TerrainVue(terrain, paneTerrain);
        terrainVue.dessinerTerrain();
        /*
        Image Joueur = new Image("ressources/joueurtest.png");
        ImageView joueurtest = new ImageView(Joueur);
        
        joueurtest.translateXProperty().bind(joueuraffiche.xProperty());
        joueurtest.translateYProperty().bind(joueuraffiche.yProperty());
        paneTerrain.getChildren().add(joueurtest);
        
        Border1.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
		};{
			
       */
   		
        
    }
    
    
}
