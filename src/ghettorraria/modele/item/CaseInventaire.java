package ghettorraria.modele.item;

public class CaseInventaire {
	private int quantite;
	private Objet objet;

	public CaseInventaire(int quantite,Objet objet) {
		this.objet=objet;
		this.quantite=quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}


}
