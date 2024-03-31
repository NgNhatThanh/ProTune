package protune.view.in.mainzone.homepane;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import protune.view.in.mainzone.homepane.audiocard.AudioCard;

import java.util.ArrayList;
import java.util.List;

public class HomePane extends ScrollPane {
    protected List<AudioCard> audioCardList = new ArrayList<>();
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

    public void addSong(AudioCard audioCard){
        System.out.println("bo");
        audioCardList.add(audioCard);
        inside.getChildren().add(audioCard);
    }

    public void del(AudioCard audioCard){
        for(Node child : inside.getChildren()){
            if(audioCard.equal((AudioCard) child)){
                inside.getChildren().remove(child);
                break;
            }
        }
    }
}
