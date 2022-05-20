package ghettorraria.modele;

import java.util.Arrays;
import java.util.List;

public class Inventaire {
    
    private List<Objet> petitInventaire;

    public Inventaire (){
        this.petitInventaire = Arrays.asList(new Objet[5]);
    }

    public Objet getObjet(String id){
        Objet objRet = null;
        for (int i = 0; i < this.petitInventaire.size(); i++){
            if (petitInventaire.get(i).getId() == id){
                objRet = petitInventaire.get(i);
            }
        }
        return objRet;
    }

    public List<Objet> getInv(){
        return this.petitInventaire;
    }

}