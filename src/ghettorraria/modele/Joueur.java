package ghettorraria.modele;

import ghettorraria.modele.item.Arme;
import ghettorraria.modele.item.Materiaux;
import ghettorraria.modele.item.Nourriture;
import ghettorraria.modele.item.Objet;
import ghettorraria.modele.item.Pioche;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Joueur extends Acteur {

	private static final int PVMAX = 100;
	private boolean gauche, droite, monte, tombe;
	private int hauteurSaut;
	private Arme arme;
	private Inventaire inventaire;
	private ObjectProperty objetmain;

	private Bloc blocQuitte;

	public Joueur(Terrain terrain, Inventaire inventaire) {
		super(100, 2, terrain, 5, new Pioche(), 32, 42);
		hauteurSaut = 138;
		droite = false;
		gauche = false;
		monte = false;
		tombe = false;
		this.inventaire = inventaire;
		this.objetmain = new SimpleObjectProperty(null);
		this.objetmain.addListener((obs, oldO, newO) -> {
		});
		setObjetmain(inventaire.sourisProperty().get());

	}

	public void deplacementgaucheOui() {
		this.gauche = true;
		this.droite = false;
	}

	public void deplacementdroiteOui() {
		this.droite = true;
		this.gauche = false;
	}

	public void deplacementdroiteNon() {
		this.droite = false;
	}

	public void deplacementgaucheNon() {
		this.gauche = false;
	}

	public void saut() {
		if (blocBasSolide()) {
			Bloc bloc1 = this.getTerrain().getBloc(this.getX(), this.getY() + this.getHauteurPerso() + 5);
			Bloc bloc2 = this.getTerrain().getBloc(this.getX() + this.getLargeurPerso(),
					this.getY() + this.getHauteurPerso() + 5);
			this.blocQuitte = bloc1.estSolide() ? bloc1 : bloc2;
			this.monte = true;
			this.tombe = false;
		}
	}

	public void finsaut() {
		this.monte = false;
		this.tombe = true;
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
				if (this.blocQuitte.getY() - this.getY() <= this.hauteurSaut) {
					this.setY(this.getY() - this.getVitesseSaut());
				} else {
					finsaut();
				}
			} else {
				finsaut();
			}
		}
		if (this.tombe) {
			if (!blocBasSolide()) {
				this.setY(this.getY() + this.getVitesseChute());
			}
		}
	}

	public void poseBloc(int x, int y) {
		if ((objetmain.getValue()) instanceof Materiaux
				&& inventaire.getInv().get(inventaire.getSouris()).getQuantite() > 0) {
			if (this.getX() > x) {
				if (this.getX() - x <= 64
						&& (Math.abs(this.getY() - y) <= 64
								|| Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
					this.getTerrain().ajouterTuiles(x, y, ((Materiaux) objetmain.getValue()), inventaire);
					inventaire.getInv().get(inventaire.getSouris()).enleverQuantite();
				}
			} else {
				if (x - this.getLargeurPerso() - this.getX() <= 64 && (Math.abs(this.getY() - y) <= 64
						|| Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)
						&& (y < this.getY() - 64 + this.getHauteurPerso()
								|| y > this.getY() + this.getHauteurPerso())) {
					this.getTerrain().ajouterTuiles(x, y, ((Materiaux) objetmain.getValue()), inventaire);
					inventaire.getInv().get(inventaire.getSouris()).enleverQuantite();
				}
			}
		}
	}

	public void utiliser(int x, int y) {
		Bloc bloc = this.getTerrain().getBloc(x, y);
		if (objetmain.getValue() instanceof Pioche) {
			if (this.getX() > x) {
				if (this.getX() - x <= 64
						&& (Math.abs(this.getY() - y) <= 64
								|| Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
					bloc.pertPV(((Pioche) objetmain.getValue()).getAttaque());
				}
			} else {
				if (x - this.getLargeurPerso() - this.getX() <= 64 && (Math.abs(this.getY() - y) <= 64
						|| Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
					bloc.pertPV(((Pioche) objetmain.getValue()).getAttaque());
				}
			}
			if (bloc.getPv() <= 0) {
				this.getTerrain().supprimerTuiles(x, y, inventaire);
			}
		}
		if (this.getPv() < PVMAX && objetmain.getValue() instanceof Nourriture
				&& inventaire.getInv().get(inventaire.getSouris()).getQuantite() > 0) {
			if (this.getPv() + (((Nourriture) objetmain.getValue()).getRestaurepv()) <= PVMAX) {
				this.incrementerPv(((Nourriture) objetmain.getValue()).getRestaurepv());
				inventaire.getInv().get(inventaire.getSouris()).enleverQuantite();
			} else {
				this.incrementerPv(PVMAX - this.getPv());
				inventaire.getInv().get(inventaire.getSouris()).enleverQuantite();
			}
		}
	}

	public Arme getArme() {
		return this.arme;
	}

	public Inventaire getInv() {
		return this.inventaire;
	}

	public ObjectProperty objetmainObjectProperty() {
		return this.objetmain;
	}

	public void setObjetmain(int indice) {
		this.objetmain.set(inventaire.getInv().get(indice).getObjet());
	}

	public void setObjetMainPourTest(Objet objet) {
		this.objetmain.set(objet);
	}

	public void frappeActeur(Acteur a) {
		if (objetmain.getValue() instanceof Arme) {
			a.decrementerPv(((Arme) objetmain.getValue()).getAttaque());
		}
	}

}