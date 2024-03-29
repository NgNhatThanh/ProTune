package protune;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.controller.inapp.SongListManager;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int cnt = 1;
//    static {
//
//        //Disable loggers
//        System.Logger[] pin = new System.Logger[]{ System.getLogger("org.jaudiotagger") };
//
//        for (System.Logger l : pin)
//            l.isLoggable(System.Logger.Level.OFF);
//    }
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, InterruptedException {
        stage = Init.appStage;
        long starttime = System.currentTimeMillis();

//        SongListManager.importList();

//        FileInputStream fis = new FileInputStream(new File("D:\\ProTune\\src\\main\\data\\songlist.bin"));
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        ArrayList<SongData> a = (ArrayList<SongData>) ois.readObject();
//
//        for(SongData x : a) System.out.println(x.getName());
//*

        stage.setTitle("Hello!");
        stage.setScene(Init.logScene);
        stage.setResizable(false);
        stage.setOnHidden(e -> {
            SongListManager.exportList();
            System.exit(0);
        });
        stage.show();


//        Platform.runLater(() ->{
//            SongListManager.importList();
//            SongListManager.addAfterImport();
//        });

        Task<Void> panelTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                SongListManager.importOnlineAudio();

//                List<String> urlList = AWSS3Handle.getAudioUrlList();
//
//
//
//                for(String url : urlList){
//                    new Thread(() -> {
//                        SongData songData = new SongData(url);
//                        songData.init1();
////                        songDataList.add(songData);
//                        in.add(1);
////                        Init.homePane.addSong(new SongCard(songData, 0));
//                    }).start();
//
////            SongData songData = new SongData(url);
////            songData.init1();
////            songDataList.add(songData);
//                }
//                Thread.sleep(500);
                return null;
            }

            @Override
            protected void succeeded() {
                System.out.println("xong");
                SongListManager.addAfterImport();
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