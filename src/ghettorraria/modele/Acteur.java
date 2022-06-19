package ghettorraria.modele;

import ghettorraria.modele.item.Arme;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Acteur {

	private IntegerProperty x,y;
    private int vitesse;
    private int pv;
	private Terrain terrain;
	private Inventaire inventaire;
	private int degatsAttaque;
	private Arme arme;
	private int LARGEUR_PERSO;
	private int HAUTEUR_PERSO;
	private int vitesseChute;
	private int vitesseSaut;
    
    public Acteur(int pv,int vitesse, Terrain terrain, Inventaire inventaire, int degatsAttaque, Arme arme, int largeurActeur, int hauteurActeur) {
        this.pv = pv;
        this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		this.vitesse = vitesse;
		this.vitesseSaut = getVitesse()*3;
		this.vitesseChute = getVitesse()*3;
		this.terrain = terrain;
		this.inventaire = inventaire;
		this.degatsAttaque = degatsAttaque;
		this.arme = arme;
		this.LARGEUR_PERSO = largeurActeur;
		this.HAUTEUR_PERSO = hauteurActeur;
    }

    public final int getX() {
		return x.getValue();
	}

	public final void setX(int n){
		x.set(n);
	}
	
	public final IntegerProperty xProperty() {
		return x;
	}

	public  final int getY() {
		return y.getValue();
	}
	public final  void setY(int n){
		y.setValue(n);;
	}
	
	public final IntegerProperty yProperty() {
		return y;
	}
	public int getVitesse() {
		return vitesse;
	}
	public int getPv() {
		return pv;
	}
	public void decrementerPv(int n) {
		this.pv-=n;	
	}

	public void incrementerPv(int n) {
		this.pv+=n;	
	}

	public Terrain getTerrain(){
		return this.terrain;
	}

	public Inventaire getInv(){
		return this.inventaire;
	}

	public Arme getArme() {
		return this.arme;
	}

	public int getDegatsAttaque(){
		return this.degatsAttaque;
	}

	public int getHauteurPerso(){
		return this.HAUTEUR_PERSO;
	}

	public int getLargeurPerso(){
		return this.LARGEUR_PERSO;
	}

	public int getVitesseSaut(){
		return this.vitesseSaut;
	}

	public int getVitesseChute(){
		return this.vitesseChute;
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

}