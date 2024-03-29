package protune.controller.inapp;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.Init;
import protune.controller.AWSS3Handle;
import protune.controller.io.FileIOSystem;
import protune.model.SongData;
import protune.view.in.homepane.SongCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongListManager {
    private static List<SongData> localSDList = new ArrayList<>();
    private static List<String> urlList;
    private static List<SongData> onlineSDList = new ArrayList<>();
    private static int id = 0;
    public static List<SongData> getList(){
        return localSDList;
    }

    public static void addSong(SongData songData){
        localSDList.add(songData);
        ++id;
    }

    public static SongData getSong(int id){ return localSDList.get(id); };

    public static int getId(){ return id; }

    public static void importOnlineAudio(){
        urlList = AWSS3Handle.getAudioUrlList();

        for(String url : urlList){
            new Thread(() -> {
                SongData songData = new SongData(url);

                try {
                    songData.init();
                    onlineSDList.add(songData);
                } catch (InvalidAudioFrameException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void importLocalAudio() throws IOException, ClassNotFoundException, InvalidAudioFrameException {
        localSDList = FileIOSystem.read("src/main/data/songlist.bin");
        for(var song : localSDList){
            song.init();
            Init.homePane.addSong(new SongCard(song, id++));
        }
    }

    public static void addAfterImport(){
        while(onlineSDList.size() < 22) System.out.print("");
        for(SongData songData : onlineSDList){
            Init.homePane.addSong(new SongCard(songData, id++));
        }
    }

    public static void exportList(){
        FileIOSystem.write(SongListManager.getList(), "src/main/data/songlist.bin");
    }

    public static SongData getNextSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == onlineSDList.size() - 1) return currentSong;
        return onlineSDList.get(idx + 1);
    }

    public static SongData getPrevSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == 0) return currentSong;
        return onlineSDList.get(idx-  1);
    }

    public static int find(SongData songData){ // online
        for(int i = 0; i < onlineSDList.size(); ++i){
            if(onlineSDList.get(i).equals(songData)) return i;
        }
        return -1;
    }

    public static List<SongData> findByKey(String key){
        List<SongData> result = new ArrayList<>();
        for(SongData songData : onlineSDList){
            if(songData.getTitleWithoutVietAccent().toLowerCase().contains(key.toLowerCase()) ||
               songData.getTitle().toLowerCase().contains(key.toLowerCase())) result.add(songData);
        }
        return result;
    }
}
