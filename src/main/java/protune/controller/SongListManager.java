package protune.controller;

import protune.Init;
import protune.model.SongData;
import protune.view.in.main.SongCard;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SongListManager {
    private static List<SongData> songList = new ArrayList<>();
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

    public static void importList(List<SongData> listFromFile) throws FileNotFoundException {
        songList = listFromFile;
        for(var song : songList){
            song.init();
            Init.homePane.addSong(new SongCard(song, id++));
        }
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
