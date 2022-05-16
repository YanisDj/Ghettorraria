package ghettorraria.modele;

public class Terrain {

    private static int[][] codesTuiles = {
            {2,2,2,2,2,2,2,2,2,2},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
    };

    // private static int[][]terrain;


    public Terrain() {
        // terrain = chargerTerrain("codesDuTerrain.csv");
    }

    public int[][] getCodesTuiles() {
        return codesTuiles;
    }
}