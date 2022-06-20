package ghettorraria.vue;


import ghettorraria.modele.Joueur;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class JoueurVue {

    private Pane pane;
    private Joueur joueur;

    public JoueurVue(Pane border, Joueur joueur) {
        this.pane = border;
        this.joueur = joueur;
    }

    public void placerJoueur() {
        Image imagejoueur = new Image("ressources/joueurtest.png");
        ImageView joueurmap = new ImageView(imagejoueur);
        joueurmap.setId("Joueur");
        joueurmap.translateXProperty().bind(joueur.xProperty());
        joueurmap.translateYProperty().bind(joueur.yProperty());
        joueur.xProperty().setValue(320);
        pane.getChildren().add(joueurmap);
    }

    public void mortJoueur() {
        ImageView joueurImage = (ImageView) pane.lookup("#Joueur");
        joueurImage.setRotate(90);
        Label lblGameOver = new Label("La rue t'a eu mon gars !");
        lblGameOver.setLayoutX(700);
        lblGameOver.setLayoutY(450);
        lblGameOver.setTextAlignment(TextAlignment.CENTER);
        lblGameOver.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 35));
        lblGameOver.setEffect(new InnerShadow(10, Color.DARKRED));
        pane.getChildren().add(lblGameOver);
    }
}