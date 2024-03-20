package protune.view.out;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import protune.view.out.SignInPane;

public class SignUpPane extends AnchorPane {
    SignInPane paneSwitch;
    public SignUpPane(){
        this.setPrefSize(400, 400);
        this.setLayoutX(80);
        this.setLayoutY(230);

        TextField firstNameLabel = new TextField();
        firstNameLabel.setPromptText("First name");
        firstNameLabel.setId("name-label");

        TextField lastNameLabel = new TextField();
        lastNameLabel.setPromptText("Last name");
        lastNameLabel.setId("name-label");
        lastNameLabel.setLayoutX(155);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setLayoutY(65);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setLayoutY(130);

        Button signinBtn = new Button("Sign up");
        signinBtn.setLayoutX(200);
        signinBtn.setLayoutY(200);

        Label lb = new Label("Already had an account?");
        lb.setId("recom-label");
        Label lb2 = new Label("Sign in");
        lb2.setId("sign-label");
        lb2.setOnMouseClicked(e -> {
            this.setVisible(false);
            paneSwitch.setVisible(true);
        });

        lb.setLayoutY(210);
        lb2.setLayoutY(230);

        this.getChildren().addAll(firstNameLabel, lastNameLabel, usernameField, passwordField, lb, lb2, signinBtn);
        this.setVisible(false);
    }

    public void setPaneSwitch(SignInPane signInPane){
        this.paneSwitch = signInPane;
    }
}
