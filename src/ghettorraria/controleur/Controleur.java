package ghettorraria.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import ghettorraria.modele.Inventaire;
import ghettorraria.modele.Joueur;
/* import ghettorraria.modele.Mob; */
import ghettorraria.modele.Observateur;
import ghettorraria.modele.Terrain;
import ghettorraria.vue.InventaireVue;
import ghettorraria.vue.JoueurVue;
import ghettorraria.vue.ObjetEnMainVue;
import ghettorraria.vue.TerrainVue;

public class Controleur implements Initializable {

    private Timeline gameLoop;

    private Terrain terrain;
    private Joueur joueur;
    private TerrainVue terrainVue;
    private Inventaire inventaire;
    /* private Mob singe; */

    @FXML
    private TilePane paneTerrain;

    @FXML
    private BorderPane Border1;

    @FXML
    private Pane paneprincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initAnimation();
        gameLoop.play();

        terrain = new Terrain();
        terrainVue = new TerrainVue(terrain, paneTerrain);
        terrainVue.dessinerTerrain();

        joueur = new Joueur(10, 20, terrain, inventaire, 3);
        JoueurVue joueurVue = new JoueurVue(paneprincipal, joueur);
        joueurVue.placerJoueur();

        inventaire = new Inventaire();
        InventaireVue inventaireVue = new InventaireVue(inventaire, paneprincipal);
        inventaireVue.placerInventaire(1);

        ObjetEnMainVue objetEnMainVue = new ObjetEnMainVue(paneprincipal, joueur);
        

        /*
         * singe = new Mob(5, 19, terrain, joueur, inventaire);
         * MobVue singeVue = new MobVue(paneprincipal, singe);
         * singeVue.placerMob();
         */

        this.terrain.getCodesTuiles().addListener(new Observateur(paneTerrain, terrainVue, inventaireVue));

        joueur.finsaut();

        Border1.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent key) {

                if (key.getCode() == KeyCode.D) {
                    joueur.deplacementdroiteOui();
                }
                if (key.getCode() == KeyCode.Q) {
                    joueur.deplacementgaucheOui();
                }
                if (key.getCode() == KeyCode.Z) {
                    joueur.saut();
                }
                if (key.getCode() == KeyCode.E) {
                    if (inventaireVue.getInvAffiche() == 1) {
                        inventaireVue.placerInventaire(2);
                    } else {
                        inventaireVue.placerInventaire(1);;
                    }
                }

            }
        });

        Border1.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent key) {

                if (key.getCode() == KeyCode.D) {
                    joueur.deplacementdroiteNon();
                }
                if (key.getCode() == KeyCode.Q) {
                    joueur.deplacementgaucheNon();
                }
                if (key.getCode() == KeyCode.Z) {
                    joueur.finsaut();
                    /* joueur.gravite(); */
                }
            }
        });

        Border1.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int x, y;
                x = (int) event.getX();
                y = (int) event.getY();
                if(Math.abs((joueur.getX()-x)/32)+Math.abs((joueur.getY()-y)/32)<=2){
                    joueur.frappeBloc(terrain.getBloc(x, y));
                    terrain.supprimerTuiles(x, y);
                }

            }
        }); 

        // ImageView pioche = new ImageView("ressources/pioche.png");
        // paneprincipal.getChildren().add(pioche);

        
        Rectangle rectangle = new Rectangle(32, 32);
        rectangle.setFill(Color.TRANSPARENT);
        paneprincipal.getChildren().add(rectangle);
        Border1.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            int x, y;

            @Override
            public void handle(MouseEvent event) {
                x = (int) (event.getX()/32) *32;
                y = (int) (event.getY()/32) *32;
                rectangle.setX(x);
                rectangle.setY(y);
                if(Math.abs((joueur.getX()-x)/32)+Math.abs((joueur.getY()-y)/32)<=2){
                    rectangle.setStroke(Color.BLUEVIOLET);
                } else {
                    rectangle.setStroke(Color.RED);
                }
                // objetEnMainVue.placerObjetEnMain(x,y);
                // if (joueur.getArme() != null){
                //     pioche.setX(x);
                //     pioche.setY(y);
                // }
            }
           
        });
        


    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                (ev -> {
                    joueur.deplacer();
                }));
        gameLoop.getKeyFrames().add(kf);
    }
}