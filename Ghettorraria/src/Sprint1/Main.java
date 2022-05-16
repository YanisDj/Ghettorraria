package Sprint1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fx= new FXMLLoader(getClass().getResource("vue/vue1.fxml"));
			
			
			BorderPane root = fx.load();
			Scene scene = new Scene(root,320,320);
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