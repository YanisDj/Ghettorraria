package Sprint1.modele;

public class Joueur extends Acteur{

	public Joueur(int pv, int vitesse) {
		super(10, 5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deplacementgauche() {
		this.xProperty().setValue(this.xProperty().getValue()-getVitesse());
		System.out.println(xProperty().getValue());
	}

	@Override
	public void deplacementdroite() {
		this.xProperty().setValue(this.xProperty().getValue()+getVitesse());
		System.out.println(xProperty().getValue());	
	}

	public void deplacementbas(){
		this.yProperty().setValue(this.yProperty().getValue()+getVitesse());
		System.out.println(yProperty().getValue());	
	}

}
