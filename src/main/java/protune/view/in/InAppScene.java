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

        pane.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            if (!Init.playlistList.getBoundsInParent().contains(event.getX(), event.getY())) {
                Init.playlistList.setVisible(false);
            }
        });

        pane.getChildren().addAll(Init.navBar, Init.mainZone, Init.playBar, Init.playlistList);

    }

    public void modify(){
        Init.navBar.modify();
        Init.playlistList.importList();
    }

    public void reset(){
        Init.playBar.reset();
        Init.navBar.reset();

    }
}
