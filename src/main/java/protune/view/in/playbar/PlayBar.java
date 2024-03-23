package protune.view.in.playbar;

import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import protune.model.SongData;
import protune.view.in.playbar.nowplaying.NowPlayingSong;
import protune.view.in.playbar.player.PlayerZone;
import protune.view.in.playbar.volume.VolumeBar;

public class PlayBar extends FlowPane {
    NowPlayingSong nowPlayingSong = new NowPlayingSong();
    PlayerZone playerZone = new PlayerZone();
    VolumeBar volumeBar = new VolumeBar();
    Media media;
    MediaPlayer mediaPlayer;
    private boolean playing = false;
    private boolean haveSong = false;
    public PlayBar(){
        this.setPrefSize(980, 90);
        this.setLayoutX(10);
        this.setLayoutY(500);
        this.getStyleClass().add("bg");

        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
        this.getChildren().addAll(nowPlayingSong, playerZone, volumeBar);
    }

    public void setSongPlay(SongData songData, Media media){
        if(this.media != null && this.media == media) return;
        this.media = media;
        this.playing = true;
        if(this.mediaPlayer != null) this.mediaPlayer.dispose();
        this.mediaPlayer = new MediaPlayer(media);
        nowPlayingSong.setSong(songData);
        playerZone.setSongPlay(this.mediaPlayer);
        volumeBar.setMediaPlayer(this.mediaPlayer);
        this.haveSong = true;
    }

    public boolean isHaveSong(){ return haveSong; }
    public boolean isPlaying(){ return playing; }

    public void setPlaying(boolean state){ this.playing = state; }

    public MediaPlayer getMediaPlayer(){ return mediaPlayer; }

    public void pause(){
        this.mediaPlayer.pause();
    }

    public void play(){
        this.mediaPlayer.play();
    }
}
