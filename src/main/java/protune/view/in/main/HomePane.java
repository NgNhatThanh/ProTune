package protune.view.in.main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import protune.model.SongData;

public class HomePane extends ScrollPane {
    FlowPane inside;
    public HomePane(){
        this.setPrefSize(740, 480);
        this.setLayoutX(250);
        this.setLayoutY(10);
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.getStyleClass().add("bg");

        inside = new FlowPane();
        inside.setPadding(new Insets(15, 20, 15, 20));
        inside.setPrefWidth(740);
        inside.setPrefHeight(480);
        inside.getStyleClass().add("bg");
        inside.setVgap(15);
        inside.setHgap(40);

        addSong(new SongCard(new SongData()));
        addSong(new SongCard(new SongData()));
        addSong(new SongCard(new SongData()));
        addSong(new SongCard(new SongData()));

        this.setContent(inside);
        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
    }

    public void addSong(SongCard songCard){
        inside.getChildren().add(songCard);
    }
}
