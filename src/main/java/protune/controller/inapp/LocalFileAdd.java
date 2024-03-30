package protune.controller.inapp;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import protune.Init;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.SongCard;

import java.io.File;
import java.util.List;

public class LocalFileAdd {
    SongData songData;
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter audioFilter = new FileChooser.ExtensionFilter("Audio file", "*.mp3", "*.wav");
    Media media;
    MediaPlayer mediaPlayer;
    public LocalFileAdd(){
        fileChooser.getExtensionFilters().add(audioFilter);
    }

    public void addAudio(){
        List<File> fileList = fileChooser.showOpenMultipleDialog(null);

        if(fileList == null) return;

        for(var file : fileList){
            songData = new SongData(file);
            if(SongListManager.find(songData) >= 0) continue;
            Init.homePane.addSong(new SongCard(songData, SongListManager.getId()));
            SongListManager.addSong(songData);
        }
    }

    public SongData getSong(){
        return songData;
    }

    public Media getMedia(){ return media; }

}
