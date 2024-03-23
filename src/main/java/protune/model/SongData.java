package protune.model;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import protune.controller.SongListManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class SongData implements Serializable {
    private transient Media media;
    private transient Image thumbnail;
    {
        try {
            thumbnail = new Image(new FileInputStream("src/main/resources/img/default-thumbnail.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private File audioPath;
    private String thumbnailPath = "src/main/resources/img/default-thumbnail.png";
    private String name;
    private String singer = "null";

    public SongData(File file){
        this.audioPath = file;
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

    public void init() throws FileNotFoundException {
        this.thumbnail = new Image(new FileInputStream(thumbnailPath));
        this.media = new Media(this.audioPath.toURI().toString());
    }
    public String getSinger(){ return singer; }

    public Media getMedia(){ return media; }
}
