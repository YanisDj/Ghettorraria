package ghettorraria.modele.item;

import java.util.ArrayList;

public class Bâton extends Avancée implements Construire{

	public Bâton(String nom) {
		super("Bâton");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] recette() {
		String[] construction= new String[6];
		construction[0]="Bois";
		construction[1]="Bois";
		return construction;
	}
	
	

	

}
