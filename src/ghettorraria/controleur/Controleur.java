package ghettorraria.controleur;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

import ghettorraria.modele.Joueur;
import ghettorraria.modele.Terrain;
import ghettorraria.vue.TerrainVue;

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

        joueur = new Joueur(10, 20);
        Image imagejoueur = new Image("ressources/joueurtest.png");
        ImageView joueurmap = new ImageView(imagejoueur);

        joueurmap.translateXProperty().bind(joueur.xProperty());
        joueurmap.translateYProperty().bind(joueur.yProperty());
        Border1.getChildren().add(joueurmap);
        Image image = new Image("ressources/ciel.png");
        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);
        Border1.setBackground(background);
        joueurmap.setY(416);

        Border1.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.D) {
                    joueur.deplacementdroite();
                }
                if (key.getCode() == KeyCode.Q) {
                    joueur.deplacementgauche();
                }

            }

        });

    }

}