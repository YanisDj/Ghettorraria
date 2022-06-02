package ghettorraria.modele;

import ghettorraria.vue.TerrainVue;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

public class Observateur implements ListChangeListener<Bloc> {

    private TilePane terrain;
    private TerrainVue vue;

    public Observateur(TilePane p,TerrainVue vue) {
        super();
        this.terrain = p;
        this.vue=vue;
    }

    @Override
    public void onChanged(Change<? extends Bloc> bloc) {
        
        while (bloc.next()) {
            int indice =  bloc.getFrom();
            vue.modifierTerrain(indice);

            }

        }
    

    public void addBloc(Bloc b) {
        /*
         * if(b instanceof BlocMobile) {
         * image= new ImageView("image/132.png");
         * }
         * 
         * else if(b instanceof BlocDestructible) {
         * image = new ImageView("image/535.png");
         * }
         * 
         * image.setId(b.getId());
         * image.translateXProperty().bind(b.xProperty());
         * image.translateYProperty().bind(b.yProperty());
         */

    }

    public void removeBloc(int x, int y) {
        this.terrain.getChildren().set(x / 32 + (y / 32 * 60), new ImageView());
        
    }
}
