package ghettorraria.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bloc {

    private int id;
    private IntegerProperty yProperty;
    private int pv;

    public Bloc(int idBloc, int y) { // bloc mobile
        this.id = idBloc;
        this.yProperty = new SimpleIntegerProperty(y);
        this.pv = 10;
    }

    public int getId() {
        return this.id;
    }

    public final int getY() {
        return yProperty.getValue();
    }

    public boolean estSolide() {
        return this.id!=-1;
    }

    public int getPv(){
        return this.pv;
    }

    public void pertPV(int val){
        this.pv -= val;
    }
}
