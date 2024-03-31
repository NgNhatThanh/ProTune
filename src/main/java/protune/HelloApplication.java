package protune;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.controller.inapp.SongListManager;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int cnt = 1;

    @Override
    public void start(Stage stage){
        stage = Init.appStage;
        long starttime = System.currentTimeMillis();

        stage.setTitle("Hello!");
        stage.setScene(Init.logScene);
        stage.setResizable(false);
        stage.setOnHidden(e -> {
            SongListManager.exportLocalList();
            System.exit(0);
        });
        stage.show();

        Task<Void> panelTask = new Task<>() {
            @Override
            protected Void call(){
                SongListManager.getOnlineAudioList();
                return null;
            }

            @Override
            protected void succeeded() {
                System.out.println("xong");
                SongListManager.addOnlineAudio();
                System.out.println((double)(System.currentTimeMillis() - starttime) / 1000);

                try {
                    SongListManager.importLocalAudio();
                } catch (IOException | ClassNotFoundException | InvalidAudioFrameException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        var t = new Thread(panelTask);
        t.start();

    }

    public static void main(String[] args) {
        launch();
    }
}