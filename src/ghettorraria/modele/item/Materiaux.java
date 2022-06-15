package ghettorraria.modele.item;

public class Materiaux extends Objet{
    
    private int idBloc;

    public Materiaux(int idBloc){
        super();
        this.idBloc = idBloc;
    }

    public int getIdBloc(){
        return this.idBloc;
    }

}
