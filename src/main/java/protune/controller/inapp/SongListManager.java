package protune.controller.inapp;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.Init;
import protune.controller.AWSS3Handle;
import protune.controller.io.FileIOSystem;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.audiocard.SongCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongListManager {
    private static List<SongData> localSDList = new ArrayList<>();
    private static List<String> urlList;
    private static List<SongData> homeSDList = new ArrayList<>();
    public static List<SongData> getLocalList(){
        return localSDList;
    }
    public static int onlineAudioCount;

    public static void addSong(SongData songData){
        homeSDList.add(songData);
        localSDList.add(songData);
    }

    public static void getOnlineAudioList(){
        urlList = AWSS3Handle.getAudioUrlList();
        onlineAudioCount = urlList.size();
        for(String url : urlList){
            new Thread(() -> {
                SongData songData = new SongData(url);

                try {
                    songData.init();
                    homeSDList.add(songData);
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
        homeSDList.addAll(localSDList);
        for(var song : localSDList){
            song.init();
            Init.homePane.addSong(new SongCard(song));
            Init.localPane.addSong(new SongCard(song));
        }
    }

    public static void addOnlineAudio(){
        while(homeSDList.size() < onlineAudioCount) System.out.print("");
        for(SongData songData : homeSDList){
            Init.homePane.addSong(new SongCard(songData));
        }
    }

    public static void exportLocalList(){
        FileIOSystem.write(SongListManager.getLocalList(), "src/main/data/songlist.bin");
    }

    public static SongData getNextSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == homeSDList.size() - 1) return currentSong;
        return homeSDList.get(idx + 1);
    }

    public static SongData getPrevSong(SongData currentSong){
        int idx = find(currentSong);
        if(idx == 0) return currentSong;
        return homeSDList.get(idx-  1);
    }

    public static int find(SongData songData){ // online
        for(int i = 0; i < homeSDList.size(); ++i){
            if(homeSDList.get(i).equals(songData)) return i;
        }
        return -1;
    }

    public static void del(int id){
        homeSDList.remove(id);
    }

    public static List<SongData> findByKey(String key){
        List<SongData> result = new ArrayList<>();
        for(SongData songData : homeSDList){
            if(songData.getTitleWithoutVietAccent().toLowerCase().contains(key.toLowerCase()) ||
               songData.getTitle().toLowerCase().contains(key.toLowerCase())) result.add(songData);
        }
        return result;
    }
}
