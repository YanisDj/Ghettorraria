package ghettorraria.modele.item;

public class Arme extends Objet{

	private int attaque;
	private int portee;

	public Arme(int id,int attaque,int portee) {
		super(id);
		this.attaque = attaque;
		this.portee = portee;
	}


	public int getAttaque() {
		return this.attaque;
	}

	public int getPortee() {
		return this.portee;
	}

}