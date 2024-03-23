package protune.view.in.playbar.player.control.button;

import protune.Init;
import protune.view.in.playbar.player.control.ControlButton;

public class PreviousButton extends ControlButton {
    public PreviousButton(String iconPath) {
        super(iconPath);
        this.setOnMouseClicked(e -> Init.playBar.playPrevious());
    }
}
