package ghettorraria.modele;

import java.io.*;
import java.util.ArrayList;

public class Terrain {

    private static ArrayList<Bloc[]> codesTuiles = new ArrayList<Bloc[]>();

    public Terrain() {

        String line = "";
        final String delimiter = ",";
        try {
            String filePath = "src/ressources/terrain.csv";
            FileReader fileReader = new FileReader(filePath);

            BufferedReader reader = new BufferedReader(fileReader);
            int y = 0;
            while ((line = reader.readLine()) != null) // loops through every line until null found
            {
                String[] token = line.split(delimiter); // separate every token by comma
                Bloc[] ligne = new Bloc[token.length];
                for (int x = 0; x < ligne.length; x++) {
                    ligne[x] = new Bloc(Integer.parseInt(token[x]), x, y);
                }
                codesTuiles.add(ligne);
                y++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Bloc[]> getCodesTuiles() {
        return codesTuiles;
    }

    public Bloc tuileA(int positionX, int positionY) {
        System.out.println(codesTuiles.get(positionY/32)[positionX/32].getId());
        return codesTuiles.get(positionY/32)[positionX/32];
    }

    public int getLargeur() {
        return 60;
    }

    public int getHauteur() {
        return 33;
    }
}