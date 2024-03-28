package protune.view.in.main;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.SnapshotParameters;
import javafx.scene.shape.Rectangle;
import protune.Init;
import protune.model.SongData;
import javafx.scene.effect.DropShadow;

import java.io.FileNotFoundException;

public class SongCard extends FlowPane {
    private int id;

    public SongCard(SongData songData, int id){
        this.id = id;
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

        this.getChildren().add(imageView);

        Label songName = new Label(songData.getTitle());
        Label singer = new Label(songData.getArtist());
        songName.setId("song-name");

        this.setOnMouseEntered(e -> this.getStyleClass().add("card-mousein"));
        this.setOnMouseExited(e -> this.getStyleClass().remove("card-mousein"));
        this.getStylesheets().add(getClass().getResource("/stylesheet/songcard.css").toExternalForm());
        this.getChildren().addAll(songName, singer);

        setOnMouseClicked(e ->{
            try {
                Init.playBar.setSongPlay(songData);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


}
