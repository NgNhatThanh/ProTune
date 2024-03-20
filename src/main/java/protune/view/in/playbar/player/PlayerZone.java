package protune.view.in.playbar.player;

import javafx.scene.layout.FlowPane;

public class PlayerZone extends FlowPane {
    public PlayerZone(){
        this.setPrefSize(480, 90);

        PlayBackZone playBackZone = new PlayBackZone();
        ControlZone controlZone = new ControlZone();

        this.getChildren().addAll(playBackZone, controlZone);
    }
}
