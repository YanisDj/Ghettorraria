package ghettorraria.modele;

import javafx.scene.shape.Rectangle;

public class BoxPlayer {

    private Joueur joueur;

    public BoxPlayer(Joueur joueur) {
        this.joueur = joueur;
    }

    public Rectangle getBords() {
        return new Rectangle(joueur.getX(), joueur.getY(), this.joueur.LARGEUR_PERSO, this.joueur.HAUTEUR_PERSO);
    }
}
