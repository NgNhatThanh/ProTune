package protune.controller.inapp;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.Init;
import protune.controller.AWSS3Handle;
import protune.controller.io.FileIOSystem;
import protune.model.SongData;
import protune.view.in.main.SongCard;

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

    public static void importList(){
//        songList = FileIOSystem.read("src/main/data/songlist.bin");
//        for(var song : songList){
////            song.init();
//            song.init1();
//            Init.homePane.addSong(new SongCard(song, id++));
//        }

//        urlList = FileIOSystem.read("src/main/data/songurl.bin");
        urlList = AWSS3Handle.getAudioUrlList();

        for(String url : urlList){
            new Thread(() -> {
                SongData songData = new SongData(url);

                try {
                    songData.init();
                    songDataList.add(songData);
                } catch (InvalidAudioFrameException e) {
                    throw new RuntimeException(e);
                }

            }).start();

//            SongData songData = new SongData(url);
//            try {
//                songData.init();
//                songDataList.add(songData);
//            } catch (InvalidAudioFrameException e) {
//                throw new RuntimeException(e);
//            }

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadOnlineSong(){

    }

    public static void addAfterImport(){
        for(SongData songData : songDataList){
            Init.homePane.addSong(new SongCard(songData, id++));
        }
    }

    public static void exportList(){
        FileIOSystem.write(SongListManager.getList(), "src/main/data/songlist.bin");
    }

    public static SongData getNextSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == songDataList.size() - 1) return currentSong;
        return songDataList.get(idx + 1);
    }

    public static SongData getPrevSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == 0) return currentSong;
        return songDataList.get(idx-  1);
    }

    public static int find(SongData songData){ // online
        for(int i = 0; i < songDataList.size(); ++i){
            if(songDataList.get(i).equals(songData)) return i;
        }
        return -1;
    }
}
