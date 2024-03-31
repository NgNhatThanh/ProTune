package protune.view.in.mainzone.homepane.audiocard;

import javafx.scene.image.Image;
import protune.model.Constant;
import protune.model.SongData;
import protune.view.in.mainzone.homepane.audiocard.button.DeleteButton;
import protune.view.in.mainzone.homepane.audiocard.button.EditButton;

public class LocalAudioCard extends AudioCard{
    DeleteButton deleteButton;
    EditButton editButton;
    public LocalAudioCard(SongData songData) {
        super(songData);
        deleteButton = new DeleteButton(Constant.deleteIconPath, this);
        editButton = new EditButton(Constant.editIconPath, this);
        btnManager.add(deleteButton);
        btnManager.add(editButton);
        imageZone.getChildren().addAll(deleteButton, editButton);
    }

    public void setImage(Image thumbnail){
        this.imageView.setImage(thumbnail);
    }
}
