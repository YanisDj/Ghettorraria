package ghettorraria.modele;

import java.io.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Terrain {

    private ObservableList<Bloc[]> codesTuiles = FXCollections.observableArrayList();

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

    public ObservableList<Bloc[]> getCodesTuiles() {
        return codesTuiles;
    }

    public Bloc tuileA(int positionX, int positionY) {
        System.out.println(codesTuiles.get(positionY / 32)[positionX / 32].getId());
        return codesTuiles.get(positionY / 32)[positionX / 32];
    }

    public int getLargeur() {
        return 60;
    }

    public int getHauteur() {
        return 33;
    }

    /*
     * public void gravite() {
     * try {
     * if(!perso.surDuSol())
     * this.perso.tombe(gravite);
     * }catch (LimiteMapException e) {
     * System.out.println("fin limite map");
     * }catch (CollisionException e) {
     * System.out.println("Boite de collision touche un bloc");
     * }catch (Exception e) {
     * e.printStackTrace();
     * };
     * }
     */

    public Bloc getBloc(int ligne, int colonne) {
        return this.codesTuiles.get(ligne)[colonne];
    }
}