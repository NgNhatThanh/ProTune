package protune.view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import protune.model.Constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LogScene extends Scene {

    private AnchorPane pane;

    public LogScene() throws FileNotFoundException {
        super(new AnchorPane(), Constant.appWidth, Constant.appHeight);
        pane = new AnchorPane();
        setRoot(pane);

        Image img = new Image(new FileInputStream("src/main/resources/bg.png"));
        ImageView im = new ImageView(img);

        SignInPane signInPane = new SignInPane();
        SignUpPane signUpPane = new SignUpPane();

        signInPane.setPaneSwitch(signUpPane);
        signUpPane.setPaneSwitch(signInPane);

        this.getStylesheets().add(getClass().getResource("/logScene.css").toExternalForm());
        pane.getChildren().addAll(im, signInPane, signUpPane, new CreditFooter());
        pane.requestFocus();
    }

}
