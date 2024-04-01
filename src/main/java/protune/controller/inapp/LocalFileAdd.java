package protune.controller.inapp;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import protune.Init;
import protune.model.AudioData;
import protune.view.in.mainzone.homepane.audiocard.LocalAudioCard;

import java.io.File;
import java.util.List;

public class LocalFileAdd {
    AudioData audioData;
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
            audioData = new AudioData(file);
            if(SongListManager.find(audioData) >= 0) continue;
            Init.localPane.addSong(new LocalAudioCard(audioData));
            Init.homePane.addSong(new LocalAudioCard(audioData));
            SongListManager.addSong(audioData);
        }
    }

    public AudioData getSong(){
        return audioData;
    }

    public Media getMedia(){ return media; }

}
