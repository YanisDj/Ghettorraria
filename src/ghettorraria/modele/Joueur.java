package ghettorraria.modele;

public class Joueur extends Acteur {

	private boolean gauche, droite, monte, tombe;
	private BoxPlayer box;
	private Collisions collisions;

	public final int LARGEUR_PERSO = 32;
	public final int HAUTEUR_PERSO = 42;

	public Joueur(int pv, int vitesse, Terrain terrain) {
		super(10, 2, terrain);
		this.box = new BoxPlayer(this);
		this.collisions = new Collisions(terrain);
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
		if (this.gauche) {
			if (!blocGaucheSolide()) {
				this.setX(this.getX() - this.getVitesse());
			}
		}
		if (this.droite) {
			if (!blocDroiteSolide()) {
				this.setX(this.getX() + this.getVitesse());
			}
		}
		if (this.monte) {
			if (!blocHautSolide()) {
				this.setY(this.getY() - this.getVitesse() * 3);
			}
		}
		if (this.tombe) {
			if (!blocBasSolide()) {
				this.setY(this.getY() + this.getVitesse());
			} else
				tombe = false;
		}
	}

	public void deplacementdroiteNon() {
		this.droite = false;
	}

	public void deplacementgaucheNon() {
		this.gauche = false;
	}

	public boolean blocDroiteSolide() {
		boolean solide;
		if (this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO, this.getY() + 1).estSolide()) {
			solide = true;
		} else if (this.getX() + LARGEUR_PERSO == this.getTerrain().getLargeur() * 32) {
			solide = true;
		} else if (this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO, this.getY() + HAUTEUR_PERSO - 1)
				.estSolide()) {
			solide = true;
		} else {
			solide = false;
		}
		return solide;
	}

	public boolean blocGaucheSolide() {
		boolean solide;
		if (this.getTerrain().getBloc(this.getX() - 1, this.getY() + 1).estSolide()) {
			solide = true;
		} else if (this.getX() == 0) {
			solide = true;
		} else if (this.getTerrain().getBloc(this.getX() - 1, this.getY() + HAUTEUR_PERSO - 1).estSolide()) {
			solide = true;
		} else {
			solide = false;
		}
		return solide;
	}

	public boolean blocBasSolide() {
		boolean solide;
		if (this.getTerrain().getBloc(this.getX() + 1, this.getY() + HAUTEUR_PERSO).estSolide()) {
			solide = true;
		} else if (this.getY() == this.getTerrain().getHauteur() * 32) {
			solide = true;
		} else if (this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO - 1, this.getY() + HAUTEUR_PERSO)
				.estSolide()) {
			solide = true;
		} else {
			solide = false;
		}
		return solide;
	}

	public boolean blocHautSolide() {
		boolean solide;
		if (this.getTerrain().getBloc(this.getX() + 1, this.getY()).estSolide()) {
			solide = true;
		} else if (this.getY() == 0) {
			solide = true;
		} else if (this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO - 1, this.getY()).estSolide()) {
			solide = true;
		} else {
			solide = false;
		}
		return solide;
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