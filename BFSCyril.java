package ghettorraria.modele;

import java.util.ArrayList;

public class BFSCyril {

	private ArrayList<Coord> file;
	private Terrain mapTile;
	private Joueur target;
	private Coord start;
	private int[][] bfs;
	private final int jumpMax;
	private final static int VIDE = -5, IMPOSSIBLE = -2, BLOCPHYSIQUE = -9;
	
	public BFSCyril(Joueur cible, Terrain map, int jumpMax) {
		file = new ArrayList<Coord>();
		mapTile = map;
		this.jumpMax = jumpMax;
		this.target = cible;
		bfs = new int[mapTile.getHauteur()][mapTile.getLargeur()];
	}
    
	public void launch() {
		initBFS();
		file.add(start);
		bfs[start.getY()][start.getX()] = 0;
		while (!file.isEmpty()) {
			for (Coord c : getCoordProximity(file.get(0))) {
				if (availableCoord(c) ) {
					bfs[c.getY()][c.getX()] = bfs[file.get(0).getY()][file.get(0).getX()] + 1;
					file.add(c);
				}
			}
			file.remove(0);
		}
	}
	public int[][] getBFS() {
		return bfs;
	}
	private void initBFS() {
		start = new Coord(mapTile.getXCharacterInMap(target.getX()),mapTile.getYIndiceHeight(target.getYBOT()));
		for (int i = 0 ; i < mapTile.getHauteur() ; i++)
			for (int j = 0 ; j < mapTile.getLargeur() ; j++)
				if (mapTile.wasTransparent(mapTile.getCodeTuileWithIndice(j, i)))
					bfs[i][j] = VIDE;
				else 
					bfs[i][j] = BLOCPHYSIQUE;
		initJumpAllow();
		file.clear();
	} 

	private void initJumpAllow() {
		for (int i = 0 ; i < mapTile.getHauteur() ; i++)
			for (int j = 0 ; j < mapTile.getLargeur() ; j++)
				if (bfs[i][j] == BLOCPHYSIQUE)
					if (i > jumpMax && outOfRangeJump(i, j))
						bfs[i - jumpMax][j] = IMPOSSIBLE;
	}

	private boolean outOfRangeJump(int i, int j) {
		int count = 1;
		while (count <= jumpMax - 1  && bfs[i - count][j] != BLOCPHYSIQUE)
			count++;
		return count > jumpMax - 1 ;
	}

	
	private ArrayList<Coord> getCoordProximity(Coord c) {
		ArrayList<Coord> prox = new ArrayList<Coord>();
		if (c.getY() < mapTile.getHauteur() - 1)
			prox.add(new Coord(c.getX(),c.getY() + 1));
		if (c.getY() > 0)
			prox.add(new Coord(c.getX(),c.getY() - 1));
		if (c.getX() < mapTile.getLargeur() - 1)
			prox.add(new Coord(c.getX() + 1,c.getY()));
		if (c.getX() > 0)
			prox.add(new Coord(c.getX() - 1,c.getY()));
		return prox;
	}

	private boolean availableCoord(Coord c) {
		if (c.getY() < mapTile.getHauteur() - 1 && bfs[c.getY()+1][c.getX()] != IMPOSSIBLE) {
			if (bfs[c.getY()][c.getX()] == IMPOSSIBLE)
				return itsPossibleTOP(c) || itsPossibleLeft(c) || itsPossibleRight(c);
			return bfs[c.getY()][c.getX()] == VIDE;
		}
		return false;
	}
	private boolean itsPossibleTOP(Coord c) {
		return c.getY() > 0 && bfs[c.getY() - 1][c.getX()] != VIDE && bfs[c.getY() - 1][c.getX()] != IMPOSSIBLE && bfs[c.getY() - 1][c.getX()] != BLOCPHYSIQUE;
	}
	private boolean itsPossibleLeft(Coord c) {
		if (c.getX() > 0 && c.getY() < mapTile.getHauteur() - 1)
			return bfs[c.getY() + 1][c.getX() - 1] == BLOCPHYSIQUE;
		return false;
	}
	private boolean itsPossibleRight(Coord c) {
		if (c.getX() < mapTile.getLargeur() - 1 && c.getY() < mapTile.getHauteur() - 1)
			return bfs[c.getY() + 1][c.getX() + 1] == BLOCPHYSIQUE;
		return false;
	}
	public void afficherBFS() {
		for (int[] t : bfs) {
			for (int x : t) {
				for (int a = String.valueOf(x).length() ; a < 2 ; a++)
					System.out.print(" ");
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	public boolean goRight(int x, int y) {
		if (x < mapTile.getLargeur() - 1)	
			return bfs[y][x] - 1 == bfs[y][x + 1];
		return false;
	}
	public boolean goLeft(int x, int y) {
		if (x > 0)	
			return bfs[y][x] - 1 == bfs[y][x - 1];
		return false;
	}
	public boolean goUp(int x, int y) {
		if (y < mapTile.getHauteur() - 1)	
			return bfs[y][x] - 1 == bfs[y - 1][x ];
		return false;
	}
	public boolean isNear(Joueur m, int value) {
		return bfs[mapTile.getYIndiceHeight(m.getY())][mapTile.getXCharacterInMap(m.getX())] <= value;
	}


	
}