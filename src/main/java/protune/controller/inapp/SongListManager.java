package protune.controller.inapp;

import protune.Init;
import protune.controller.io.FileIOSystem;
import protune.model.SongData;
import protune.view.in.main.SongCard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongListManager {
    private static List<SongData> songList = new ArrayList<>();
    private static List<String> urlList;
    private static List<SongData> songDataList = new ArrayList<>();
    private static int id = 0;
    public static List<SongData> getList(){
        return songList;
    }

    public static void addSong(SongData songData){
        songList.add(songData);
        ++id;
    }

    public static SongData getSong(int id){ return songList.get(id); };

    public static int getId(){ return id; }

    public static void importList() throws IOException, ClassNotFoundException {
//        songList = FileIOSystem.read("src/main/data/songlist.bin");
//        for(var song : songList){
////            song.init();
//            song.init1();
//            Init.homePane.addSong(new SongCard(song, id++));
//        }

        urlList = FileIOSystem.read("src/main/data/songurl.txt");

        for(String url : urlList){
            new Thread(() -> {
                SongData songData = new SongData(url);
                songData.init1();
                songDataList.add(songData);

            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addAfterImport(){
//        System.out.println(urlList.size());
        for(SongData songData : songDataList){
            Init.homePane.addSong(new SongCard(songData, id++));
        }
    }

    public static void exportList(){
        FileIOSystem.write(SongListManager.getList(), "src/main/data/songlist.bin");
    }

    public static SongData getNextSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == songList.size() - 1) return currentSong;
        return songList.get(idx + 1);
    }

    public static SongData getPrevSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == 0) return currentSong;
        return songList.get(idx-  1);
    }

    public static int find(SongData songData){
        for(int i = 0; i < songList.size(); ++i){
            if(songList.get(i).equals(songData)) return i;
        }
        return -1;
    }
}
