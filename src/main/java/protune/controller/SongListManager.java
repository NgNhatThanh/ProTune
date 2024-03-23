package protune.controller;

import javafx.scene.media.Media;
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
}
