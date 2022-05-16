package ghettorraria.controleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

import ghettorraria.modele.Terrain;

public class Controleur implements Initializable {

    private Terrain terrain;

    @FXML
    private TilePane paneTerrain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        terrain = new Terrain();

        int[] codesTuiles = terrain.getCodesTuiles();
        Image terre;
        terre = new Image("terre.png");
        Image terreHerbe = new Image("herbe.png");
        for (int i : codesTuiles) {
            switch (i) {
                case 0:
                    paneTerrain.getChildren().add(new ImageView());
                    break;
                case 1:
                    paneTerrain.getChildren().add(new ImageView(terre));
                    break;
                case 2:
                    paneTerrain.getChildren().add(new ImageView(terreHerbe));
                    break;
            }
        }

    }
}