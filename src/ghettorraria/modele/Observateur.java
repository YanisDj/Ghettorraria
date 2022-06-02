package ghettorraria.modele;

import ghettorraria.vue.InventaireVue;
import ghettorraria.vue.TerrainVue;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

public class Observateur implements ListChangeListener<Bloc> {

    private TilePane terrain;
    private TerrainVue Terrainvue;

    public Observateur(TilePane p,TerrainVue vue,InventaireVue inventairevue) {
        super();
        this.terrain = p;
        this.Terrainvue=vue;
       
    }

    @Override
    public void onChanged(Change<? extends Bloc> bloc) {
        
        while (bloc.next()) {
            int indice =  bloc.getFrom();
            Terrainvue.modifierTerrain(indice);
            
            
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

}
