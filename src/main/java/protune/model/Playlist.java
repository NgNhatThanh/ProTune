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
    List<String> audioIDList = new ArrayList<>();

    public void add(String audioID){
        audioIDList.add(audioID);
    }

    public void oke(){
        System.out.println(audioIDList.size());
        for(String x : audioIDList) System.out.println(x);
    }
}
