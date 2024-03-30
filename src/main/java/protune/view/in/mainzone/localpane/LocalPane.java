package protune.view.in.mainzone.localpane;

import protune.view.in.mainzone.homepane.HomePane;
import protune.view.in.mainzone.homepane.SongCard;

import java.util.ArrayList;
import java.util.List;

public class LocalPane extends HomePane {

    private List<SongCard> songCardList = new ArrayList<>();

    public LocalPane(){
        super();
        this.toBack();
//        super();
    }

//    public void addSong(SongCard songCard){
//
//    }
}
