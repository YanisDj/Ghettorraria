package ghettorraria.modele;

import java.io.*;
import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Terrain {

    private  ObservableList<Integer> codesTuiles = FXCollections.observableArrayList();

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
                    codesTuiles.add(ligne[i]);
                }
                
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<Integer> getCodesTuiles() {
        return codesTuiles;
    }

    public int tuileA( int positionY) {
        return codesTuiles.get(positionY/32*getLargeur());
    }

    public int getLargeur() {
        return 60;
    }

    public int getHauteur() {
        return 33;
    }
    
    public void supprimerTuiles(int y) {
    	System.out.println(codesTuiles.set(y/32*getLargeur(), -1));
    	if(tuileA(y)!=-1) {
    		codesTuiles.set(y/32*getLargeur(), -1);
    		
    	}
    	
    }
}