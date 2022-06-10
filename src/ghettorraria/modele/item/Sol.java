package ghettorraria.modele.item;

public class Sol extends Avancee implements Construire{

	public Sol(String nom) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[2]="Bois";
		construction[3]="Bois";
		construction[4]="Bois";
		construction[5]="Bois";
		return construction;
	}

	

}
