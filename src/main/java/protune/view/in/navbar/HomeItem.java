package protune.view.in.navbar;

import protune.Init;

import java.io.FileNotFoundException;

public class HomeItem extends NavItem{
    public HomeItem(String iconPath, String content) throws FileNotFoundException {
        super(iconPath, content);
        this.setOnMouseClicked(e -> {
            Init.homePane.setVisible(true);
            Init.searchPane.setVisible(false);
        });
    }
}
