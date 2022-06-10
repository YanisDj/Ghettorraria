package ghettorraria.modele.item;

public class Etablis extends Avancee implements Construire{

	public Etablis(String nom) {
		super("Etablis");
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		for(int i=0; i<6;i++) {
			construction[i]="Bois";
		}
		return construction;
	}



}
