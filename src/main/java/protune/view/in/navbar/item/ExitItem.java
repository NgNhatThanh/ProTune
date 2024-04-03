package protune.view.in.navbar.item;

import protune.Init;

import java.io.FileNotFoundException;

public class ExitItem extends NavItem{
    public ExitItem(String iconPath, String content) throws FileNotFoundException {
        super(iconPath, content);
        this.setOnMouseClicked(e -> {
            Init.appStage.setScene(Init.logScene);
        });
    }
}
