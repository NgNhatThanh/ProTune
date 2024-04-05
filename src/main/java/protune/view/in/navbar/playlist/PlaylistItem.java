package protune.view.in.navbar.playlist;

import javafx.scene.Cursor;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import protune.model.Playlist;
import protune.view.in.mainzone.playlistpane.PlPaneManager;

public class PlaylistItem extends TextField {
    Playlist playlist;

    public PlaylistItem(Playlist playlist){
        this.playlist = playlist;
        this.setEditable(false);

        this.setText(playlist.getName());

        ContextMenu contextMenu = new ContextMenu();

        MenuItem editItem = new MenuItem("Edit");
        MenuItem delItem = new MenuItem("Delete");

        editItem.setOnAction(e -> this.setEditable(true));

        contextMenu.getItems().addAll(editItem, delItem);

        this.setBorder(Border.stroke(Color.GREEN));
        this.setCursor(Cursor.HAND);
        this.setPrefSize(228, 50);
        this.setContextMenu(contextMenu);

//        this.setOnKeyPressed(e -> {
//            if(e.getCode() == KeyCode.ENTER){
//                Playlist newPl = new Playlist(this.getText());
//                try{
//                    manager.add(newPl);
//                    this.setEditable(false);
//
//                }
//                catch (IOException ex){
//
//                }
//            }
//        });

        this.setOnMouseClicked(e -> {
            PlPaneManager.showPane(this.playlist.getName());
        });

    }


}
