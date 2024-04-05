package protune;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


//        ObservableList<String> l = FXCollections.observableArrayList();
//
//        l.addAll("ok2", "ok1", "ok3");
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("oke", "ok1", "oke2", "oke3");

        listView.setFixedCellSize(20);
        DoubleProperty hei = new SimpleDoubleProperty(listView.getFixedCellSize() * listView.getItems().size());


        listView.setCursor(Cursor.HAND);
        listView.setOnMouseClicked(e -> {
            String tmp = listView.getSelectionModel().getSelectedItem();
            System.out.println(tmp);
            listView.getItems().add("new");
//            listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
            hei.add(listView.getFixedCellSize());
            System.out.println(hei);
        });


//        DoubleProperty hei = new SimpleDoubleProperty(100);

        listView.prefHeightProperty().bind(hei);



        AnchorPane anchorPane = new AnchorPane();
//        anchorPane.prefHeightProperty().bind(listView.widthProperty());
        anchorPane.getChildren().add(listView);

        Scene scene = new Scene(anchorPane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
