package protune.model;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import protune.controller.SongListManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SongData {
    Media media;
    private Image thumbnail;
    {
        try {
            thumbnail = new Image(new FileInputStream("src/main/resources/img/default-thumbnail.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String name;
    private String singer = "null";

    public SongData(File file){
        this.setName(file.getName());
        this.media = new Media(file.toURI().toString());
    }
    public Image getThumbnail(){ return thumbnail; }
    public String getName(){ return name; }
    public void setName(String name){
        int i = name.length() - 1;
        for(; i >= 0; --i){
            if(name.charAt(i) == '.') break;
        }
        this.name = name.substring(0, i);
    }
    public String getSinger(){ return singer; }

    public Media getMedia(){ return media; }
}
