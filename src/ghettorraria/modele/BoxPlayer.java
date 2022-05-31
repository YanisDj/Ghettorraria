package ghettorraria.modele;

import javafx.scene.shape.Rectangle;

public class BoxPlayer {

    private int x, y;
    private Joueur joueur;
    private Rectangle bordsPerso;

    public BoxPlayer(int x, int y, Joueur joueur) {
        this.x = x;
        this.y = y;
        this.joueur = joueur;
        this.bordsPerso = new Rectangle(x, y, this.joueur.LARGEUR_PERSO, this.joueur.HAUTEUR_PERSO);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Rectangle getBords() {
        return this.bordsPerso;
    }
}
