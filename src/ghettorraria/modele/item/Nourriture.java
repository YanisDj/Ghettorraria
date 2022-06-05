package ghettorraria.modele.item;

public class Nourriture extends Objet{
	
	private int restaurepv;

	public Nourriture(String nom, int restaure) {
		super(nom);
		this.restaurepv = restaure;
	}

	public int getRestaurepv() {
		return this.restaurepv;
	}
}
