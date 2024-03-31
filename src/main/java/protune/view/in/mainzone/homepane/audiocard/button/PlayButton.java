package protune.view.in.mainzone.homepane.audiocard.button;

import protune.Init;
import protune.view.in.mainzone.homepane.audiocard.AudioCard;

import java.io.FileNotFoundException;

public class PlayButton extends CardButton{
    private boolean isPlaying = false;
    public PlayButton(String iconPath, AudioCard audioCard) {
        super(iconPath);
        this.setLayoutX(125);
        this.setLayoutY(125);
        this.setOnMouseClicked(e -> {
            try {
                Init.playBar.setSongPlay(audioCard.getdata());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            changeState();
        });
    }

    private void changeState(){
        if(isPlaying){
            isPlaying = false;
            Init.playBar.pause();
        }
        else{
            isPlaying = true;
            Init.playBar.play();
        }
    }
}
