package protune.controller.inapp;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import protune.Init;
import protune.controller.AWSS3Handle;
import protune.controller.io.FileIOSystem;
import protune.model.AudioData;
import protune.view.in.mainzone.homepane.audiocard.AudioCard;
import protune.view.in.mainzone.homepane.audiocard.LocalAudioCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongListManager {
    private static List<AudioData> localSDList = new ArrayList<>();
    private static List<String> urlList;
    private static List<AudioData> homeSDList = new ArrayList<>();
    public static List<AudioData> getLocalList(){
        return localSDList;
    }
    public static int onlineAudioCount;

    public static void addSong(AudioData audioData){
        homeSDList.add(audioData);
        localSDList.add(audioData);
    }

    public static void getOnlineAudioList(){
        urlList = AWSS3Handle.getAudioUrlList();
        onlineAudioCount = urlList.size();
        for(String url : urlList){
            new Thread(() -> {
                AudioData audioData = new AudioData(url);

                try {
                    audioData.init();
                    homeSDList.add(audioData);
                } catch (InvalidAudioFrameException | IOException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
    }

    public static void importLocalAudio() throws ClassNotFoundException, InvalidAudioFrameException, IOException {
        localSDList = FileIOSystem.read("src/main/data/songlist.bin");
        for(int i = 0; i < localSDList.size(); ++i){
            try {
                localSDList.get(i).init();
                Init.homePane.addSong(new LocalAudioCard(localSDList.get(i)));
                Init.localPane.addSong(new LocalAudioCard(localSDList.get(i)));
            } catch (IOException e) {
                localSDList.remove(i);
            }
        }
        homeSDList.addAll(localSDList);
    }

    public static void addOnlineAudio(){
        while(homeSDList.size() < onlineAudioCount) System.out.print("");
        for(AudioData audioData : homeSDList){
            Init.homePane.addSong(new AudioCard(audioData));
        }
    }

    public static void exportLocalList(){
        FileIOSystem.write(SongListManager.getLocalList(), "src/main/data/songlist.bin");
    }

    public static AudioData getNextSong(AudioData currentSong){
        int idx = find(currentSong);
        if(idx == homeSDList.size() - 1) return currentSong;
        return homeSDList.get(idx + 1);
    }

    public static AudioData getPrevSong(AudioData currentSong){
        int idx = find(currentSong);
        if(idx == 0) return currentSong;
        return homeSDList.get(idx-  1);
    }

    public static int find(AudioData audioData){ // online
        for(int i = 0; i < homeSDList.size(); ++i){
            if(homeSDList.get(i).isSamePath(audioData)) return i;
        }
        return -1;
    }

    public static void del(AudioData audioData){
        for(int i = 0; i < localSDList.size(); ++i){
            if(localSDList.get(i).isSamePath(audioData)){
                localSDList.remove(i);
                homeSDList.remove(onlineAudioCount + i);
            }
        }
    }

    public static List<AudioData> findByKey(String key){
        List<AudioData> result = new ArrayList<>();
        for(AudioData audioData : homeSDList){
            if(audioData.getTitleWithoutVietAccent().toLowerCase().contains(key.toLowerCase()) ||
               audioData.getTitle().toLowerCase().contains(key.toLowerCase())) result.add(audioData);
        }
        return result;
    }
}
