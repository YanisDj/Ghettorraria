package ghettorraria.vue;

import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import ghettorraria.modele.Inventaire;

public class InventaireVue {
    
    private Inventaire inventaire;
    private Pane paneCase;
    private boolean invAffiche;

    public InventaireVue(Inventaire inventaire, Pane paneCase){
        super();
        this.paneCase = paneCase;
        this.inventaire = inventaire;
        this.invAffiche = false;
    }

    public void placerInventaire(){
        for (int i = 0; i < 5; i++){
        	ImageView inventaire = new ImageView("ressources/inventaireoue.png");
        	inventaire.setLayoutX(i*32);
            paneCase.getChildren().add(inventaire);
        }
    }

    public void ouvrirInventaire(){
        this.invAffiche = true;
        for (int y = 0; y < 5; y++){
            for (int i = 0; i < 5; i++){
                ImageView inventaire = new ImageView("ressources/inventaireoue.png");
                inventaire.setId("caseInventaire");
                inventaire.setLayoutX(i*32);
                paneCase.getChildren().add(inventaire);
                inventaire.setLayoutY(y*32);
            }
        }
    }

    public void fermerInventaire() {
        this.invAffiche = false;
        paneCase.getChildren().removeAll(paneCase.lookupAll("#caseInventaire"));
    }

    public boolean getInvAffiche(){
        return this.invAffiche;
    }

}
