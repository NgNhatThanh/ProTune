package protune.model;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;
import protune.HelloApplication;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SongData implements Serializable {
    private transient Media media;
    private transient Image thumbnail;

    private File audioFile;
    private String title;
    private String artist = "null";
    private URL url;

    public SongData(File file){
        this.audioFile = file;
        this.setTitle(file.getName());
        try {
            this.extractMetadata();
        } catch (InvalidAudioFrameException e) {
            throw new RuntimeException(e);
        }
//        this.media = new Media(file.toURI().toString());
    }

    public SongData(String url){
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            System.out.println("URL not found");
        }
    }

    public Image getThumbnail(){ return thumbnail; }
    public String getTitle(){ return title; }
    public void setTitle(String title){
        int i = title.length() - 1;
        for(; i >= 0; --i){
            if(title.charAt(i) == '.') break;
        }
        this.title = title.substring(0, i);
    }

    public void prepareToPlay(){
        if(this.audioFile.exists()){
            System.out.println(this.audioFile.getPath());
            this.media = new Media(this.audioFile.toURI().toString());
        }
        else{
            System.out.println("url");
            this.media = new Media(url.toString());
        }
    }

    public void init() throws InvalidAudioFrameException{
        extractMetadata();
    }

    private void extractMetadata() throws InvalidAudioFrameException{
        System.out.println(HelloApplication.cnt++);
        AudioFile f;
        try{
            if(this.audioFile == null){
                InputStream inputStream = url.openStream();
                this.audioFile = File.createTempFile("temp", ".mp3");
                FileOutputStream outputStream = new FileOutputStream(this.audioFile);
                byte[] buffer = new byte[4096];
                int bytesRead;
                for(int i = 0; i < 60; ++i){
                    bytesRead = inputStream.read(buffer);
                    outputStream.write(buffer, 0, bytesRead);
                }
                f = AudioFileIO.read(this.audioFile);
                outputStream.close();
                inputStream.close();
//                while(!this.audioFile.delete());
                this.audioFile.delete();
            }
            else f = AudioFileIO.read(this.audioFile);
            Tag tag = f.getTag();
            this.title = tag.getFirst(FieldKey.TITLE);
            this.artist = tag.getFirst(FieldKey.ARTIST);
            System.out.println(f.getAudioHeader().getTrackLength());
            Artwork artwork = tag.getFirstArtwork();

            if (artwork != null) {
                byte[] imageData = artwork.getBinaryData();
                ByteArrayInputStream bai = new ByteArrayInputStream(imageData);
                this.thumbnail = new Image(bai);
            } else {
                this.thumbnail = new Image(new File(Constant.defaultSongThumbnailPath).toURI().toString());
            }
            System.out.println("oke");
        }
        catch (TagException | CannotReadException | ReadOnlyFileException | IOException e) {
            System.out.println("loi");
            throw new RuntimeException(e);
        }
    }

    public String getArtist(){ return artist; }

    public Media getMedia(){ return media; }

    public boolean equals(SongData songData){
        return this.audioFile.getPath().equals(songData.audioFile.getPath());
    }
}
