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
		tombe = false;
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
			if (!blocGaucheSolide()) {
				this.setX(xDest);
			}
		}
		if (this.droite) {
			if (!blocDroiteSolide()) {
				this.setX(this.getX()+this.getVitesse());
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
			if (this.getTerrain().tuileA(this.getX(), yDest).getId() == -1) {
				this.setY(yDest);
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

	public boolean blocDroiteSolide() {
		return this.getTerrain().tuileA(this.getX()+32, this.getY()).estSolide();
	}
	public boolean blocGaucheSolide() {
		return this.getTerrain().tuileA(this.getX(), this.getY()).estSolide();
	}

	public void saut() {
		this.monte = true;
		this.tombe = false;
	}

	public void finsaut() {
		this.monte = false;
		this.tombe = true;
	}

}