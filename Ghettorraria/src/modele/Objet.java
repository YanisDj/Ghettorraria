package ghettorraria.modele;

import java.util.UUID;

public class Objet {

    private String nom;
    private String id;

    public Objet(String nom){
        this.nom = nom;
        this.id = this.setId();
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
