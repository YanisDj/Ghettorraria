package ghettorraria.modele.item;

public class Pioche extends Arme implements Construire{

	public Pioche(String nom, int attaque, int porter) {
		super("Pioche", 5, 1);
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[0]="Bois";
		construction[2]="Bois";
		construction[3]="Pierre";
		construction[4]="Pierre";
		construction[5]="Pierre";
		return construction;
	
	}

}
