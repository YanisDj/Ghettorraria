package ghettorraria.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import ghettorraria.modele.Joueur;
import ghettorraria.modele.Terrain;
import ghettorraria.vue.JoueurVue;
import ghettorraria.vue.TerrainVue;


public class Controleur implements Initializable {

    private Timeline gameLoop;


    private Terrain terrain;
    private Joueur joueur;

    @FXML
    private TilePane paneTerrain;
    
    @FXML
    private BorderPane Border1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        initAnimation();
        gameLoop.play();

        terrain = new Terrain();
        TerrainVue terrainVue = new TerrainVue(terrain, paneTerrain);
        terrainVue.dessinerTerrain();
        
        joueur = new Joueur(10, 20, terrain);
        JoueurVue joueurVue = new JoueurVue(Border1, joueur);
        joueurVue.placerJoueur();
        /* joueur.gravite(); */

        Border1.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent key) {

                if(key.getCode() == KeyCode.D) {
                    joueur.deplacementdroiteOui();
                }
                if(key.getCode() == KeyCode.Q) {
                    joueur.deplacementgaucheOui();
                }
                if(key.getCode() == KeyCode.Z) {
                    joueur.saut();
                }
            }
        });

        Border1.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent key) {

                if(key.getCode() == KeyCode.D) {
                    joueur.deplacementdroiteNon();
                }
                if(key.getCode() == KeyCode.Q) {
                    joueur.deplacementgaucheNon();
                }
                if(key.getCode() == KeyCode.Z) {
                    joueur.finsaut();
                    /* joueur.gravite(); */
                }
            }
        });

    }

    private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					joueur.deplacer();
				})
			);
		gameLoop.getKeyFrames().add(kf);
	}
}