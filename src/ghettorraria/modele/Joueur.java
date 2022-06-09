package ghettorraria.modele;

import ghettorraria.modele.item.Arme;
import ghettorraria.modele.item.Pioche;

public class Joueur extends Acteur {

	private boolean gauche;
	private boolean droite;
	private boolean monte;
	private boolean tombe;
	private int hauteurSaut, vitesseChute, vitesseSaut;
	private Arme arme;
	private boolean changeArme;

	public final int LARGEUR_PERSO = 32;
	public final int HAUTEUR_PERSO = 42;

	public Joueur(int pv, int vitesse, Terrain terrain, Inventaire inventaire, int degatsAttaque) {
		super(100, 2, terrain, inventaire, degatsAttaque);
		vitesseChute = this.getVitesse() * 3;
		vitesseSaut = this.getVitesse() * 3;
		hauteurSaut = 250;
		droite = false;
		gauche = false;
		monte = false;
		tombe = false;
		arme = new Pioche();
		changeArme = false;
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
				if (this.getY() + hauteurSaut >= this.getTerrain().getHauteur() * 32) {
					this.setY(this.getY() - vitesseSaut);
				} else if (peutSauter()) {
					this.setY(this.getY() - vitesseSaut);
				} else {
					finsaut();
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
		if (blocBasSolide()) {
			this.monte = true;
			this.tombe = false;
		}
	}

	public void finsaut() {
		this.monte = false;
		this.tombe = true;
	}

	public boolean peutSauter() {
		Bloc plusProcheBasGauche, plusProcheBasDroite;
		int distanceSol = 0;
		do {
			plusProcheBasGauche = this.getTerrain().getBloc(this.getX() + 1, this.getY() + distanceSol);
			plusProcheBasDroite = this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO - 1, this.getY() + distanceSol);
			distanceSol++;
		} while (distanceSol <= hauteurSaut && (!plusProcheBasGauche.estSolide() && !plusProcheBasDroite.estSolide()));
		return distanceSol < hauteurSaut ? true : false;
	}

	public void frappeBloc(Bloc bloc){
		if (arme == null){
			bloc.pertPV(this.getDegatsAttaque());
		} else {
			bloc.pertPV(arme.getAttaqueBloc());
		}
	}

	public void frappeActeur(Acteur a){
		if (arme == null){
			a.decrementerPv(this.getDegatsAttaque());
		} else {
			a.decrementerPv(arme.getAttaqueBloc());
		}
	}

	public Arme getArme(){
		return this.arme;
	}

	public void changeArmeOui(){
		changeArme = true;
	}

	public void changeArmeNon(){
		changeArme = false;
	}
}