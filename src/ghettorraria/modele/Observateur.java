package ghettorraria.modele;

import ghettorraria.vue.TerrainVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.BorderPane;

public class Observateur implements ListChangeListener<Bloc> {

    private BorderPane border;

    public Observateur(BorderPane p) {
        super();
        this.border = p;
    }

    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Bloc> bloc) {

        while (bloc.next()) {
            if (bloc.wasAdded()) {
                System.out.println("bloc ajouté : " + bloc.getAddedSubList());
                for (Bloc b : bloc.getAddedSubList()) {
                    addBloc(b);
                }
            }

            if (bloc.wasReplaced()) {
                System.out.println("bloc supprimé : " + bloc.getRemoved());
                for (Bloc b : bloc.getRemoved()) {
                    removeBloc(b);
                }

            }

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

    public void removeBloc(Bloc b) {
        this.border.getChildren().removeAll(this.border.lookup("#" + b.getId()));
    }
}
