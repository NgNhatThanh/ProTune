package protune.view.in.mainzone.homepane.audiocard;

import protune.model.Constant;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.audiocard.button.DeleteButton;
import protune.view.in.mainzone.homepane.audiocard.button.EditButton;

public class LocalAudioCard extends AudioCard{
    public LocalAudioCard(SongData songData) {
        super(songData);

        imageZone.getChildren().addAll(new DeleteButton(Constant.deleteIconPath, this),
            new EditButton(Constant.editIconPath, this));
    }
}
