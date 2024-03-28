package protune;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import protune.controller.io.FileIOSystem;
import protune.controller.inapp.SongListManager;
import protune.model.SongData;
import protune.view.in.InAppScene;
import protune.view.out.LogScene;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        Task<Void> panelTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    SongListManager.importList();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }

            @Override
            protected void succeeded() {
                SongListManager.addAfterImport();
            }
        };

        var t = new Thread(panelTask);
        t.start();


//        List<String> list = new ArrayList<>();
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Chung+ta+cua+hien+tai.mp3");
//        list.add("https://ngthanh-audio.s3.ap-southeast-1.amazonaws.com/Hay+trao+cho+anh.mp3");
//
//        FileIOSystem.write(list, "src/main/data/songurl.txt");
//
//        List<String> urlList = FileIOSystem.read("src/main/data/songurl.txt");
//        System.out.println(urlList.size());

    }

    public static void main(String[] args) {
        launch();
    }
}