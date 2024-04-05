package protune.view.in.navbar.playlist;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import protune.Init;
import protune.controller.PlaylistManager;
import protune.model.Constant;
import protune.model.Playlist;
import protune.view.in.navbar.item.NavItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class PlayListBar extends VBox {
    NavItem title;

    VBox vBox = new VBox();
    public PlayListBar(){

        try {
            title = new NavItem(Constant.playlistIconPath, "Playlists");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        title.setOnMouseEntered(e -> {});

        AnchorPane tabIndex = new AnchorPane();

        Button addBtn = new Button();
        addBtn.setGraphic(new ImageView(new Image(new File(Constant.addIconPath).toURI().toString())));
        addBtn.setLayoutX(160);
        addBtn.setLayoutY(7);
        addBtn.setFocusTraversable(false);
        addBtn.setOnAction(e -> {
            Playlist newPl = new Playlist(PlaylistManager.getNewName());
            vBox.getChildren().add(new PlaylistItem(newPl));
            Init.playlistList.getItems().add(newPl.getName());
            PlaylistManager.add(newPl);
        });

        tabIndex.getChildren().addAll(title, addBtn);

        ScrollPane plList = new ScrollPane();
        plList.setPrefSize(230, 130);
        plList.setContent(vBox);

        this.getChildren().addAll(tabIndex, plList);
    }

    public void importPlaylists(){
        vBox.getChildren().clear();

        System.out.println("con: " + vBox.getChildren().size());
        PlaylistManager.importPlaylists();
        List<Playlist> l = PlaylistManager.getList();

        System.out.println(l.size());

        for(Playlist pl : l){
            vBox.getChildren().add(new PlaylistItem(pl));
        }
    }
}
