package ghettorraria.modele;

public abstract class Acteur {

    private int x,y;
    //private int dx,dy ;// direction
    private String id;
    public static int compteur=0;
    private int pv;
    public Acteur(int x, int y,int pv) {
        this.pv=pv;
        this.x=x;
        this.y = y;
        this.id="A"+compteur;
        compteur++;

    }


    public  int getX() {
        return x;
    }
    public  void setX(int n){
        x=n;
    }
    public  int getY() {
        return y;
    }
    public  void setY(int n){
        y=n;
    }
    public String getId() {
        return id;
    }
    public void decrementerPv(int n) {
        this.pv-=n;
    }
    public void incrementerPv(int n) {
        this.pv+=n;
    }
    public boolean estVivant() {
        return this.pv>0;
    }

    public void meurt(){
        this.pv=0;
    }
    public abstract void agit();

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", id=" + id ;
    }
}