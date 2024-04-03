package protune.view.in.navbar;

import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import protune.model.Constant;
import protune.view.in.navbar.item.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
        itemList.add(new MyLocalItem(Constant.localIconPath, "My local"));

        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
        this.getItems().addAll(itemList);
        this.getItems().add(new PlayListItem());

        this.getItems().add(new ExitItem(Constant.exitIconPath, "Log out"));
    }
}
