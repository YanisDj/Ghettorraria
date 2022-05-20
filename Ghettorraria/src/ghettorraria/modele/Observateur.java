package ghettorraria.modele;


import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Observateur implements ListChangeListener<Integer>{

	
	private Terrain terrain;
	@FXML
    private BorderPane Border1;
	
	public Observateur(Terrain terrain, BorderPane border1) {
		this.terrain = terrain;
		Border1 = border1;
	}

	@Override
	public void onChanged(Change<? extends Integer> c) {
		while(c.next()) {
			
		}
	            
		
	}


}
