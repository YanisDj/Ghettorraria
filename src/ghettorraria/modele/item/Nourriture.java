package ghettorraria.modele.item;

public class Nourriture extends Objet {

	private int restaurepv;

	public Nourriture(int id,int restaure) {
		super(id);
		this.restaurepv = restaure;
	}

	public int getRestaurepv() {
		return this.restaurepv;
	}
}
