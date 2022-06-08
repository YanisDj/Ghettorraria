package ghettorraria.modele;

import java.io.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Terrain {

    private ObservableList<Bloc> codesTuiles = FXCollections.observableArrayList();

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
                    codesTuiles.add(new Bloc(Integer.parseInt(token[x]), x, y));
                }
                y++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<Bloc> getCodesTuiles() {
        return codesTuiles;
    }

    public Bloc getBloc(int positionX, int positionY) {
        int colonne = positionX / 32 + (positionY / 32 * getLargeur());
        return codesTuiles.get(colonne);
    }

    public int getLargeur() {
        return 60;
    }

    public int getHauteur() {
        return 33;
    }

    public Bloc getBloc(int colonne) {
        return this.codesTuiles.get(colonne);
    }

    public void supprimerTuiles(int x, int y) {
        if (getBloc(x, y).getId() != -1 ) {
            if (getBloc(x, y).getPv() <= 0){
                codesTuiles.set(x / 32 + (y / 32 * getLargeur()), new Bloc(-1, x, y));
            }
        }
        
    }

    public int getIndiceHauteur(int x){
        return x / 32;
    }

    public int getIndiceLargeur(int y){
        return y / 32;
    }
}