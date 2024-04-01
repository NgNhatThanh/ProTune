package protune;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


//        AudioFile f = AudioFileIO.read(new File("C:\\Users\\NgThanh\\Downloads\\Music\\a1.mp3"));
//        Tag tag = f.getTag();
//
//        Artwork artwork = ArtworkFactory.createArtworkFromFile(new File("C:\\Users\\NgThanh\\Downloads\\anh.jpg"));
//        tag.deleteArtworkField();
//        tag.setField(artwork);
//        tag.setField(FieldKey.TITLE, "dep trai");
//        f.commit();


        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        for(Integer integer : l){
            integer = 5;
        }

        for(Integer i : l ) System.out.println(i);

//        ImageView imageView = new ImageView(new Image(new File("C:\\Users\\NgThanh\\Downloads\\anh.jpg").toURI().toString()));
//
//        imageView.setFitHeight(100);
//        imageView.setFitWidth(100);
//        imageView.setPreserveRatio(true);
//
//        Label lb = new Label();
//        lb.setGraphic(imageView);
//        lb.setPrefSize(40, 40);
//        AnchorPane anchorPane = new AnchorPane();
//        anchorPane.setPrefSize(100, 100);
//        anchorPane.getChildren().add(imageView);
//
//        Scene scene = new Scene(anchorPane, 100, 100);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
}
