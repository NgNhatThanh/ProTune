package protune.view.in.playbar.volume;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import protune.model.Constant;
import protune.view.in.playbar.MyProgressBar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VolumeBar extends FlowPane {
    public VolumeBar() throws FileNotFoundException {
        this.setPrefSize(245, 90);
        this.getStyleClass().add("player-item");
        this.getStyleClass().add("volume-bar");
        this.setHgap(15);

        Image image = new Image(new FileInputStream(Constant.volumeIconPath));
        ImageView volumeIcon = new ImageView(image);

        MyProgressBar volume = new MyProgressBar(100, 120, 10);

        this.getChildren().addAll(volumeIcon, volume);
    }
}
