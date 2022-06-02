package ghettorraria.modele;

import java.util.Arrays;
import java.util.List;

import ghettorraria.modele.item.CaseInventaire;
import ghettorraria.modele.item.Objet;

public class Inventaire {
    
    private List<CaseInventaire> Inventaire;


    public Inventaire (){
        this.Inventaire = Arrays.asList(new CaseInventaire[25]);
      
    }

    public Objet getObjet(String id){
        Objet objRet = null;
        for (int i = 0; i < this.Inventaire.size(); i++){
            if (Inventaire.get(i).getObjet().getId() == id){
                objRet = Inventaire.get(i).getObjet();
            }
        }
        return objRet;
    }
    
  

    public List<CaseInventaire> getInv(){
        return this.Inventaire;
    }

   
    

}