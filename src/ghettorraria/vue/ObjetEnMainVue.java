package ghettorraria.vue;

import ghettorraria.modele.Joueur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObjetEnMainVue {

    private Pane pane;
    private Joueur joueur;
    private ImageView objetEnMain;

    public ObjetEnMainVue(Pane pane, Joueur joueur){
        this.pane = pane;
        this.joueur = joueur;
    }

    public void placerObjetEnMain(int x, int y){
        objetEnMain = new ImageView();
        objetEnMain.setX(x);
        objetEnMain.setY(y);
        pane.getChildren().addAll(objetEnMain);
    }

    // public void rafraichirObjetEnMain(){
    //     if (joueur.getArme().getNom().equals("pioche")){
    //         objetEnMain.setImage(new Image("ressources/pioche.png"));
    //     }
    // }
}
