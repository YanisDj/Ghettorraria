package ghettorraria.modele;

import java.util.Arrays;
import java.util.List;

import ghettorraria.modele.item.CaseInventaire;
import ghettorraria.modele.item.Objet;

public class Inventaire {
    
    private List<CaseInventaire> petitInventaire;

    public Inventaire (){
        this.petitInventaire = Arrays.asList(new CaseInventaire[5]);
    }

    public Objet getObjet(String id){
        Objet objRet = null;
        for (int i = 0; i < this.petitInventaire.size(); i++){
            if (petitInventaire.get(i).getObjet().getId() == id){
                objRet = petitInventaire.get(i).getObjet();
            }
        }
        return objRet;
    }
    
  

    public List<CaseInventaire> getInv(){
        return this.petitInventaire;
    }

}