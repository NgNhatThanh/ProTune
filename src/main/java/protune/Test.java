package protune;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import protune.model.Constant;

import java.io.File;


public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(500, 500);

        ImageView imageView = new ImageView(new Image(new File(Constant.defaultSongThumbnailPath).toURI().toString()));


        Label lb = new Label("a");

        anchorPane.getChildren().addAll(imageView, lb);
        Scene scene = new Scene(anchorPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
