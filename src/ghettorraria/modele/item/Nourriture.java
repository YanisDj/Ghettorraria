package ghettorraria.modele.item;

public class Nourriture extends Objet{
	
	private int restaurepv;

	public Nourriture(int restaure) {
		this.restaurepv = restaure;
	}

	public int getRestaurepv() {
		return this.restaurepv;
	}
}
