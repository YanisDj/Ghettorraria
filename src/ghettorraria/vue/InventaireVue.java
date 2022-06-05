package ghettorraria.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import ghettorraria.modele.Inventaire;

public class InventaireVue {

    private int[] petitInventaire = { 1, 2, 2, 2, 3 };
    private int[][] grandInventaire = { { 4, 5, 5, 5, 6 }, { 7, 8, 8, 8, 9 }, { 7, 8, 8, 8, 9 }, { 7, 8, 8, 8, 9 },
            { 10, 11, 11, 11, 12 } };

    /* private Inventaire inventaire; */
    private Pane paneCase;
    private int invAffiche;

    public InventaireVue(Inventaire inventaire, Pane paneCase) {
        this.paneCase = paneCase;
        /* this.inventaire = inventaire; */
        this.invAffiche = 1;
    }

    public void placerInventaire(int inventaire) {
        if (inventaire == 1) {
            this.invAffiche = 1;
            fermerInventaire(2);
            for (int i = 0; i < petitInventaire.length; i++) {
                ImageView caseInventaire = new ImageView("ressources/inv" + petitInventaire[i] + ".png");
                caseInventaire.setLayoutX(i * 32 + 16);
                caseInventaire.setId("petitInventaire");
                paneCase.getChildren().add(caseInventaire);
            }
        } else {
            this.invAffiche = 2;
            fermerInventaire(1);
            for (int i = 0; i < grandInventaire.length; i++) {
                for (int j = 0; j < grandInventaire[i].length; j++) {
                    ImageView caseInventaire = new ImageView("ressources/inv" + grandInventaire[i][j] + ".png");
                    caseInventaire.setId("grandInventaire");
                    caseInventaire.setLayoutX(j * 32 + 16);
                    paneCase.getChildren().add(caseInventaire);
                    caseInventaire.setLayoutY(i * 32);
                }

            }
        }
    }

    /*
     * public void ouvrirInventaire() {
     * this.invAffiche = true;
     * for (int y = 0; y < 5; y++) {
     * for (int i = 0; i < 5; i++) {
     * ImageView inventaire = new ImageView("ressources/inventaireoue.png");
     * inventaire.setId("caseInventaire");
     * inventaire.setLayoutX(i * 32);
     * paneCase.getChildren().add(inventaire);
     * inventaire.setLayoutY(y * 32);
     * }
     * }
     * }
     */

    public void fermerInventaire(int inventaire) {
        String id;
        if (inventaire == 1) {
            id = "petitInventaire";
        } else {
            id = "grandInventaire";
        }
        paneCase.getChildren().removeAll(paneCase.lookupAll("#"+id));
    }

    public int getInvAffiche() {
        return this.invAffiche;
    }

}
