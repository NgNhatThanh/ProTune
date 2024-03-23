package protune;

import javafx.application.Application;
import javafx.stage.Stage;
import protune.controller.FileIOSystem;
import protune.controller.SongListManager;
import protune.model.SongData;
import protune.view.in.InAppScene;
import protune.view.out.LogScene;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        List<SongData> songList = FileIOSystem.read("D:\\ProTune\\src\\main\\data\\songlist.bin");

        SongListManager.importList(songList);

//        FileInputStream fis = new FileInputStream(new File("D:\\ProTune\\src\\main\\data\\songlist.bin"));
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        ArrayList<SongData> a = (ArrayList<SongData>) ois.readObject();
//
//        for(SongData x : a) System.out.println(x.getName());

        LogScene scene = new LogScene();
        InAppScene inAppScene = new InAppScene();

        stage.setTitle("Hello!");
        stage.setScene(inAppScene);
        stage.setResizable(false);
        stage.setOnHidden(e -> FileIOSystem.write(SongListManager.getList(), "D:\\ProTune\\src\\main\\data\\songlist.bin"));

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}