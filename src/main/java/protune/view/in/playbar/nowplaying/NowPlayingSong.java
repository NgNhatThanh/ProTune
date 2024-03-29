package protune.view.in.playbar.nowplaying;

import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import protune.model.SongData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NowPlayingSong extends FlowPane {
    ImageView imageView;
    Label songName = new Label();
    Label singer = new Label();
    VBox songInfo = new VBox();
    public NowPlayingSong(){
        this.getStylesheets().add(getClass().getResource("/stylesheet/nowplaying.css").toExternalForm());
        this.getStyleClass().add("flow-pane");

        try {
            imageView = new ImageView(new Image(new FileInputStream("src/main/resources/img/default-thumbnail.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setVisible(false);

        songName.setWrapText(true);
        songName.setId("song-name");
        singer.setWrapText(true);

        songInfo.setPrefSize(150, 90);
        songInfo.setLayoutX(100);
        songInfo.getChildren().addAll(songName, singer);
        songInfo.getStyleClass().add("vbox");

        this.setPrefSize(250, 90);
        this.getChildren().addAll( imageView, songInfo);
    }

    public void setSong(SongData songData){
        imageView.setVisible(true);
        imageView.setImage(songData.getThumbnail());
//        imageView = new ImageView(songData.getThumbnail());

        Rectangle rectangle = new Rectangle(80, 80);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        imageView.setClip(rectangle);

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageView.snapshot(parameters, null);


//        imageView.setClip(null);
//        imageView.setEffect(new DropShadow(20, Color.BLACK));
        imageView.setImage(image);

//        imageView.setVisible(true);
        songName.setText(songData.getTitle());
        singer.setText(songData.getArtist());

//        this.getChildren().add(imageView);
    }
}
