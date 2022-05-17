package ghettorraria.modele;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Terrain {

    private static ArrayList<Integer> codesTuiles = new ArrayList<Integer>();

    public Terrain() {

        File fichierCSV = new File("ressources/terrain.csv");
        try {
            Scanner sc = new Scanner(fichierCSV);
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                codesTuiles.add(sc.nextInt());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Integer> getCodesTuiles() {
        return codesTuiles;
    }

    /*
     * public int tuileA(int positionX, int positionY) {
     * return this.terrain
     * }
     */

    public int getLargeur() {
        return 60;
    }
}