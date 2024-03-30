package protune.view.in.mainzone.homepane.audiocard;

import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import protune.Init;
import protune.model.SongData;

import java.io.FileNotFoundException;

public class SongCard extends FlowPane {

    public SongCard(SongData songData){
        AnchorPane imageZone = new AnchorPane();

        ImageView imageView = new ImageView(songData.getThumbnail());
        this.getStyleClass().add("song-card");
        imageView.setFitHeight(180);
        imageView.setFitWidth(180);

        Rectangle rectangle = new Rectangle(180, 180);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        imageView.setClip(rectangle);

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageView.snapshot(parameters, null);

        imageView.setClip(null);
        imageView.setEffect(new DropShadow(20, Color.BLACK));
        imageView.setImage(image);

        imageZone.getChildren().add(imageView);

        Label songName = new Label(songData.getTitle());
        Label singer = new Label(songData.getArtist());
        songName.setId("song-name");

        this.setOnMouseEntered(e -> this.getStyleClass().add("card-mousein"));
        this.setOnMouseExited(e -> this.getStyleClass().remove("card-mousein"));
        this.getStylesheets().add(getClass().getResource("/stylesheet/songcard.css").toExternalForm());
        this.getChildren().addAll(imageZone, songName, singer);

        setOnMouseClicked(e ->{
            try {
                Init.playBar.setSongPlay(songData);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
//            Init.homePane.del(this);

        });
    }
}