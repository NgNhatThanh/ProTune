package protune;

import protune.controller.LocalFileAdd;
import protune.view.in.main.HomePane;
import protune.view.in.navbar.NavBar;
import protune.view.in.playbar.PlayBar;

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

    static public LocalFileAdd localFileAdd = new LocalFileAdd();

}
