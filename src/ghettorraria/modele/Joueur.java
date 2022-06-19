package ghettorraria.modele;

import ghettorraria.modele.item.Pioche;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Joueur extends Acteur {

	private boolean gauche;
	private boolean droite;
	private boolean monte;
	private boolean tombe;
	private int hauteurSaut;
	private ObjectProperty objetmain;

	private Bloc blocQuitte;

	public Joueur(Terrain terrain, Inventaire inventaire) {
		super(100, 2, terrain, inventaire, 5, new Pioche(), 32, 42);
		hauteurSaut = 138;
		droite = false;
		gauche = false;
		monte = false;
		tombe = false;
		this.objetmain = new SimpleObjectProperty(null);
		this.objetmain.addListener((obs, oldO, newO) -> {
			System.out.println(newO);
		});
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

	public void frappeBloc(int x, int y) {
		Bloc bloc = this.getTerrain().getBloc(x, y);
		if (this.getX() > x) {
			if (this.getX() - x <= 64
					&& (Math.abs(this.getY() - y) <= 64 || Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
				if (this.getArme() == null) {
					bloc.pertPV(this.getDegatsAttaque());
				} else {
					bloc.pertPV(this.getArme().getAttaque());
				}
			}
		} else {
			if (x - this.getLargeurPerso() - this.getX() <= 64 && (Math.abs(this.getY() - y) <= 64
					|| Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
				if (this.getArme() == null) {
					bloc.pertPV(this.getDegatsAttaque());
				} else {
					bloc.pertPV(this.getArme().getAttaque());
				}
			}
		}
		if (bloc.getPv() <= 0) {
			this.getTerrain().supprimerBloc(x, y);
		}
	}

	public void poseBloc(int x, int y) {
		if (this.getX() > x) {
			if (this.getX() - x <= 64
					&& (Math.abs(this.getY() - y) <= 64 || Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
				this.getTerrain().ajouterBloc(x, y);
			}
		} else if (this.getX() + this.getLargeurPerso() < x) {
			if (x - this.getLargeurPerso() - this.getX() <= 64 && (Math.abs(this.getY() - y) <= 64
					|| Math.abs(y - this.getY() - this.getHauteurPerso()) <= 64)) {
				this.getTerrain().ajouterBloc(x, y);
			}
		} else {
			if (y < this.getY() - 64 + this.getHauteurPerso() || y > this.getY() + this.getHauteurPerso()) {
				this.getTerrain().ajouterBloc(x, y);
			}
		}
	}

	public void frappeActeur(Acteur a) {
		a.decrementerPv(this.getDegatsAttaque());
	}

	public ObjectProperty getObjetmainProperty() {
		return this.objetmain;
	}

	public void setObjetmain(Object objetmain) {
		this.objetmain.set(objetmain);
	}

}