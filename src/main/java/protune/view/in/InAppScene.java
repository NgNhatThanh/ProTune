package protune.view.in;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import protune.Init;

public class InAppScene extends Scene {
    AnchorPane pane;
    public InAppScene(){
        super(new AnchorPane(), 1000, 600);
        pane = new AnchorPane();
        this.setRoot(pane);

        pane.getChildren().addAll(Init.navBar, Init.homePane, Init.searchPane, Init.playBar);

    }
}
