package ghettorraria.modele;

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
	}

	@Override
	public void deplacementdroiteOui() {
		this.droite = true;
		this.gauche = false;
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

	public void chute() {
		int yDest;
		int xDest;
		xDest = this.xProperty().getValue();
		yDest = this.yProperty().getValue()+32;
		while (this.getTerrain().tuileA(yDest, xDest) == -1) {
			this.yProperty().setValue(this.yProperty().getValue()+10);
			yDest = this.yProperty().getValue()+32;
		}
	}

}