package ghettorraria.modele.item;

public class Batte extends Arme implements Construire{

	public Batte() {
		super(21,10, 2);
		// TODO Auto-generated constructor stub
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


