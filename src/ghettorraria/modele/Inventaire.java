package ghettorraria.modele;

import ghettorraria.modele.item.CaseInventaire;
import ghettorraria.modele.item.Objet;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

    private ObservableList<CaseInventaire> inventaire;
    private IntegerProperty souris;

    public Inventaire() {
        this.inventaire = FXCollections.observableArrayList();
        this.souris = new SimpleIntegerProperty(0);
        this.souris.addListener((obs, oldV, newV) -> {
            if (newV.intValue() > 11)
                this.souris.set(0);
            else if (newV.intValue() < 0)
                this.souris.set(11);
        });

    }

    public Objet getObjet(int id) {
        for (int i = 0; i < this.inventaire.size(); i++)
            if (inventaire.get(i).getObjet().getId()== id )
                return inventaire.get(i).getObjet();
        return null;
    }

    public ObservableList<CaseInventaire> getInv() {
        return this.inventaire;
    }

    public void ajoutercaseInventaire(Objet objet) {
        this.inventaire.add(new CaseInventaire(0, objet));
    }

    public IntegerProperty sourisProperty() {
        return this.souris;
    }

    public void setSouris(int souris) {
        this.souris.set(souris);
    }
    
    public int getSouris(){
        return souris.getValue();
    }

    public int ajouterQuantite(int bloc) {
        for (int i=0; i<inventaire.size();i++){
            if(inventaire.get(i).getObjet().getId()==bloc ){
                inventaire.get(i).ajouterQuantite();
            }
        }
        return 0;
    }

    public int enleverQuantite(int bloc) {
        for (int i=0; i<inventaire.size();i++){
            if(inventaire.get(i).getObjet().getId()==bloc ){
                inventaire.get(i).enleverQuantite();
            }
        }
        return 0;
    }
}