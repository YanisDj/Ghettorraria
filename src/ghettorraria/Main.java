package ghettorraria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fx = new FXMLLoader(getClass().getResource("vue/vue1.fxml"));

			BorderPane root = fx.load();
			Scene scene = new Scene(root, 1920, 1056);
			Image img = new Image("ressources/background.png");
			BackgroundImage bImg = new BackgroundImage(img,
					BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER,
					BackgroundSize.DEFAULT);
			Background bGround = new Background(bImg);
			root.setBackground(bGround);
			primaryStage.setScene(scene);
			primaryStage.show();
			root.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}