package protune.view.in.playbar;

import javafx.scene.layout.FlowPane;
import protune.view.in.playbar.nowplaying.NowPlayingSong;
import protune.view.in.playbar.player.PlayerZone;
import protune.view.in.playbar.volume.VolumeBar;

import java.io.FileNotFoundException;

public class PlayBar extends FlowPane {
    public PlayBar() throws FileNotFoundException {
        this.setPrefSize(980, 90);
        this.setLayoutX(10);
        this.setLayoutY(500);
        this.getStyleClass().add("bg");

        NowPlayingSong nowPlayingSong = new NowPlayingSong();
        PlayerZone playerZone = new PlayerZone();
        VolumeBar soundZone = new VolumeBar();

        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
        this.getChildren().addAll(nowPlayingSong, playerZone, soundZone);
    }
}
