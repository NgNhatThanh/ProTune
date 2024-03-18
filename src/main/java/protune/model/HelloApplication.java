package protune.model;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import protune.view.LogScene;

import java.io.FileNotFoundException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {

        LogScene scene = new LogScene();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}