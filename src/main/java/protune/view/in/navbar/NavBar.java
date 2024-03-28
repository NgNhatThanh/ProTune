package protune.view.in.navbar;

import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import protune.model.Constant;

public class NavBar extends ToolBar {
    public NavBar() throws FileNotFoundException {
        this.setOrientation(Orientation.VERTICAL);
        this.setPrefSize(230, 480);
        this.setLayoutX(10);
        this.setLayoutY(10);
        this.getStyleClass().add("bg");

        List<NavItem> itemList = new ArrayList<>();
        itemList.add(new HomeItem(Constant.homeIconPath, "Home"));
        itemList.add(new SearchItem(Constant.searchIconPath, "Search"));
        itemList.add(new AddSongItem(Constant.uploadIconPath, "Add song"));

        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
        this.getItems().addAll(itemList);
    }

    private void setIcon(Label label, Image icon){
        ImageView imageView = new ImageView(icon);
        label.setGraphic(imageView);
    }
}
