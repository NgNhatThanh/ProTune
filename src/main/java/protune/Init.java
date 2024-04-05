package protune;

import protune.controller.inapp.LocalFileAdd;
import protune.view.in.InAppScene;
import protune.view.in.mainzone.MainZone;
import protune.view.in.mainzone.homepane.HomePane;
import protune.view.in.mainzone.homepane.audiocard.PlaylistList;
import protune.view.in.mainzone.homepane.LocalPane;
import protune.view.in.mainzone.searchpane.SearchPane;
import protune.view.in.navbar.NavBar;
import protune.view.in.playbar.PlayBar;
import protune.view.out.LogScene;

import java.io.FileNotFoundException;

public class Init {
    static public HomePane homePane = new HomePane();
    static public NavBar navBar;
    static {
        try {
            navBar = new NavBar();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static public PlayBar playBar = new PlayBar();

    static public SearchPane searchPane = new SearchPane();

    static public LocalPane localPane = new LocalPane();
    static public MainZone mainZone = new MainZone();

    static public PlaylistList playlistList = new PlaylistList();

    static public LocalFileAdd localFileAdd = new LocalFileAdd();

    static public MainStage appStage = new MainStage();
    static public LogScene logScene;
    static {
        try {
            logScene = new LogScene();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static public InAppScene inAppScene = new InAppScene();


}
