package ghettorraria.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Bloc {

    private int id;
    private DoubleProperty xProperty;
    private DoubleProperty yProperty;
    private Collisions collisions;

    public Bloc(int idBloc, int x, int y) { // bloc mobile
        this.id = idBloc;
        this.xProperty = new SimpleDoubleProperty(x);
        this.yProperty = new SimpleDoubleProperty(y);
        this.collisions = new Collisions(this);
    }

    public int getId() {
        return this.id;
    }

    public final double getX() {
        return xProperty.getValue();
    }

    public final void setX(double n) {
        xProperty.setValue(n);
    }

    public final DoubleProperty xProperty() {
        return this.xProperty;
    }

    public final double getY() {
        return yProperty.getValue();
    }

    public final void setY(double n) {
        yProperty.setValue(n);
    }

    public final DoubleProperty yProperty() {
        return this.yProperty;
    }

    public boolean estSolide() {
        return this.collisions.solide();
    }
}
