package ghettorraria.controleur;

import ghettorraria.modele.Bloc;
import ghettorraria.vue.InventaireVue;
import ghettorraria.vue.TerrainVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.TilePane;

public class Observateur implements ListChangeListener<Bloc> {

    private TerrainVue Terrainvue;

    public Observateur(TilePane p, TerrainVue vue, InventaireVue inventairevue) {
        super();
        this.Terrainvue = vue;

    }

    @Override
    public void onChanged(Change<? extends Bloc> blocs) {
        while (blocs.next()) {
            for (Bloc bloc : blocs.getAddedSubList()){
                Terrainvue.modifierTuileTerrain(blocs.getFrom(), bloc.getId());
            }
        }

    }

}
