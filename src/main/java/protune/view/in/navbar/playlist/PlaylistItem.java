package protune.view.in.navbar.playlist;

import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import protune.Init;
import protune.controller.inapp.PlaylistManager;
import protune.model.Playlist;
import protune.view.in.mainzone.playlistpane.PlPaneManager;

import java.util.Optional;

public class PlaylistItem extends Label {
    Playlist playlist;

    PlayListBar par;

    TextInputDialog changeNameDialog = new TextInputDialog();

    Optional<String> newName;

    Alert alert = new Alert(Alert.AlertType.ERROR);

    public PlaylistItem(Playlist playlist, PlayListBar par){
        this.par = par;
        this.playlist = playlist;
        this.setStyle("-fx-font-size: 15; -fx-font-weight: bold");

        this.setBorder(Border.stroke(Color.GREEN));
        this.setText(playlist.getName());

        ContextMenu contextMenu = new ContextMenu();

        MenuItem editItem = new MenuItem("Edit");
        MenuItem delItem = new MenuItem("Delete");

        alert.setHeaderText(null);

        Button okBtn = (Button)changeNameDialog.getDialogPane().lookupButton(ButtonType.OK);
        TextField inputField = changeNameDialog.getEditor();
        okBtn.disableProperty().bind(inputField.textProperty().isEmpty());

        editItem.setOnAction(e -> {
            changeNameDialog.getEditor().setText(this.playlist.getName());
            newName = changeNameDialog.showAndWait();
            if(newName.isPresent()){
                alert.setContentText(newName.get() + " is already exists");
                if(PlaylistManager.exist(newName.get())) alert.showAndWait();
                else{
                    this.setText(newName.get());
                    String oldName = this.playlist.getName();
                    PlaylistManager.changePlName(oldName, newName.get());
                    PlPaneManager.changeName(oldName, newName.get());
                    Init.playlistList.changeName(oldName, newName.get());
                }
            }
        });

        delItem.setOnAction(e -> {
            PlaylistManager.delPl(playlist);
            PlPaneManager.delPane(playlist);
            this.par.removeItem(this);
            Init.playlistList.removeItem(this.playlist.getName());
        });

        contextMenu.getItems().addAll(editItem, delItem);

        this.setBorder(Border.stroke(Color.GREEN));
        this.setCursor(Cursor.HAND);
        this.setPrefSize(228, 50);
        this.setContextMenu(contextMenu);

        this.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) PlPaneManager.showPane(this.playlist.getName());
        });

    }


}
