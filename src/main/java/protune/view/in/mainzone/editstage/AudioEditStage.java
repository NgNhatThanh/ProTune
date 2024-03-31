package protune.view.in.mainzone.editstage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import protune.model.Constant;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.audiocard.LocalAudioCard;

import java.io.File;
import java.io.IOException;

public class AudioEditStage extends Stage {
    public AudioEditStage(LocalAudioCard audioCard){
        SongData songData = audioCard.getdata();

        songData.setThumbnail(new Image(new File("C:\\Users\\NgThanh\\Downloads\\anh.jpg").toURI().toString()));
        audioCard.setImage(songData.getThumbnail());
        AudioFile f;
        try {
            f = AudioFileIO.read(songData.getAudioFile());
        } catch (CannotReadException | IOException | ReadOnlyFileException | TagException | InvalidAudioFrameException e) {
            throw new RuntimeException(e);
        }
        Tag tag = f.getTag();

        FlowPane flowPane = new FlowPane();
        Label l1 = new Label("Cover\nimage");
        Label l2 = new Label("Title");
        Label l3 = new Label("Artist");

        Label imageZone = new Label();
        ImageView coverImg;

        if(songData.getThumbnail().getUrl().contains(Constant.defaultSongThumbnailPath)) imageZone.setText("Null");
        else{
            coverImg = new ImageView(songData.getThumbnail());
            imageZone.setGraphic(coverImg);
        }

        Button chooseImgBtn = new Button("Choose\nimage");
        chooseImgBtn.setOnAction(e -> {

        });

        TextField title = new TextField(songData.getTitle());
        TextField artist = new TextField(songData.getArtist());

    }
}
