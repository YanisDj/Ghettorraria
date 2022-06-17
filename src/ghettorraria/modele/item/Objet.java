package ghettorraria.modele.item;

import java.util.UUID;

public class Objet {

    private String nom;
    private String id;
  

    public Objet(){
    }



	public String setId(){
        return UUID.randomUUID().toString();
    }

    public String getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }
    
}
