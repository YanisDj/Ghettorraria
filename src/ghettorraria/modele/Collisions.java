package ghettorraria.modele;

public class Collisions {
    
    private Bloc bloc;

    public Collisions(Bloc bloc) {
        this.bloc = bloc;
    }

    public boolean solide() {
        boolean estSolide;
        if (this.bloc.getId() !=-1) {
            estSolide = true;
        } else {
            estSolide = false;
        }
        return estSolide;
    }

}
