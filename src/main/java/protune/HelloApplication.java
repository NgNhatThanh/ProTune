package protune;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.controller.inapp.SongListManager;
import protune.view.out.WaitStage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int cnt = 1;
    WaitStage waitStage = new WaitStage();
    @Override
    public void start(Stage stage){
        stage = Init.appStage;
        Stage finalStage = stage;

        stage.setTitle("ProTune");
        stage.setScene(Init.logScene);
        stage.setResizable(false);
        stage.setOnHidden(e -> {
            SongListManager.exportLocalList();
            System.exit(0);
        });

//        stage.show();

        long starttime = System.currentTimeMillis();
        Task<Void> panelTask = new Task<>() {
            @Override
            protected Void call(){
                System.out.println("called");
                Platform.runLater(() -> {
                    waitStage.show();
                    System.out.println("next");
                });
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
                waitStage.close();
                finalStage.show();
            }

        };

        var t = new Thread(panelTask);
        t.start();

    }


    public static void main(String[] args) {
        launch();
    }
}