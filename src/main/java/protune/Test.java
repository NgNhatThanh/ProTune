package protune;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;


public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


//        AudioFile f = AudioFileIO.read(new File("C:\\Users\\NgThanh\\Downloads\\Music\\a1.mp3"));
//        Tag tag = f.getTag();
//
//        Artwork artwork = ArtworkFactory.createArtworkFromFile(new File("C:\\Users\\NgThanh\\Downloads\\anh.jpg"));
//        tag.deleteArtworkField();
//        tag.setField(artwork);
//        tag.setField(FieldKey.TITLE, "dep trai");
//        f.commit();

        ImageView imageView = new ImageView(new Image(new File("C:\\Users\\NgThanh\\Downloads\\delete.png").toURI().toString()));

        Label lb = new Label();
        lb.setGraphic(imageView);
        lb.setStyle("-fx-background-radius: 100; -fx-background-color: red; -fx-alignment: center");
        lb.setPrefSize(40, 40);
        AnchorPane anchorPane = new AnchorPane(imageView);
        anchorPane.setPrefSize(100, 100);
        anchorPane.getChildren().add(lb);


        Scene scene = new Scene(anchorPane, 100, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
