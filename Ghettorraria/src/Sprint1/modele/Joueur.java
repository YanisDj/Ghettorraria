package Sprint1.modele;

public class Joueur extends Acteur{

	private boolean gauche;
	private boolean droite;

	public Joueur(int pv, int vitesse, Terrain terrain) {
		super(10, 2, terrain);
		droite = false;
		gauche = false;
	}

	@Override
	public void deplacementgaucheOui() {
		this.gauche = true;
		this.droite = false;
		/*
		this.xProperty().setValue(this.xProperty().getValue()-getVitesse());
		System.out.println(xProperty().getValue());
		*/
	}

	@Override
	public void deplacementdroiteOui() {
		this.droite = true;
		this.gauche = false;
		/*
		this.xProperty().setValue(this.xProperty().getValue()+getVitesse());
		System.out.println(xProperty().getValue());	
		*/
	}

	public void deplacer(){
		int xDest;
		if (this.gauche){
			xDest = this.xProperty().getValue()-getVitesse();
			if (xDest >= 0){
				this.xProperty().setValue(this.xProperty().getValue()-getVitesse());
			}
		}
		if (this.droite){
			xDest = this.xProperty().getValue()+getVitesse();
			if (xDest <= this.getTerrain().getLargeur() * 32 - 32){
				this.xProperty().setValue(this.xProperty().getValue()+getVitesse());
			}
		}
	}

	public void deplacementdroiteNon(){
		this.droite = false;
	}

	public void deplacementgaucheNon(){
		this.gauche = false;
	}


}
