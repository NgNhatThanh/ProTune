package protune.view.in.mainzone.homepane.audiocard.button;

import protune.controller.inapp.PlaylistManager;
import protune.view.in.mainzone.homepane.audiocard.PLCard;
import protune.view.in.mainzone.playlistpane.PlPaneManager;

public class PLDelButton extends CardButton{

    public PLDelButton(String iconPath, PLCard plCard) {
        super(iconPath);
        this.setLayoutX(5);
        this.setLayoutY(125);
        this.setOnMouseClicked(e -> {
            PlPaneManager.delTrack(plCard, plCard.getPlaylistName());
            PlaylistManager.delTrack(plCard.getPlaylistName(), plCard.getdata());
        });
    }
}
