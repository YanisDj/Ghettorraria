package ghettorraria.modele;

import ghettorraria.modele.item.Arme;

public class Mob extends Acteur {

    private Joueur joueur;
    private boolean droite;
    private boolean gauche;
    private boolean monte;
    private boolean tombe;
    private Bloc blocQuitte;
    private int hauteurSaut;
    private String nom;

    public Mob(String nom, int pv, int vitesse, Terrain terrain, Joueur joueur, int degatsAttaque, Arme arme, int hauteurMob) {
        super(pv, vitesse, terrain,degatsAttaque, arme, 32, hauteurMob);
        this.joueur = joueur;
        this.nom = nom;
        this.hauteurSaut = 96 + getHauteurPerso();
        droite = false;
        gauche = false;
        monte = false;
        tombe = false;
    }

    public void deplacementgaucheOui() {
        this.gauche = true;
        this.droite = false;
    }

    public void deplacementdroiteOui() {
        this.droite = true;
        this.gauche = false;
    }

    public void deplacementdroiteNon() {
        this.droite = false;
    }

    public void deplacementgaucheNon() {
        this.gauche = false;
    }

    public void saut() {
        if (blocBasSolide()) {
            Bloc bloc1 = this.getTerrain().getBloc(this.getX(), this.getY() + this.getHauteurPerso() + 5);
            Bloc bloc2 = this.getTerrain().getBloc(this.getX() + this.getLargeurPerso(),
                    this.getY() + this.getHauteurPerso() + 5);
            this.blocQuitte = bloc1.estSolide() ? bloc1 : bloc2;
            this.monte = true;
            this.tombe = false;
        }
    }

    public void finsaut() {
        this.monte = false;
        this.tombe = true;
    }

    public void sensDeplacements() {
        if (Math.abs(this.getX() - joueur.getX()) <= (5 * 32) && Math.abs(this.getX() - joueur.getX()) >= 30
                && Math.abs(this.getY() - joueur.getY()) <= (5 * 32)) {
            if (this.getX() < joueur.getX()) {
                deplacementdroiteOui();
                deplacementgaucheNon();
                if (blocDroiteSolide()) {
                    saut();
                }
            } else if (this.getX() > joueur.getX()) {
                deplacementdroiteNon();
                deplacementgaucheOui();
                if (blocGaucheSolide()) {
                    saut();
                }
            }

        } else {
            deplacementdroiteNon();
            deplacementgaucheNon();
            finsaut();
        }

    }

    public void deplacer() {
        sensDeplacements();
        if (this.gauche) {
            if (!blocGaucheSolide()) {
                this.setX(this.getX() - this.getVitesse());
            }
        }
        if (this.droite) {
            if (!blocDroiteSolide()) {
                this.setX(this.getX() + this.getVitesse());
            }
        }
        if (this.monte) {
            if (!blocHautSolide()) {
                if (this.blocQuitte.getY() - this.getY() <= this.hauteurSaut) {
                    this.setY(this.getY() - this.getVitesseSaut());
                } else {
                    finsaut();
                }
            } else {
                finsaut();
            }
        }
        if (this.tombe) {
            if (!blocBasSolide()) {
                this.setY(this.getY() + this.getVitesseChute());
            }
        }
    }

    public String getNom() {
        return nom;
    }


    public void attaquer() {
        int direction = (this.getX() - this.joueur.getX() < 0) ? 1 : -1;
        this.joueur.decrementerPv(this.getDegatsAttaque());
        this.joueur.setX(this.joueur.getX() + (10 * direction));
    }

    public boolean meurt(){
        return getPv()<=0;
    }

    public void agir() {
        deplacer();
        if (Math.abs(this.getX() - joueur.getX()) <= 32 && Math.abs(this.getY() - joueur.getY()) <= 32 && !meurt()) {
            attaquer();
        }
    }
}