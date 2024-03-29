package protune.view.in.navbar;

import protune.Init;

import java.io.FileNotFoundException;

public class SearchItem extends NavItem{
    public SearchItem(String iconPath, String content) throws FileNotFoundException {
        super(iconPath, content);
        this.setOnMouseClicked(e -> {
            Init.homePane.setVisible(false);
            Init.searchPane.setVisible(true);
        });
    }
}
