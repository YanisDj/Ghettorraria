package ghettorraria.modele.item;

public class Mur extends Avancée implements Construire{

	public Mur() {
		super(28);
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[0]="Bois";
		construction[1]="Bois";
		construction[2]="Bois";
		construction[3]="Bois";
		return construction;
	}

	

}
