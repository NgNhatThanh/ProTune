package protune.view.in.playbar.nowplaying;

import javafx.scene.control.Label;

public class NowPlayingSong extends Label {
    public NowPlayingSong(){
        this.setPrefSize(250, 90);
        this.getStyleClass().add("player-item");
    }
}
