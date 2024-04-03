package protune.view.in.navbar;

import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import protune.model.Constant;
import protune.view.in.navbar.item.NavItem;

import java.io.FileNotFoundException;

public class PlayListItem extends VBox {
    NavItem title;
    public PlayListItem(){
        try {
            title = new NavItem(Constant.playlistIconPath, "Playlists");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        title.setOnMouseEntered(e -> {});
        title.setCursor(Cursor.DEFAULT);

        

        FlowPane fl = new FlowPane();
        fl.setOrientation(Orientation.VERTICAL);
        fl.getChildren().addAll(new Label("1"), new Label("2"), new Label("3"), new Label("4"), new Label("55"));

        ScrollPane plList = new ScrollPane();
        plList.setContent(fl);
        plList.setPrefSize(230, 130);

        this.getChildren().addAll(title, plList);
    }
}
