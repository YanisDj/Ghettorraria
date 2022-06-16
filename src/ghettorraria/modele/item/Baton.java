package ghettorraria.modele.item;

public class Baton extends Avancée implements Construire{

	public Baton() {
		super();
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[0]="Bois";
		construction[1]="Bois";
		return construction;
	}
}
