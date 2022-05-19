package ghettorraria.modele;

public class Joueur extends Acteur {

	private boolean gauche;
	private boolean droite;
	private boolean monte;
	private boolean tombe;

	public Joueur(int pv, int vitesse, Terrain terrain) {
		super(10, 2, terrain);
		droite = false;
		gauche = false;
		monte = false;
		tombe = true;
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

	public void deplacer() {
		int xDest, yDest;
		if (this.gauche) {
			xDest = this.getX() - getVitesse();
			if (xDest >= 0) {
				this.setX(xDest);
			}
		}
		if (this.droite) {
			xDest = this.getX() + getVitesse();
			if (xDest <= this.getTerrain().getLargeur() * 32 - 32) {
				this.setX(xDest);
			}
		}
		if (this.monte) {
			for (int i = 0; i < 5; i++) {
				yDest = this.getY() - getVitesse();
				if (yDest >= 0) {
					this.setY(yDest);
				}
			}
		}
		if (this.tombe) {
			yDest = this.getY() + getVitesse() + 42;
			if (this.getTerrain().tuileA(this.getX(), yDest) == -1) {
				this.setY(yDest);
				yDest = this.getY() + getVitesse() + 42;
			}
		}
		this.getTerrain().tuileA(this.getX(), this.getY());
	}

	public void deplacementdroiteNon() {
		this.droite = false;
	}

	public void deplacementgaucheNon() {
		this.gauche = false;
	}

	/* public void gravite() {
		int yDest = this.getY() + getVitesse() + 42;
		while (this.getTerrain().tuileA(this.getX(), yDest) == -1) {
			this.setY(yDest);
			yDest = this.getY() + getVitesse() + 42;
		}
	} */

	public void saut() {
		this.monte = true;
		this.tombe = false;
	}

	public void finsaut() {
		this.monte = false;
		this.tombe = true;
	}

}