package ghettorraria.modele.item;

public class Mur extends Avancée implements Construire{

	public Mur(String nom) {
		// TODO Auto-generated constructor stub
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
