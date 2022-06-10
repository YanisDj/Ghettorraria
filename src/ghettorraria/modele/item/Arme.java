package ghettorraria.modele.item;

public class Arme extends Objet{

	private int attaque;
	private int porter;

	public Arme(String nom,int attaque,int porter) {
		super("Arme");
		this.attaque = attaque;
		this.porter = porter;
	}


	public int getAttaque() {
		return attaque;
	}

	public int getPorter() {
		return porter;
	}



}
