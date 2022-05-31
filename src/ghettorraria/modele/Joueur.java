package ghettorraria.modele;

public class Joueur extends Acteur {

	private boolean gauche;
	private boolean droite;
	private boolean monte;
	private boolean tombe;
	private BoxPlayer box;

	public final int LARGEUR_PERSO = 32;
	public final int HAUTEUR_PERSO = 42;

	public Joueur(int pv, int vitesse, Terrain terrain) {
		super(10, 4, terrain);
		this.box = new BoxPlayer(this.getX(), this.getY(), this);
		droite = false;
		gauche = false;
		monte = false;
		tombe = false;
	}
	public void deplacementgaucheOui() {
		this.gauche = true;
		this.droite = false;
	}

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
				this.setX(this.getX() + this.getVitesse());
			}
		}
		if (this.monte) {
			yDest = this.getY() - getVitesse();
			if (yDest >= 0) {
				this.setY(this.getY() - getVitesse()*3);
			}
		}
		if (this.tombe) {
			yDest = this.getY() + getVitesse() + 42;
			if (this.getTerrain().getBloc(this.getX(), yDest).getId() == -1) {
				this.setY(yDest);
			}
			tombe = false;
		}
		this.getTerrain().getBloc(this.getX(), this.getY());
	}

	public void deplacementdroiteNon() {
		this.droite = false;
	}

	public void deplacementgaucheNon() {
		this.gauche = false;
	}

	public boolean blocDroiteSolide() {
		return this.getTerrain().getBloc(this.getX() + 32, this.getY()).estSolide();
	}

	public boolean blocGaucheSolide() {
		return this.getTerrain().getBloc(this.getX(), this.getY()).estSolide();
	}

	public boolean blocBasSolide() {
		return this.getTerrain().getBloc(this.getX(), this.getY() + 42).estSolide();
	}

	public boolean blocHautSolide() {
		return this.getTerrain().getBloc(this.getX(), this.getY()).estSolide();
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