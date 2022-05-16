package Sprint1.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Acteur {

	private IntegerProperty xProperty,yProperty;
    private int x,y ;
    private int vitesse;
    private int pv;
    
    public Acteur(int pv,int vitesse) {
        this.pv=pv;
        this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
        this.x=0;
        this.y=120;
    }
    public final int getX() {
		return xProperty.getValue();
	}

	public final void setX(int n){
		xProperty.set(n);
	}
	
	public final IntegerProperty xProperty() {
		return xProperty;
	}

	public  final int getY() {
		return yProperty.getValue();
	}
	public final  void setY(int n){
		yProperty.setValue(n);;
	}
	
	public final IntegerProperty yProperty() {
		return yProperty;
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
}
