package ghettorraria.vue;

import ghettorraria.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class JoueurVue {

    private Pane pane;
    private Joueur joueur;

    public JoueurVue(Pane border, Joueur joueur) {
        this.pane = border;
        this.joueur = joueur;
    }

    public void placerJoueur() {
        Image imagejoueur = new Image("ressources/joueurtest.png");
        ImageView joueurmap = new ImageView(imagejoueur);
        joueurmap.translateXProperty().bind(joueur.xProperty());
        joueurmap.translateYProperty().bind(joueur.yProperty());
        joueur.xProperty().setValue(320);
        pane.getChildren().add(joueurmap);
    }

}