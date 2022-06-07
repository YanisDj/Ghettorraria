package ghettorraria.vue;

import ghettorraria.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class BarreDeVieVue {

    private Pane paneCase;
    private Joueur joueur;

    public BarreDeVieVue(Pane paneCase, Joueur joueur){
        this.paneCase = paneCase;
        this.joueur = joueur;
    }

    public void placerBarreDeVie(){
        if (joueur.getPv() > 90){
            //todo
        } else if (joueur.getPv() > 80){
            //todo
        } else if (joueur.getPv() > 70){
            //todo
        } else if (joueur.getPv() > 60){
            //todo
        } else if (joueur.getPv() > 50){
            //todo
        } else if (joueur.getPv() > 40){
            //todo
        } else if (joueur.getPv() > 30){
            //todo
        } else if (joueur.getPv() > 20){
            //todo
        } else if (joueur.getPv() > 10){
            //todo
        } else {
            //todo
        }
    }
}
