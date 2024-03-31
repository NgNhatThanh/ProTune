package protune.view.in.mainzone.homepane.audiocard.button;

import protune.view.in.mainzone.homepane.audiocard.AudioCard;

public class EditButton extends CardButton{
    public EditButton(String iconPath, AudioCard audioCard) {
        super(iconPath);
        this.setLayoutX(125);
        this.setLayoutY(5);
        this.setOnMouseClicked(e -> {

        });
    }
}
