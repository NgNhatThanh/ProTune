package protune;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();

        Rectangle rect1 = new Rectangle(100, 100);
        rect1.setStyle("-fx-fill: red;");

        Rectangle rect2 = new Rectangle(100, 100);
        rect2.setStyle("-fx-fill: blue;");

        stackPane.getChildren().addAll(rect1, rect2);

        Stage stage = new Stage();

        rect1.setOnMouseClicked(e -> rect2.toFront());
        rect2.setOnMouseClicked(e -> rect1.toFront());

        Scene scene = new Scene(stackPane, 100, 100);

        stage.setScene(scene);
        stage.show();
    }
}
