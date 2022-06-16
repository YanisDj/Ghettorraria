package ghettorraria.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
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

import ghettorraria.modele.Observateur;
import ghettorraria.modele.Terrain;
import ghettorraria.modele.item.Acier;
import ghettorraria.modele.item.Batte;
import ghettorraria.modele.item.Bois;
import ghettorraria.modele.item.Baton;
import ghettorraria.modele.item.CapriSun;
import ghettorraria.modele.item.Couteau;
import ghettorraria.modele.item.Etablis;
import ghettorraria.modele.item.GiletDeProtection;
import ghettorraria.modele.item.Kebab;
import ghettorraria.modele.item.Lit;
import ghettorraria.modele.item.Pierre;
import ghettorraria.modele.item.Pioche;
import ghettorraria.modele.item.Pistolet;
import ghettorraria.modele.item.Terre;
import ghettorraria.vue.BarreDeVieVue;
import ghettorraria.vue.InventaireVue;
import ghettorraria.vue.JoueurVue;

import ghettorraria.vue.TerrainVue;

public class Controleur implements Initializable {

    private Timeline gameLoop;

    private Terrain terrain;
    private Joueur joueur;
    private TerrainVue terrainVue;
    private Inventaire inventaire;
    private BarreDeVieVue barreVieVue;
    // private Mob singe;

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

        joueur = new Joueur(terrain, inventaire);
        JoueurVue joueurVue = new JoueurVue(paneprincipal, joueur);
        joueurVue.placerJoueur();

        inventaire = new Inventaire(joueur);
        InventaireVue inventaireVue = new InventaireVue(inventaire, paneprincipal, joueur);
        inventaireVue.placerInventaire(1);
        inventaire.ajoutercaseInventaire(new Pioche());
        inventaire.ajoutercaseInventaire(new Batte());
        inventaire.ajoutercaseInventaire(new Couteau());
        inventaire.ajoutercaseInventaire(new Pistolet());
        inventaire.ajoutercaseInventaire(new Pierre());
        inventaire.ajoutercaseInventaire(new Terre());
        inventaire.ajoutercaseInventaire(new Bois());
        inventaire.ajoutercaseInventaire(new Acier());
        inventaire.ajoutercaseInventaire(new Baton());
        inventaire.ajoutercaseInventaire(new Etablis());
        inventaire.ajoutercaseInventaire(new GiletDeProtection());
        inventaire.ajoutercaseInventaire(new Kebab());
        inventaire.ajoutercaseInventaire(new CapriSun());
        inventaire.ajoutercaseInventaire(new Lit());
        inventaireVue.remplirpetitinvenatairevue();

        barreVieVue = new BarreDeVieVue(paneprincipal, joueur);
        barreVieVue.placerBarreDeVie();

        // singe = new Mob(5, 19, terrain, joueur, inventaire);
        // MobVue singeVue = new MobVue(paneprincipal, singe);
        // singeVue.placerMob();

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
                        inventaireVue.placerInventaire(1);
                        inventaireVue.remplirpetitinvenatairevue();
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

                if (event.getButton() == MouseButton.PRIMARY) {
                    joueur.frappeBloc(x,y);
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    joueur.poseBloc(x,y);
                }

                /* if (joueur.getX() > x) {
                    if (joueur.getX() - x <= 64 && (Math.abs(joueur.getY() - y) <= 64
                            || Math.abs(y - joueur.getY() - joueur.HAUTEUR_PERSO) <= 64)) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            joueur.frappeBloc(terrain.getBloc(x, y));
                            System.out.println(terrain.getBloc(x, y).getPv());
                            terrain.supprimerTuiles(x, y);
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            terrain.ajouterTuiles(x, y);
                        }
                    }
                } else {
                    if (x - joueur.LARGEUR_PERSO - joueur.getX() <= 64 && (Math.abs(joueur.getY() - y) <= 64
                            || Math.abs(y - joueur.getY() - joueur.HAUTEUR_PERSO) <= 64)) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            joueur.frappeBloc(terrain.getBloc(x, y));
                            System.out.println(terrain.getBloc(x, y).getPv());
                            terrain.supprimerTuiles(x, y);
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            terrain.ajouterTuiles(x, y);
                        }
                    }
                } */
            }
        });

        Rectangle rectangleinv = new Rectangle(32, 32);
        rectangleinv.setFill(Color.TRANSPARENT);
        rectangleinv.setStroke(Color.RED);
        rectangleinv.setStrokeWidth(3);
        paneprincipal.getChildren().add(rectangleinv);
        rectangleinv.setLayoutX(32 * inventaire.sourisProperty().get() + 16);

        Border1.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {

            @Override
            public void handle(ScrollEvent event) {
                if (event.getDeltaY() > 0)
                    inventaire.setSouris(inventaire.sourisProperty().get() + 1);
                if (event.getDeltaY() < 0)
                    inventaire.setSouris(inventaire.sourisProperty().get() - 1);

                rectangleinv.setLayoutX(32 * inventaire.sourisProperty().get() + 16);

            }

        });

        Rectangle rectangle = new Rectangle(32, 32);
        rectangle.setFill(Color.TRANSPARENT);
        paneprincipal.getChildren().add(rectangle);
        Border1.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            int x, y;

            @Override
            public void handle(MouseEvent event) {
                x = (int) event.getX();
                y = (int) event.getY();
                rectangle.setX(x/32*32);
                rectangle.setY(y/32*32);
                inventaireVue.getobjetmain().setX((x/32)*32);
                inventaireVue.getobjetmain().setY((y/32)*32);
                
                if (joueur.getX()>x) {
                    if (joueur.getX()-x<=64 && (Math.abs(joueur.getY()-y)<=64 || Math.abs(y-joueur.getY()-joueur.HAUTEUR_PERSO)<=64)) {
                        rectangle.setStroke(Color.BLUEVIOLET);
                    } else {
                        rectangle.setStroke(Color.ORANGERED);
                    }
                } else {
                    if (x - joueur.LARGEUR_PERSO - joueur.getX() <= 64 && (Math.abs(joueur.getY() - y) <= 64
                            || Math.abs(y - joueur.getY() - joueur.HAUTEUR_PERSO) <= 64)) {
                        rectangle.setStroke(Color.BLUEVIOLET);
                    } else {
                        rectangle.setStroke(Color.ORANGERED);
                    }
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
                (ev -> {
                    joueur.deplacer();
                    barreVieVue.rafraichirBarreDeVie();
                    /* singe.deplacer(); */
                }));
        gameLoop.getKeyFrames().add(kf);
    }
}