package ghettorraria.modele;

import java.util.ArrayList;

public class BFS {

	private Coord depart;
	private Terrain terrain;
	private ArrayList<Coord> file;
	private int[][] tabBfs;
	private final static int sautMax = 128;
	private final static int VIDE = -2;
	private final static int IMPOSSIBLE = -9;
	private final static int PHYSIQUE = -5;
	private Acteur acteur;

	public BFS(Acteur a, Terrain terrain) {
		this.terrain = terrain;
		this.file = new ArrayList<Coord>();
		this.tabBfs = new int[terrain.getHauteur()*32][terrain.getLargeur()*32];
		this.acteur = a;
	}

	public void algoBfs() {
		initBfs();
		file.add(depart);
		tabBfs[depart.getY()][depart.getX()] = 0;
		while (!file.isEmpty()) {
			for (Coord c : adjacent(file.get(0))) {
				if (estValable(c)) {
					tabBfs[c.getY()][c.getX()] = tabBfs[file.get(0).getY()][file.get(0).getX()] + 1;
					file.add(c);
				}
			}
			file.remove(0);
		}
	}

	public ArrayList<Coord> adjacent(Coord c) {
		ArrayList<Coord> listeRet = new ArrayList<Coord>();
		if (c.getX() > 0) {
			listeRet.add(new Coord(c.getX() - 1, c.getY()));
		}
		if (c.getX() < terrain.getLargeur() - 1) {
			listeRet.add(new Coord(c.getX() + 1, c.getY()));
		}
		if (c.getY() > 0) {
			listeRet.add(new Coord(c.getX(), c.getY() - 1));
		}
		if (c.getY() < terrain.getHauteur() - 1) {
			listeRet.add(new Coord(c.getX(), c.getY() + 1));
		}
		return listeRet;
	}

	public boolean estValable(Coord c) {
		if (c.getY() < terrain.getHauteur() - 1 && tabBfs[c.getY() + 1][c.getX()] != IMPOSSIBLE) {
			if (tabBfs[c.getY()][c.getX()] == IMPOSSIBLE) {
				return possibleHaut(c) || possibleGauche(c) || possibleDroite(c);
			}
			return tabBfs[c.getY()][c.getX()] == VIDE;
		}
		return false;
	}

	private boolean possibleHaut(Coord c) {
		return c.getY() > 0 && tabBfs[c.getY() - 1][c.getX()] != VIDE && tabBfs[c.getY() - 1][c.getX()] != IMPOSSIBLE
				&& tabBfs[c.getY() - 1][c.getX()] != PHYSIQUE;
	}

	private boolean possibleGauche(Coord c) {
		if (c.getX() > 0 && c.getY() < terrain.getHauteur() - 1) {
			return tabBfs[c.getY() + 1][c.getX() - 1] == PHYSIQUE;
		}
		return false;
	}

	private boolean possibleDroite(Coord c) {
		if (c.getX() < terrain.getLargeur() - 1 && c.getY() < terrain.getHauteur() - 1) {
			return tabBfs[c.getY() + 1][c.getX() + 1] == PHYSIQUE;
		}
		return false;
	}

	public void initBfs() {
		for (int i = 0; i < terrain.getHauteur(); i++) {
			for (int j = 0; j < terrain.getLargeur(); j++) {
				if (terrain.getBloc(i, j).estSolide()) {
					tabBfs[i][j] = PHYSIQUE;
				} else {
					tabBfs[i][j] = VIDE;
				}
			}
		}
		depart = new Coord(acteur.getX(), (acteur.getY()) + acteur.getHauteurPerso());
		initSaut();
		file.clear();
	}

	public void initSaut() {
		for (int i = 0; i < terrain.getHauteur(); i++) {
			for (int j = 0; j < terrain.getLargeur(); j++) {
				if (tabBfs[i][j] == PHYSIQUE) {
					if (i > sautMax && sautPossible(i, j)) {
						tabBfs[i - sautMax][j] = IMPOSSIBLE;
					}
				}
			}
		}
	}

	public boolean sautPossible(int i, int j) {
		int compteur = 1;
		while (compteur <= sautMax - 1 && tabBfs[i - compteur][j] != PHYSIQUE) {
			compteur++;
		}
		return compteur > sautMax - 1;
	}

	public boolean droite(int x, int y) {
		if (x < terrain.getLargeur() - 1) {
			System.out.println("droite");
			return tabBfs[y][x] - 1 == tabBfs[y][x + 1];
		}
		return false;
	}

	public boolean gauche(int x, int y) {
		if (x > 0) {
			System.out.println("gauche");
			return tabBfs[y][x] - 1 == tabBfs[y][x - 1];
		}
		return false;
	}

	public boolean saute(int x, int y) {
		if (y < terrain.getHauteur() - 1 && y>0) {
			System.out.println("saute");
			return tabBfs[y][x] - 1 == tabBfs[y-1][x];
		}
		return false;
	}

	public boolean estProche(Acteur a, int val) {
		return tabBfs[(acteur.getY() / 32)][acteur.getX() / 32] <= val;
	}

	public int[][] getBFS() {
		return tabBfs;
	}

	public void afficherBFS() {
		for (int[] t : tabBfs) {
			for (int x : t) {
				for (int i = String.valueOf(x).length(); i < 2; i++) {
					System.out.print(" ");
				}
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
