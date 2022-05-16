package Sprint1.modele;

public class Terrain {

    private static int[][] codesTuiles = {
            {3,3,3,3,3,3,3,3,3,3},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {2,2,2,2,2,2,2,2,2,2},
            {1,1,1,1,1,1,1,1,1,1},
    };

    // private static int[][]terrain;


    public Terrain() {
        // terrain = chargerTerrain("codesDuTerrain.csv");
    }

    public static int[][] getCodesTuiles() {
        return codesTuiles;
    }
}

