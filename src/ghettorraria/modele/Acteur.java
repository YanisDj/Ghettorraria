package ghettorraria.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Acteur {

	private IntegerProperty x,y;
    private int vitesse;
    private int pv;
	private Terrain terrain;
    
    public Acteur(int pv,int vitesse, Terrain terrain) {
        this.pv = pv;
        this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		this.vitesse = vitesse;
		this.terrain = terrain;
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
	
	public abstract void deplacementgaucheOui();
	public abstract void deplacementdroiteOui();
}
