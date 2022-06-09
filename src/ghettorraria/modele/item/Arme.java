package ghettorraria.modele.item;

public class Arme extends Objet{

	private int attaqueBloc;
	private int porter;
	private int attaqueActeur;

	public Arme(String nom,int attaqueActeur,int attaqueBloc, int porter) {
		super("Arme");
		this.attaqueBloc = attaqueBloc;
		this.attaqueActeur = attaqueActeur;
		this.porter = porter;
	}


	public int getAttaqueActeur() {
		return attaqueActeur;
	}

	public int getAttaqueBloc(){
		return attaqueBloc;
	}

	public int getPorter() {
		return porter;
	}



}
