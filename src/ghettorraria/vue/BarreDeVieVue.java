package ghettorraria.vue;

import ghettorraria.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BarreDeVieVue {

    private Pane paneCase;
    private Joueur joueur;
    private ImageView barreVie;

    public BarreDeVieVue(Pane paneCase, Joueur joueur){
        this.paneCase = paneCase;
        this.joueur = joueur;
    }

    public void placerBarreDeVie(){
        barreVie = new ImageView("ressources/barre-de-vie-sprites/barre1.png");
        barreVie.setLayoutX(200);
        paneCase.getChildren().add(barreVie);
    }

    public void rafraichirBarreDeVie(){
        if (joueur.getPv() <= 10){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre2.png"));
        } else if (joueur.getPv()  <= 20){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre3.png"));
        } else if (joueur.getPv()  <= 30){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre4.png"));
        } else if (joueur.getPv()  <= 40){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre5.png"));
        } else if (joueur.getPv()  <= 50){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre6.png"));
        } else if (joueur.getPv()  <= 60){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre7.png"));
        } else if (joueur.getPv()  <= 70){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre8.png"));
        } else if (joueur.getPv()  <= 80){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre9.png"));
        } else if (joueur.getPv()  <= 90){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barre10.png"));
        } else if (joueur.getPv() == 0){
            barreVie.setImage(new Image("ressources/barre-de-vie-sprites/barreMort.png"));
        }
    }
}
