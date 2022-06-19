package ghettorraria.vue;

import ghettorraria.modele.Mob;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MobVue {
    
    private Pane border;
    private Mob mob;

    public MobVue(Pane border, Mob mob){
        this.border = border;
        this.mob = mob;
    }

    public void placerMob(){
        Image imageMob = new Image("ressources/"+mob.getNom()+".png");
        ImageView mobMap = new ImageView(imageMob);
        mobMap.translateXProperty().bind(mob.xProperty());
        mobMap.translateYProperty().bind(mob.yProperty());
        if (mob.getNom().equals("singe")) {
            mob.xProperty().setValue(320);
        } else {
            mob.xProperty().setValue(Math.random()*1800);
        }
       
        
        border.getChildren().add(mobMap);
    }
}
