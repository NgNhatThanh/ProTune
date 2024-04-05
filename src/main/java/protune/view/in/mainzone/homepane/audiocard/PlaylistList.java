package protune.view.in.mainzone.homepane.audiocard;

import javafx.scene.Cursor;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import protune.controller.PlaylistManager;
import protune.model.AudioData;

import java.util.List;

public class PlaylistList extends ListView<String> {

    AudioData currentChoose;

    public PlaylistList(){
        this.setVisible(false);
        this.setCursor(Cursor.HAND);

        this.setPrefSize(100, 100);
        this.setBorder(Border.stroke(Color.RED));

        this.setOnMouseClicked(e -> {
            String plName = this.getSelectionModel().getSelectedItem();

            if(plName != null) PlaylistManager.addTracktoPlaylist(plName, this.currentChoose);

            this.setVisible(false);
        });
    }

    public void prepare(AudioData audioData){
        currentChoose = audioData;
    }

    public void importList(){
        this.setVisible(false);
        this.getItems().clear();
        List<String> plNames = PlaylistManager.getPlNames();

        this.getItems().addAll(plNames);
    }
}
