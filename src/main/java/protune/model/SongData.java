package protune.model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SongData {
    private Image thumbnail;
    {
        try {
            thumbnail = new Image(new FileInputStream("src/main/resources/img/default-thumbnail.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String name = "Hay trao cho anh thanh dep trai";
    private int duration;
    private String singer = "Son Tung MTP";
    public Image getThumbnail(){ return thumbnail; }
    public String getName(){ return name; }
    public int getDuration(){ return duration; }
    public String getSinger(){ return singer; }
}
