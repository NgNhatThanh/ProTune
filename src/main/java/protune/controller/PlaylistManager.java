package protune.controller;

import protune.controller.auth.Authorization;
import protune.controller.io.FileIOSystem;
import protune.model.AudioData;
import protune.model.Playlist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaylistManager {
    private static Map<String, Playlist> playlists = new HashMap<>();

    static int cnt;

    public static String getNewName(){ return "Playlist" + cnt++;}

    static File plFile;

    public static  void importPlaylists(){
        playlists.clear();
        System.out.println(Authorization.getCurrentUser().getUsername());
        plFile = new File("src/main/data/useraudio/" + Authorization.getCurrentUser().getUsername() + "/playlists.bin");
        List<Playlist> l;
        try {
            l = FileIOSystem.read(plFile.getPath());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(Playlist pl : l){
            playlists.put(pl.getName(), pl);
            pl.oke();
        }

        cnt = l.size();
        System.out.println(l.size());
    }

    public static  void exportPlaylists(){

        List<Playlist> l = new ArrayList<>(playlists.values());

        FileIOSystem.write(l, plFile.getPath());
    }

    public static void add(Playlist playlist) {
//        if(newPl.exists()) throw new IOException();
//        else{
            playlists.put(playlist.getName(), playlist);
//        }
    }

    public static void addTracktoPlaylist(String plName, AudioData audioData){
        Playlist tmp = playlists.get(plName);

        tmp.add(audioData.getID());
    }

    public static List<String> getPlNames(){
        return new ArrayList<>(playlists.keySet());
    }

    public static List<Playlist> getList(){ return new ArrayList<>(playlists.values()); }
}
