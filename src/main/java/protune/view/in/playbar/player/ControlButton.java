package protune.view.in.playbar.player;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ControlButton extends Label {
    public ControlButton(String iconPath){
        this.setPrefSize(35, 35);
        try {
            setIcon(new Image(new FileInputStream(iconPath)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getStyleClass().add("control-label");
    }

    private void setIcon(Image img){
        ImageView imageView = new ImageView(img);
        this.setGraphic(imageView);
    }
}
