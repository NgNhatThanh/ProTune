package protune.view.in.mainzone.playlistpane;

import protune.Init;
import protune.controller.inapp.SongListManager;
import protune.model.AudioData;
import protune.model.Playlist;
import protune.view.in.mainzone.homepane.audiocard.PLCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlPaneManager {
    static List<PlaylistPane> paneList = new ArrayList<>();

    static Map<String, PlaylistPane> panes = new HashMap<>();

    public static void add(Playlist playlist){
        PlaylistPane newPane = new PlaylistPane(playlist.getName());
        paneList.add(newPane);
        panes.put(playlist.getName(), newPane);

        for(String Id : playlist.getAudioIDList()){
            newPane.addSong(new PLCard(SongListManager.getAudiobyID(Id), playlist.getName()));
        }

        Init.mainZone.getChildren().add(newPane);
        newPane.toBack();
    }

    public static void showPane(String plName){
        panes.get(plName).toFront();
    }

    public static void delAll(){
        panes.clear();
        System.out.println("co " + Init.mainZone.getChildren().size() + " pane");
        Init.mainZone.getChildren().remove(paneList);
        paneList.clear();
    }

    public static void addTrack(AudioData audioData, String plName){
        panes.get(plName).addSong(new PLCard(audioData, plName));
    }

    public static void del(PLCard plCard, String plName){
        panes.get(plName).del(plCard);
        if(Init.playBar.isHaveSong() && Init.playBar.getPlayingSong().equals(plCard.getdata())) Init.playBar.reset();
    }
}
