package protune.view.in.playbar.player;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import protune.view.in.playbar.MyProgressBar;

public class PlayBackZone extends FlowPane {
    public PlayBackZone(){
        this.setPrefSize(480, 40);
        this.setAlignment(Pos.CENTER);
        this.setHgap(5);

        Label timeStamp = new Label("00:00");
        Label songDuration = new Label("00:00");
        timeStamp.getStyleClass().add("time-label");
        songDuration.getStyleClass().add("time-label");

        MyProgressBar progressBar = new MyProgressBar(0, 400, 10);

        this.getChildren().addAll(timeStamp, progressBar, songDuration);
    }
}
