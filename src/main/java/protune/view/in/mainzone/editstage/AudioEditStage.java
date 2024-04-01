package protune.view.in.mainzone.editstage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import protune.Init;
import protune.model.AudioData;
import protune.view.in.mainzone.homepane.audiocard.LocalAudioCard;

import java.io.File;
import java.io.IOException;

public class AudioEditStage extends Stage {
    File imgFile;
    ImageView coverImg;
    Label imageZone;
    public AudioEditStage(LocalAudioCard audioCard){
        AudioData audioData = audioCard.getdata();

        AudioFile f;
        try {
            f = AudioFileIO.read(audioData.getAudioFile());
        } catch (CannotReadException | IOException | ReadOnlyFileException | TagException | InvalidAudioFrameException e) {
            throw new RuntimeException(e);
        }
        Tag tag = f.getTag();

        FlowPane flowPane = new FlowPane();
        Label l1 = new Label("Cover\nimage");
        Label l2 = new Label("Audio\nTitle");
        Label l3 = new Label("Artist");

        imageZone = new Label();

        if(audioData.getThumbnail().getUrl() == null){
            coverImg = new ImageView(audioData.getThumbnail());
            imageZone.setGraphic(coverImg);
            coverImg.setFitHeight(150);
            coverImg.setFitWidth(150);
        }
        else imageZone.setText("Null");

        Button chooseImgBtn = new Button("Choose\nimage");
        chooseImgBtn.setOnAction(e -> {
            chooseImg();
        });

        TextField title = new TextField(tag.getFirst(FieldKey.TITLE));
        TextField artist = new TextField(tag.getFirst(FieldKey.ARTIST));

        Button saveBtn = new Button("Save");
        saveBtn.setOnAction(e -> {
            if(imgFile != null){
                Artwork artwork;
                try {
                    artwork = ArtworkFactory.createArtworkFromFile(imgFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                tag.deleteArtworkField();

                try {
                    tag.setField(artwork);
                } catch (FieldDataInvalidException ex) {
                    throw new RuntimeException(ex);
                }
            }

            try {
                tag.setField(FieldKey.TITLE, title.getText());
            } catch (FieldDataInvalidException ex) {
                throw new RuntimeException(ex);
            }

            try {
                tag.setField(FieldKey.ARTIST, artist.getText());
            } catch (FieldDataInvalidException ex) {
                throw new RuntimeException(ex);
            }

            try {
                f.commit();
            } catch (CannotWriteException ex) {
                throw new RuntimeException(ex);
            }

            try {
                audioData.extractMetadata();
            } catch (InvalidAudioFrameException | IOException ex) {
                throw new RuntimeException(ex);
            }

            Init.homePane.editCard(audioData);
            Init.localPane.editCard(audioData);
            Init.searchPane.editCard(audioData);

            this.close();
        });

        flowPane.setHgap(15);
        flowPane.getChildren().addAll(l1, imageZone, chooseImgBtn, l2, title, l3, artist, saveBtn);

        Scene scene = new Scene(flowPane, 510, 400);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/editstage.css").toExternalForm());
        this.setScene(scene);
        this.show();
    }

    void chooseImg(){
        FileChooser imgChoose = new FileChooser();
        imgChoose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Img file", "*.jpg", "*.png", "*jpeg"));
        imgFile = imgChoose.showOpenDialog(null);

        if(imgFile != null){
            coverImg = new ImageView(new Image(imgFile.toURI().toString()));
            coverImg.setFitHeight(150);
            coverImg.setFitWidth(150);
            imageZone.setGraphic(coverImg);
            imageZone.setText("");
        }

    }
}
