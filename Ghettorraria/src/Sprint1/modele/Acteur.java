package Sprint1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Acteur {

	private IntegerProperty x,y;
    private int vitesse;
    private int pv;
    
    public Acteur(int pv,int vitesse) {
        this.pv = pv;
        this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		this.vitesse = vitesse;
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
	
	public abstract void deplacementgauche();
	public abstract void deplacementdroite();
	public abstract void deplacementbas();
}
