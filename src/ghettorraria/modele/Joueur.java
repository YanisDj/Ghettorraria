package ghettorraria.modele;

public class Joueur extends Acteur {

	private boolean gauche;
	private boolean droite;
	private boolean monte;
	private boolean tombe;
	private int hauteurSaut, vitesseChute, vitesseSaut;

	public final int LARGEUR_PERSO = 32;
	public final int HAUTEUR_PERSO = 42;

	public Joueur(int pv, int vitesse, Terrain terrain,Inventaire inventaire) {
		super(100, 2, terrain,inventaire);
		vitesseChute = this.getVitesse() * 3;
		vitesseSaut = this.getVitesse() * 3;
		hauteurSaut = 250;
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
				if (this.getY() + hauteurSaut>= this.getTerrain().getHauteur()*32) {
					this.setY(this.getY() - vitesseSaut);
				} else if (this.getTerrain().getBloc(this.getX(), this.getY() + hauteurSaut).estSolide()) {
					this.setY(this.getY() - vitesseSaut);
				}
			} else {
				finsaut();
			}
		}
		if (this.tombe) {
			if (!blocBasSolide()) {
				this.setY(this.getY() + vitesseChute);
			}
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
		if (this.getTerrain().getBloc(this.getX() + 1, this.getY() + HAUTEUR_PERSO + vitesseChute).estSolide()) {
			solide = true;
		} else if (this.getY() == this.getTerrain().getHauteur() * 32) {
			solide = true;
		} else if (this.getTerrain()
				.getBloc(this.getX() + LARGEUR_PERSO - 1, this.getY() + HAUTEUR_PERSO + vitesseChute)
				.estSolide()) {
			solide = true;
		} else {
			solide = false;
		}
		return solide;
	}

	public boolean blocHautSolide() {
		boolean solide;
		if (this.getTerrain().getBloc(this.getX() + 1, this.getY() - vitesseSaut).estSolide()) {
			solide = true;
		} else if (this.getY() == 0) {
			solide = true;
		} else if (this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO - 1, this.getY() - vitesseSaut).estSolide()) {
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