package protune.view.in.playbar.player;

import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import protune.model.Constant;

public class ControlZone extends FlowPane {
    public ControlZone(){
        this.setPrefSize(480, 50);
        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        ControlButton playButton = new ControlButton(Constant.playIconPath);
        ControlButton nextButton = new ControlButton(Constant.nextIconPath);
        ControlButton previousButton = new ControlButton(Constant.previousIconPath);
        ControlButton repeatButton = new ControlButton(Constant.repeatIconPath);
        ControlButton shuffleButton = new ControlButton(Constant.shuffleIconPath);

        this.getChildren().addAll(shuffleButton, previousButton, playButton, nextButton, repeatButton);
    }
}
