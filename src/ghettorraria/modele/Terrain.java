package ghettorraria.modele;

import java.io.*;
import java.util.ArrayList;

public class Terrain {

    private static ArrayList<int[]> codesTuiles = new ArrayList<int[]>();

    public Terrain() {

        String line = "";
        final String delimiter = ",";
        try {
            String filePath = "src/ressources/terrain.csv";
            FileReader fileReader = new FileReader(filePath);

            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) // loops through every line until null found
            {
                String[] token = line.split(delimiter); // separate every token by comma
                int[] ligne = new int[token.length];
                for (int i = 0; i < ligne.length; i++) {
                    ligne[i] = Integer.parseInt(token[i]);
                }
                codesTuiles.add(ligne);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<int[]> getCodesTuiles() {
        return codesTuiles;
    }

    public int tuileA(int positionX, int positionY) {
        System.out.println(codesTuiles.get(positionY/32)[positionX/32]);
        return codesTuiles.get(positionY/32)[positionX/32];
    }

    public int getLargeur() {
        return 60;
    }

    public int getHauteur() {
        return 33;
    }
}