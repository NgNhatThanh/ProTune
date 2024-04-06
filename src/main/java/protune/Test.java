package protune;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;


public class Test extends Application {
    public static void main(String[] args) {
        launch();
    }

    Random rnd = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {


        TextInputDialog textInputDialog = new TextInputDialog();

        Button okBtn = (Button)textInputDialog.getDialogPane().lookupButton(ButtonType.OK);
        TextField inputField = textInputDialog.getEditor();
//        BooleanBinding isValid = ;
        okBtn.disableProperty().bind(inputField.textProperty().isEmpty());

        Optional<String> res = textInputDialog.showAndWait();

        if(res.isPresent()) System.out.println(res.get());
        else System.out.println("ko cao");
//        AnchorPane anchorPane = new AnchorPane();
//
//        Scene scene = new Scene(anchorPane, 500, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
}
