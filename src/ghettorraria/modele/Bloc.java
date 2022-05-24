package ghettorraria.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bloc {

    private int id;
    private IntegerProperty xProperty;
    private IntegerProperty yProperty;
    private Collisions collisions;

    public Bloc(int idBloc, int x, int y) {
        this.id = idBloc;
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);
        this.collisions = new Collisions(this);
    }

    public int getId() {
        return this.id;
    }

    public final int getX() {
        return xProperty.getValue();
    }

    public final void setX(int n) {
        xProperty.setValue(n);
    }

    public final IntegerProperty xProperty() {
        return this.xProperty;
    }

    public final int getY() {
        return yProperty.getValue();
    }

    public final void setY(int n) {
        yProperty.setValue(n);
    }

    public final IntegerProperty yProperty() {
        return this.yProperty;
    }

    public boolean estSolide() {
        return this.collisions.solide();
    }
}