package ghettorraria.vue;

import ghettorraria.modele.Mob;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MobVue {
    
    private Pane pane;
    private Mob mob;
    private ImageView mobMap;

    public MobVue(Pane pane, Mob mob){
        this.pane = pane;
        this.mob = mob;
    }

    public void placerMob(){
        Image imageMob = new Image("ressources/" + mob.getNom() + ".png");
        mobMap = new ImageView(imageMob);
        mobMap.setId(mob.getNom());
        mobMap.translateXProperty().bind(mob.xProperty());
        mobMap.translateYProperty().bind(mob.yProperty());
        if (mob.getNom().equals("singe")) {
            mob.xProperty().setValue(320);
        } else {
            mob.xProperty().setValue(Math.random()*1800);
        }
        pane.getChildren().add(mobMap);
    }

    public void enleverMob(){
        if (mob.meurt()) {
            pane.getChildren().remove(pane.lookup("#"+mob.getNom()));
        }
        
}
   
}
