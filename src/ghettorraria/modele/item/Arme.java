package ghettorraria.modele.item;

public class Arme extends Objet{

	private int attaque;
	private int portee;

	public Arme(int attaque,int portee) {
		super();
		this.attaque = attaque;
		this.portee = portee;
	}


	public int getAttaque() {
		return attaque;
	}

	public int getPortee() {
		return portee;
	}



}
