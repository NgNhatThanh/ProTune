package protune.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {

    String name;

    public Playlist(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getAudioIDList() {
        return audioIDList;
    }

    List<String> audioIDList = new ArrayList<>();

    public void add(String audioID){
        audioIDList.add(audioID);
    }

    public void del(String audioID){
        audioIDList.remove(audioIDList.indexOf(audioID));
    }
}
