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
import protune.view.in.mainzone.playlistpane.PlPaneManager;
import protune.view.in.navbar.item.NavItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class PlayListBar extends VBox {
    NavItem title;

    VBox plList = new VBox();
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
            plList.getChildren().add(new PlaylistItem(newPl, this));
            Init.playlistList.getItems().add(newPl.getName());
            PlaylistManager.add(newPl);
            PlPaneManager.add(newPl);
        });

        tabIndex.getChildren().addAll(title, addBtn);

        ScrollPane plList = new ScrollPane();
        plList.setPrefSize(230, 120);
        plList.setContent(this.plList);

        this.getChildren().addAll(tabIndex, plList);
    }

    public void importPlaylists(){
        plList.getChildren().clear();

        PlaylistManager.importPlaylists();
        List<Playlist> l = PlaylistManager.getList();

        for(Playlist pl : l){
            plList.getChildren().add(new PlaylistItem(pl, this));
        }
    }

    public void removeItem(PlaylistItem item){
        plList.getChildren().remove(item);
    }
}
