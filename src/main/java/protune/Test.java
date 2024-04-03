package protune;

import javafx.application.Application;
import javafx.stage.Stage;
import protune.view.out.WaitStage;


public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WaitStage waitStage = new WaitStage();
        waitStage.show();


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
