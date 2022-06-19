package ghettorraria.vue;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import ghettorraria.modele.Inventaire;
import ghettorraria.modele.item.Acier;
import ghettorraria.modele.item.Batte;
import ghettorraria.modele.item.Bois;
import ghettorraria.modele.item.Baton;
import ghettorraria.modele.item.CapriSun;
import ghettorraria.modele.item.Couteau;
import ghettorraria.modele.item.Kebab;
import ghettorraria.modele.item.Objet;
import ghettorraria.modele.item.Pierre;
import ghettorraria.modele.item.Pioche;
import ghettorraria.modele.item.Pistolet;
import ghettorraria.modele.item.Terre;

public class InventaireVue {

    private int[] petitInventaire = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2,3 };

    private Inventaire inventaire;
    private Pane paneCase;
  
    ImageView objetmain = new ImageView("ressources/pioche.png");

    public InventaireVue(Inventaire inventaire, Pane paneCase) {
        this.paneCase = paneCase;
        this.inventaire = inventaire;
        inventaire.sourisProperty().addListener((obs, oldV, newV) -> extracted((int) newV));
        paneCase.getChildren().add((objetmain));
     

    }

    private void extracted(int indice) {
        Objet selectionne = this.inventaire.getInv().get(indice).getObjet();

        if (selectionne instanceof Pioche) {
            objetmain.setOpacity(1);
            objetmain.setImage(new Image("ressources/pioche.png"));
        }
        if (selectionne instanceof Couteau) {
            objetmain.setOpacity(1);
            objetmain.setImage(new Image("ressources/couteau.png"));
        }
        if (selectionne instanceof Batte) {
            objetmain.setImage(new Image("ressources/bate-de-baseball.png"));
        }
        if (selectionne instanceof Acier) {
            objetmain.setOpacity(0);
        }
        if (selectionne instanceof Baton) {
            objetmain.setOpacity(1);
            objetmain.setImage(new Image("ressources/baton.png"));
        }
        if (selectionne instanceof Pistolet) {
            objetmain.setOpacity(1);
            objetmain.setImage(new Image("ressources/pistolet.png"));
        }
        if (selectionne instanceof Pierre) {
            objetmain.setOpacity(0);
        }
        if (selectionne instanceof Terre) {
            objetmain.setOpacity(0);
        }
        if (selectionne instanceof Bois) {
            objetmain.setOpacity(0);
        }
        if (selectionne instanceof Kebab) {
            objetmain.setOpacity(1);
            objetmain.setImage(new Image("ressources/kebab.png"));
        }
        if (selectionne instanceof CapriSun) {
            objetmain.setOpacity(1);
            objetmain.setImage(new Image("ressources/capri-sun.png"));

        }

    }

    public void placerInventaire() {
        for (int i = 0; i < petitInventaire.length; i++) {
            ImageView caseInventaire = new ImageView("ressources/inv" + petitInventaire[i] + ".png");
            caseInventaire.setLayoutX(i * 32 + 16);
            caseInventaire.setId("petitInventaire");
            paneCase.getChildren().add(caseInventaire);
        }
    }


    public void remplirpetitinvenatairevue() {
            for (int i = 0; i < petitInventaire.length; i++) {
                ImageView objetinv = new ImageView();
                if (this.inventaire.getInv().get(i).getObjet() instanceof Pioche) {
                    objetinv = new ImageView("ressources/inventaire/pioche.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Couteau) {
                    objetinv = new ImageView("ressources/inventaire/couteau.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Batte) {
                    objetinv = new ImageView("ressources/inventaire/bate-de-baseball.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Acier) {
                    objetinv = new ImageView("ressources/inventaire/bloc-acier.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Baton) {
                    objetinv = new ImageView("ressources/inventaire/baton.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Pistolet) {
                    objetinv = new ImageView("ressources/inventaire/pistolet.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Pierre) {
                    objetinv = new ImageView("ressources/inventaire/bloc-pierre.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Terre) {
                    objetinv = new ImageView("ressources/inventaire/bloc-terre.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Bois) {
                    objetinv = new ImageView("ressources/inventaire/bloc-bois.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Kebab) {
                    objetinv = new ImageView("ressources/inventaire/kebab.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof CapriSun) {
                    objetinv = new ImageView("ressources/inventaire/capri-sun.png");
                }
                objetinv.setLayoutX(i * 32 + 22);
                objetinv.setLayoutY(5);
                paneCase.getChildren().add(objetinv);
            }

        
    }

    public ImageView getobjetmain() {
        return this.objetmain;
    }

    public void setobjetmain(ImageView objetmain) {
        this.objetmain = objetmain;
    }

    public void creeLabel() {
        for (int i = 0; i < petitInventaire.length; i++) {
            Label label = new Label();
            label.setLayoutX(i * 32 + 40);
            label.setLayoutY(30);
            label.setTextFill(Color.MAROON);
            label.textProperty().bind(inventaire.getInv().get(i).quantiteProperty().asString());
            paneCase.getChildren().add(label);
        }

    }
}
