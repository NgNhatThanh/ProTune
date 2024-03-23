package protune.view.in;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import protune.Init;
import protune.view.in.main.HomePane;
import protune.view.in.navbar.NavBar;
import protune.view.in.playbar.PlayBar;
import java.io.FileNotFoundException;

public class InAppScene extends Scene {
    AnchorPane pane;
    public InAppScene(){
        super(new AnchorPane(), 1000, 600);
        pane = new AnchorPane();
        this.setRoot(pane);

        pane.getChildren().addAll(Init.navBar, Init.homePane, Init.playBar);

    }
}
