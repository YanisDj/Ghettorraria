package ghettorraria.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import ghettorraria.modele.Inventaire;
import ghettorraria.modele.Joueur;
import ghettorraria.modele.item.Acier;
import ghettorraria.modele.item.Batte;
import ghettorraria.modele.item.Bois;
import ghettorraria.modele.item.Bâton;
import ghettorraria.modele.item.Capri_sun;
import ghettorraria.modele.item.CaseInventaire;
import ghettorraria.modele.item.Couteau;
import ghettorraria.modele.item.Etablis;
import ghettorraria.modele.item.GiletDeProtection;
import ghettorraria.modele.item.Kebab;
import ghettorraria.modele.item.Pierre;
import ghettorraria.modele.item.Pioche;
import ghettorraria.modele.item.Pistolet;
import ghettorraria.modele.item.Terre;

public class InventaireVue {

    private int[] petitInventaire = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };
    private int[][] grandInventaire = { { 4, 5, 5, 5, 6 }, { 7, 8, 8, 8, 9 }, { 7, 8, 8, 8, 9 }, { 7, 8, 8, 8, 9 },
            { 10, 11, 11, 11, 12 } };

    private Inventaire inventaire;
    private Pane paneCase;
    private int invAffiche;
    private Joueur joueur;
    ImageView objetmain = new ImageView("ressources/pioche.png");

    public InventaireVue(Inventaire inventaire, Pane paneCase, Joueur joueur) {
        this.paneCase = paneCase;
        this.inventaire = inventaire;
        this.joueur = joueur;
        this.joueur.objetmainObjectProperty().addListener((obs, oldV, newV) -> extracted(newV));
        paneCase.getChildren().add((objetmain));
        this.invAffiche = 1;

    }

    private void extracted(Object newV) {
        if (((CaseInventaire) newV).getObjet() instanceof Pioche) {
            objetmain.setImage(new Image("ressources/pioche.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Couteau) {
            objetmain.setImage(new Image("ressources/couteau.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Etablis) {
            objetmain.setImage(new Image("ressources/etabli.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Batte) {
            objetmain.setImage(new Image("ressources/bate-de-baseball.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Acier) {
            objetmain.setImage(new Image("ressources/bloc-acier.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Bâton) {
            objetmain.setImage(new Image("ressources/baton.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Pistolet) {
            objetmain.setImage(new Image("ressources/pistolet.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof GiletDeProtection) {
            objetmain.setImage(new Image("ressources/gilet-de-protection.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Pierre) {
            objetmain.setImage(new Image("ressources/bloc-pierre.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Terre) {
            objetmain.setImage(new Image("ressources/bloc-terre.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Bois) {
            objetmain.setImage(new Image("ressources/bloc-bois.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Etablis) {
            objetmain.setImage(new Image("ressources/etabli.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Kebab) {
            objetmain.setImage(new Image("ressources/kebab.png"));
        }
        if (((CaseInventaire) newV).getObjet() instanceof Capri_sun) {
            objetmain.setImage(new Image("ressources/capri-sun.png"));
        }

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

    public void fermerInventaire(int inventaire) {
        String id;
        if (inventaire == 1) {
            id = "petitInventaire";
        } else {
            id = "grandInventaire";
        }
        paneCase.getChildren().removeAll(paneCase.lookupAll("#" + id));
    }

    public int getInvAffiche() {
        return this.invAffiche;
    }

    public void remplirpetitinvenatairevue() {
        if (invAffiche == 1) {
            for (int i = 0; i < petitInventaire.length; i++) {
                ImageView objetinv = new ImageView();
                if (this.inventaire.getInv().get(i).getObjet() instanceof Pioche) {
                    objetinv = new ImageView("ressources/inventaire/pioche.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Couteau) {
                    objetinv = new ImageView("ressources/inventaire/couteau.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Etablis) {
                    objetinv = new ImageView("ressources/inventaire/etabli.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Batte) {
                    objetinv = new ImageView("ressources/inventaire/bate-de-baseball.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Acier) {
                    objetinv = new ImageView("ressources/inventaire/bloc-acier.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Bâton) {
                    objetinv = new ImageView("ressources/inventaire/baton.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Pistolet) {
                    objetinv = new ImageView("ressources/inventaire/pistolet.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof GiletDeProtection) {
                    objetinv = new ImageView("ressources/inventaire/gilet-de-protection.png");
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
                if (this.inventaire.getInv().get(i).getObjet() instanceof Etablis) {
                    objetinv = new ImageView("ressources/inventaire/etabli.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Kebab) {
                    objetinv = new ImageView("ressources/inventaire/kebab.png");
                }
                if (this.inventaire.getInv().get(i).getObjet() instanceof Capri_sun) {
                    objetinv = new ImageView("ressources/inventaire/capri-sun.png");
                }
                objetinv.setLayoutX(i * 32 + 22);
                objetinv.setLayoutY(5);
                paneCase.getChildren().add(objetinv);
            }

        }
    }

    public ImageView getobjetmain() {
        return this.objetmain;
    }

    public void setobjetmain(ImageView objetmain) {
        this.objetmain = objetmain;
    }


    public void creeLabel(){
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

