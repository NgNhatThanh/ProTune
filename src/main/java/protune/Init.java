package protune;

import javafx.stage.Stage;
import protune.controller.inapp.LocalFileAdd;
import protune.view.in.InAppScene;
import protune.view.in.homepane.HomePane;
import protune.view.in.navbar.NavBar;
import protune.view.in.playbar.PlayBar;
import protune.view.in.searchpane.SearchPane;
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

    static public LocalFileAdd localFileAdd = new LocalFileAdd();

    static public Stage appStage = new Stage();

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
