package ghettorraria.modele.item;

public class Pioche extends Arme implements Construire{

	public Pioche() {
		super("Pioche", 5, 10, 1);
		// TODO Auto-generated constructor stub
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
