package protune;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import protune.controller.inapp.SongListManager;
import protune.view.in.InAppScene;
import protune.view.out.LogScene;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int cnt = 1;
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, InterruptedException {

//        SongListManager.importList();

//        FileInputStream fis = new FileInputStream(new File("D:\\ProTune\\src\\main\\data\\songlist.bin"));
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        ArrayList<SongData> a = (ArrayList<SongData>) ois.readObject();
//
//        for(SongData x : a) System.out.println(x.getName());
//*

        LogScene logScene = new LogScene();
        InAppScene inAppScene = new InAppScene();

        stage.setTitle("Hello!");
        stage.setScene(inAppScene);
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
                SongListManager.importList();

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
//                System.out.println(in.getValue());
            }

        };

        var t = new Thread(panelTask);
        t.start();

    }

    public static void main(String[] args) {
        launch();
    }
}