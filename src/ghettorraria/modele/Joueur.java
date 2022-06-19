package ghettorraria.modele;

import ghettorraria.modele.item.Arme;
import ghettorraria.modele.item.CaseInventaire;
import ghettorraria.modele.item.Materiaux;
import ghettorraria.modele.item.Nourriture;
import ghettorraria.modele.item.Objet;
import ghettorraria.modele.item.Pioche;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Joueur extends Acteur {

	private boolean gauche, droite, monte, tombe;
	private int hauteurSaut, vitesseChute, vitesseSaut;
	private Arme arme;
	private Mob mob;
	private Inventaire inventaire;
	private ObjectProperty objetmain;


	private Bloc blocQuitte;

	public final int LARGEUR_PERSO = 32;
	public final int HAUTEUR_PERSO = 42;
	public final int PVMAX = 100;

	public Joueur(Terrain terrain, Inventaire inventaire) {
		super(40, 2, terrain,1);
		vitesseChute = this.getVitesse() * 3;
		vitesseSaut = this.getVitesse() * 3;
		hauteurSaut = 96 + HAUTEUR_PERSO;
		droite = false;
		gauche = false;
		monte = false;
		tombe = false;
		this.mob = null;
		this.inventaire = inventaire;
		this.objetmain = new SimpleObjectProperty(null);
		this.objetmain.addListener((obs,oldO,newO)-> {});
		
		setObjetmain(inventaire.sourisProperty().get());
	}

	public Joueur(Terrain terrain){
		super(40, 2, terrain,1);
		this.objetmain = new SimpleObjectProperty(null);
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
				if (this.blocQuitte.getY()-this.getY() <= this.hauteurSaut) {
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
			Bloc bloc1 = this.getTerrain().getBloc(this.getX(), this.getY() + HAUTEUR_PERSO + 5);
			Bloc bloc2 = this.getTerrain().getBloc(this.getX() + LARGEUR_PERSO, this.getY() + HAUTEUR_PERSO + 5);
			this.blocQuitte = bloc1.estSolide() ? bloc1 : bloc2;
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

	public void utiliser(Bloc bloc){
		if (objetmain.getValue() instanceof Pioche && inventaire.getInv().get(inventaire.getSouris()).getQuantite()>0){
			bloc.pertPV(((Pioche)objetmain.getValue()).getAttaque());
		}
		if (this.getPv() < PVMAX && objetmain.getValue() instanceof Nourriture && inventaire.getInv().get(inventaire.getSouris()).getQuantite()>0){
			if (this.getPv() + (((Nourriture)objetmain.getValue()).getRestaurepv()) <= PVMAX){
				this.incrementerPv(((Nourriture)objetmain.getValue()).getRestaurepv());
				System.out.println(this.getPv());
			} else {
				this.incrementerPv(PVMAX - this.getPv());
				System.out.println(this.getPv());
			}
		}
		if (objetmain.getValue() instanceof Arme){
			mob.decrementerPv(((Arme)objetmain.getValue()).getAttaque());
		}
	}

	public void ajouterTuiles(int x, int y, Terrain terrain){
		if ((objetmain.getValue()) instanceof Materiaux && inventaire.getInv().get(inventaire.getSouris()).getQuantite()>0){
			terrain.ajouterTuiles(x, y, ((Materiaux)objetmain.getValue()),inventaire);
			inventaire.getInv().get(inventaire.getSouris()).enleverQuantite();
		}
		
	}

	

	public void frappeActeur(Acteur a){
		a.decrementerPv(this.getDegatsAttaque());
	}

	public Arme getArme(){
		return this.arme;
	}

	public Inventaire getInv(){
		return this.inventaire;
	}

	public ObjectProperty objetmainObjectProperty() {
		return this.objetmain;
	}

	public void setObjetmain(int indice) {
		this.objetmain.set(inventaire.getInv().get(indice).getObjet());
	}

	public void setObjetMainPourTest(Objet objet){
		this.objetmain.set(objet);
	}


}