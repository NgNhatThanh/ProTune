package protune.view.in.homepane;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;

public class HomePane extends ScrollPane {
    List<SongCard> songCardList = new ArrayList<>();
    static FlowPane inside;
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

        System.out.println("call");
        this.setContent(inside);
        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
    }

    public void addSong(SongCard songCard){
        songCardList.add(songCard);
        inside.getChildren().add(songCard);
    }
}
