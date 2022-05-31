package ghettorraria.modele.item;

public class Couteau extends Arme implements Construire{

	public Couteau(String nom,int attaque, int porter) {
		super("Couteau",15, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[0]="Bâton";
		construction[2]="Acier";
		construction[4]="Acier";
		return construction;
	}

	

	

}


