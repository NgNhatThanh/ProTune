package protune.view.in.mainzone.homepane.audiocard;

import protune.model.Constant;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.audiocard.button.DeleteButton;

public class LocalAudioCard extends AudioCard{
    public LocalAudioCard(SongData songData) {
        super(songData);

        imageZone.getChildren().add(new DeleteButton(Constant.deleteIconPath, this));
    }
}
