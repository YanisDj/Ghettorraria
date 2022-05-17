package ghettorraria.vue;

import ghettorraria.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class JoueurVue {

    private BorderPane border;
    private Joueur joueur;

    public JoueurVue(BorderPane border, Joueur joueur) {
        super();
        this.border = border;
        this.joueur = joueur;
    }

    public void placerJoueur() {
        Image imagejoueur = new Image("ressources/joueurtest.png");
        ImageView joueurmap = new ImageView(imagejoueur);
        
        joueur.xProperty().setValue(320);
        joueur.chute();

        joueurmap.translateXProperty().bind(joueur.xProperty());
        joueurmap.translateYProperty().bind(joueur.yProperty());
        border.getChildren().add(joueurmap);

    }

}