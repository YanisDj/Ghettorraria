package ghettorraria.modele.item;

public class Batte extends Arme implements Construire{

	public Batte(String nom,int attaque, int porter) {
		super("Batte", 10, 2);
	}
	
	
	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[0]="Bâton";
		construction[2]="Bâton";
		construction[4]="Pierre";
		return construction;
		
	}

	
		
}


