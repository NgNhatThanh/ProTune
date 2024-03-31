package protune.view.in.mainzone.searchpane;

import protune.controller.inapp.SongListManager;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.HomePane;
import protune.view.in.mainzone.homepane.audiocard.AudioCard;
import protune.view.in.mainzone.homepane.audiocard.LocalAudioCard;

import java.util.List;

public class SearchResult extends HomePane {
    public SearchResult(){
        this.setPrefSize(740, 410);

        inside.setPrefWidth(740);
        inside.setPrefHeight(410);
        inside.getStyleClass().addAll("bg","search-result");

        this.setContent(inside);
    }

    public void displayResult(String key){
        inside.getChildren().clear();
        List<SongData> result = SongListManager.findByKey(key);
        for(SongData songData : result){
            if(songData.isLocal()) inside.getChildren().add(new LocalAudioCard(songData));
            else inside.getChildren().add(new AudioCard(songData));
        }
    }
}
