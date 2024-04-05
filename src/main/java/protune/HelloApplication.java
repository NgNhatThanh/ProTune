package protune;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import protune.controller.PlaylistManager;
import protune.controller.auth.Authorization;
import protune.controller.auth.UserManager;
import protune.controller.inapp.SongListManager;
import protune.view.out.WaitStage;

import java.io.IOException;

public class HelloApplication extends Application {
    WaitStage waitStage = new WaitStage();
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        UserManager.importList();

        stage = Init.appStage;
        Stage finalStage = stage;

        stage.setTitle("ProTune");
        stage.setScene(Init.logScene);
        stage.setResizable(false);
        stage.setOnHidden(e -> {
            SongListManager.exportLocalList();
            UserManager.exportList();
            if(Authorization.isAccount()) PlaylistManager.exportPlaylists();
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