package ghettorraria.modele;

import java.io.*;
import java.util.ArrayList;

public class Terrain {

    private static ArrayList<Integer> codesTuiles = new ArrayList<Integer>();

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
                for (String tuile : token) {
                    codesTuiles.add(Integer.parseInt(tuile));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Integer> getCodesTuiles() {
        return codesTuiles;
    }

    public int tuileA(int positionX, int positionY) {
        return codesTuiles.get(positionX/32+(positionY/32));
    }

    public int getLargeur() {
        return 60;
    }
}