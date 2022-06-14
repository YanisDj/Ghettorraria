package ghettorraria.modele;

public class Mob extends Acteur{

    private Joueur joueur;
    private BFS bfs;

    public Mob(int pv, int vitesse, Terrain terrain, Joueur joueur, int degatsAttaque) {
        super(pv, vitesse, terrain, degatsAttaque);
        this.joueur = joueur;
        this.bfs = new BFS(joueur, terrain, 10);
    }

    public void deplacer(){
        int xDest;
        bfs.algoBfs();
        //bfs.afficherBFS();
        if (bfs.estProche(joueur, 8)){
            if (bfs.droite(convert(this.getX()), convert(this.getY()))){
                System.out.println("droite");
                if (!blocDroiteSolide()) {
                    System.out.println("je passe");
                    this.setX(this.getX() + this.getVitesse());
                }
            }
            else if (bfs.gauche(convert(this.getX()), convert(this.getY()))){
                xDest = this.getX() - getVitesse();
                if (!blocGaucheSolide()) {
                    this.setX(xDest);
                }
            }
            else if (bfs.saute(convert(this.getX()), convert(this.getY()))){
                
            }
        }
    }

    public boolean blocDroiteSolide() {
		return this.getTerrain().getBloc(this.getX() + 32, this.getY()).estSolide();
	}

	public boolean blocGaucheSolide() {
		return this.getTerrain().getBloc(this.getX(), this.getY()).estSolide();
	}

	public boolean blocBasSolide() {
		return this.getTerrain().getBloc(this.getX(), this.getY() + 42).estSolide();
	}

	public boolean blocHautSolide() {
		return this.getTerrain().getBloc(this.getX(), this.getY()).estSolide();
	}

    public int convert(int a){
        return a/32;
    }

	@Override
	public void deplacementgaucheOui() {
		
	}

	@Override
	public void deplacementdroiteOui() {
		
	}
}