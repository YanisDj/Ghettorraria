package ghettorraria.vue;

import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import ghettorraria.modele.Inventaire;

public class InventaireVue {
    
    private Inventaire inventaire;
    private BorderPane paneCase;

    public InventaireVue(Inventaire inventaire, BorderPane paneCase){
        super();
        this.paneCase = paneCase;
        this.inventaire = inventaire;
    }

    public void placerInventaire(){
        for (int i = 0; i < inventaire.getInv().size(); i++){
            paneCase.getChildren().add(new ImageView("ressources/inventaireoue.png"));
        }
    }
}
