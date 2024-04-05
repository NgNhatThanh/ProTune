package protune.view.in.navbar.item;

import protune.Init;
import protune.controller.PlaylistManager;
import protune.controller.auth.Authorization;
import protune.controller.inapp.SongListManager;
import protune.view.in.mainzone.playlistpane.PlPaneManager;

import java.io.FileNotFoundException;

public class ExitItem extends NavItem{
    public ExitItem(String iconPath, String content) throws FileNotFoundException {
        super(iconPath, content);
        this.setOnMouseClicked(e -> {
            Init.appStage.comeOut();
            Init.inAppScene.reset();
            if(Authorization.isAccount()) PlaylistManager.exportPlaylists();
            SongListManager.exportLocalList();
            PlPaneManager.delAll();
        });
    }
}
