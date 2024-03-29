package protune.view.in.searchpane;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import protune.controller.inapp.SongListManager;
import protune.model.SongData;
import protune.view.in.homepane.SongCard;

import java.util.List;

public class SearchResult extends ScrollPane {
    static FlowPane inside;
    public SearchResult(){
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setPrefSize(740, 410);


        inside = new FlowPane();
        inside.setPadding(new Insets(15, 20, 15, 20));
        inside.setPrefWidth(740);
        inside.setPrefHeight(410);
        inside.setVgap(15);
        inside.setHgap(40);
        inside.getStyleClass().addAll("bg","search-result");

        this.setContent(inside);
    }

    public void displayResult(String key){
        inside.getChildren().clear();
        List<SongData> result = SongListManager.findByKey(key);
        for(SongData songData : result){
            inside.getChildren().add(new SongCard(songData, 0));
        }
    }
}
