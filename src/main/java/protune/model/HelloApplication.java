package protune.model;

import javafx.application.Application;
import javafx.stage.Stage;
import protune.view.in.InAppScene;
import protune.view.out.LogScene;

import java.io.FileNotFoundException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {

        LogScene scene = new LogScene();
        InAppScene inAppScene = new InAppScene();


        stage.setTitle("Hello!");
        stage.setScene(inAppScene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}