package ghettorraria.modele.item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CaseInventaire {
	
	private IntegerProperty quantiteProperty;
	private Objet objet;

	public CaseInventaire(int quantite,Objet objet) {
		this.objet = objet;
		this.quantiteProperty=new SimpleIntegerProperty();
	}

	
	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public IntegerProperty quantiteProperty(){
		return this.quantiteProperty;
	}
	public void setQuantiteProperty(int quantite){
		this.quantiteProperty.set(quantite);
	}
	public int getQuantite(){
		return quantiteProperty.getValue();
	}

	
	public void ajouterQuantite(){
		quantiteProperty.set(getQuantite()+1);
		
	}


    public void enleverQuantite() {
		quantiteProperty.set(getQuantite()-1);
    }

}
