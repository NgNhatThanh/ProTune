package protune.view.in.mainzone.homepane;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import protune.view.in.mainzone.homepane.audiocard.SongCard;

import java.util.ArrayList;
import java.util.List;

public class HomePane extends ScrollPane {
    protected List<SongCard> songCardList = new ArrayList<>();
    protected FlowPane inside;
    public HomePane(){
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.getStyleClass().add("bg");

        inside = new FlowPane();
        inside.setPadding(new Insets(15, 20, 15, 20));
        inside.setPrefWidth(740);
        inside.setPrefHeight(480);
        inside.getStyleClass().add("bg");
        inside.setVgap(15);
        inside.setHgap(40);

        this.setContent(inside);
        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
    }

    public void addSong(SongCard songCard){
        System.out.println("bo");
        songCardList.add(songCard);
        inside.getChildren().add(songCard);
    }

//    public void del(SongCard songCard){
//        System.out.println("xoa");
//        inside.getChildren().remove(songCard);
//        songCard.setVisible(false);
//    }
}
