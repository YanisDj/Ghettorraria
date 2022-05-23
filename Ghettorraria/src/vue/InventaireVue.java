package src.vue;

import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;
import src.modele.Inventaire;

public class InventaireVue {
    
    private Inventaire inventaire;
    private Pane paneCase;

    public InventaireVue(Inventaire inventaire, Pane paneCase){
        super();
        this.paneCase = paneCase;
        this.inventaire = inventaire;
    }

    public void placerInventaire(){
        for (int i = 0; i < inventaire.getInv().size(); i++){
        	ImageView inventaire = new ImageView("ressources/inventaireoue.png");
        	inventaire.setLayoutX(i*32);
            paneCase.getChildren().add(inventaire);
        }
    }
}
