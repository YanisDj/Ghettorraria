package ghettorraria.modele;

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
    public void onChanged(Change<? extends Bloc> bloc) {

        while (bloc.next()) {
            int indice = bloc.getFrom();
            Terrainvue.modifierTerrain(indice);

        }

    }

}
