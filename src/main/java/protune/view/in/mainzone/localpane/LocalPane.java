package protune.view.in.mainzone.localpane;

import protune.view.in.mainzone.homepane.HomePane;
import protune.view.in.mainzone.homepane.audiocard.SongCard;

public class LocalPane extends HomePane {
    public LocalPane(){
    }

    public void addSong(SongCard songCard){
        songCardList.add(songCard);
        inside.getChildren().add(songCard);
    }
}
