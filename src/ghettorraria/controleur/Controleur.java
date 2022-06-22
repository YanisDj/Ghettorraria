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
import ghettorraria.modele.Mob;
import ghettorraria.modele.Terrain;
import ghettorraria.modele.item.Acier;
import ghettorraria.modele.item.Batte;
import ghettorraria.modele.item.Bois;
import ghettorraria.modele.item.CapriSun;
import ghettorraria.modele.item.Couteau;
import ghettorraria.modele.item.Kebab;
import ghettorraria.modele.item.Pierre;
import ghettorraria.modele.item.Pioche;
import ghettorraria.modele.item.Pistolet;
import ghettorraria.modele.item.Terre;
import ghettorraria.vue.BarreDeVieVue;
import ghettorraria.vue.InventaireVue;
import ghettorraria.vue.JoueurVue;
import ghettorraria.vue.MobVue;
import ghettorraria.vue.TerrainVue;

public class Controleur implements Initializable {

    private Timeline gameLoop;

    private Terrain terrain;
    private Joueur joueur;
    private TerrainVue terrainVue;
    private Inventaire inventaire;
    private BarreDeVieVue barreVieVue;
    private Mob singe, voyou, chien;

    @FXML
    private TilePane paneTerrain;

    @FXML
    private BorderPane Border1;

    @FXML
    private Pane paneprincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        terrain = new Terrain();
        terrainVue = new TerrainVue(terrain, paneTerrain);
        terrainVue.dessinerTerrain();

        inventaire = new Inventaire();
        InventaireVue inventaireVue = new InventaireVue(inventaire, paneprincipal);
        inventaireVue.placerInventaire();
        inventaire.ajoutercaseInventaire(new Pioche());
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.ajoutercaseInventaire(new Batte());
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.ajoutercaseInventaire(new Couteau());
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.ajoutercaseInventaire(new Pistolet());
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.ajoutercaseInventaire(new Pierre());
        inventaire.ajoutercaseInventaire(new Terre());
        inventaire.ajoutercaseInventaire(new Acier());
        inventaire.ajoutercaseInventaire(new Bois());
        inventaire.ajoutercaseInventaire(new Kebab());
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.ajoutercaseInventaire(new CapriSun());
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaire.getInv().get(inventaire.getInv().size() - 1).ajouterQuantite();
        inventaireVue.remplirpetitinvenatairevue();

        inventaireVue.creeLabel();

        joueur = new Joueur(terrain, inventaire);
        JoueurVue joueurVue = new JoueurVue(paneprincipal, joueur);
        joueurVue.placerJoueur();

        barreVieVue = new BarreDeVieVue(paneprincipal, joueur);
        barreVieVue.placerBarreDeVie();

        singe = new Mob("singe", 40, 3, terrain, joueur, 0, null, 32);
        MobVue singeVue = new MobVue(paneprincipal, singe);
        singeVue.placerMob();

        voyou = new Mob("voyou", 90, 1, terrain, joueur, 5, null, 32);
        MobVue voyouVue = new MobVue(paneprincipal, voyou);
        voyouVue.placerMob();

        chien = new Mob("chien", 50, 2, terrain, joueur, 2, null, 32);
        MobVue chienVue = new MobVue(paneprincipal, chien);
        chienVue.placerMob();

        this.terrain.getCodesTuiles().addListener(new Observateur(paneTerrain, terrainVue, inventaireVue));

        joueur.finsaut();
        singe.finsaut();
        voyou.finsaut();
        chien.finsaut();

        this.joueur.getPvProperty().addListener((obs, oldV, newV) -> {
            if (newV.intValue() > oldV.intValue()) {
                barreVieVue.rafraichirBarreDeVieGagne();
            } else {
                barreVieVue.rafraichirBarreDeViePert();
            }

            if (newV.intValue() <= 0) {
                gameLoop.stop();
                joueurVue.mortJoueur();
            }
        });

        this.chien.getPvProperty().addListener((obs, oldV, newV) -> {
            if (newV.intValue() <= 0) {
                chienVue.enleverMob();
            }
        });

        this.voyou.getPvProperty().addListener((obs, oldV, newV) -> {
            if (newV.intValue() <= 0) {
                voyouVue.enleverMob();
            }
        });

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
                if (key.getCode() == KeyCode.SHIFT) {
                    if (Math.abs(chien.getX() - joueur.getX()) <= 64 && Math.abs(chien.getY() - joueur.getY()) <= 64) {
                        joueur.frappeActeur(chien);
                    }
                    if (Math.abs(voyou.getX() - joueur.getX()) <= 64 && Math.abs(voyou.getY() - joueur.getY()) <= 64) {
                        joueur.frappeActeur(voyou);
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
                    joueur.utiliser(x, y);
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    joueur.poseBloc(x, y);
                }
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
                joueur.setObjetmain(inventaire.sourisProperty().get());
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
                rectangle.setX(x / 32 * 32);
                rectangle.setY(y / 32 * 32);
                inventaireVue.getobjetmain().setX((x / 32) * 32);
                inventaireVue.getobjetmain().setY((y / 32) * 32);

                if (joueur.getX() > x) {
                    if (joueur.getX() - x <= 64 && (Math.abs(joueur.getY() - y) <= 64
                            || Math.abs(y - joueur.getY() - joueur.getHauteurPerso()) <= 64)) {
                        rectangle.setStroke(Color.BLUEVIOLET);
                    } else {
                        rectangle.setStroke(Color.ORANGERED);
                    }
                } else {
                    if (x - joueur.getLargeurPerso() - joueur.getX() <= 64 && (Math.abs(joueur.getY() - y) <= 64
                            || Math.abs(y - joueur.getY() - joueur.getHauteurPerso()) <= 64)) {
                        rectangle.setStroke(Color.BLUEVIOLET);
                    } else {
                        rectangle.setStroke(Color.ORANGERED);
                    }
                }
            }

        });

        initAnimation();
        gameLoop.play();

    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                (ev -> {
                    joueur.deplacer();
                    singe.deplacer();
                    voyou.agir();
                    chien.agir();
                }));
        gameLoop.getKeyFrames().add(kf);
    }
}