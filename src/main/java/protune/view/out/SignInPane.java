package protune.view.out;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import protune.Init;
import protune.controller.log.SignInCheck;

public class SignInPane extends AnchorPane {

    SignUpPane paneSwitch;
    SignInCheck checker = new SignInCheck();

    public SignInPane(){
        this.setPrefSize(400, 400);
        this.setLayoutX(80);
        this.setLayoutY(230);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");


        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setLayoutY(100);

        Button signinBtn = new Button("Sign in");
        signinBtn.setLayoutX(200);
        signinBtn.setLayoutY(200);

        

        usernameField.setOnInputMethodTextChanged(event -> {
            signinBtn.setDisable(usernameField.getText().isEmpty());
            if(usernameField.getText().isEmpty()) System.out.println("trong");
        });


        Label lb = new Label("No account yet?");
        lb.setId("recom-label");
        Label lb2 = new Label("Sign up");
        lb2.setId("sign-label");
        lb2.setOnMouseClicked(e -> {
            this.setVisible(false);
            paneSwitch.setVisible(true);
        });

        Label guestLabel = new Label("Enter as guest.");
        guestLabel.setLayoutY(260);
        guestLabel.setId("sign-label");
        guestLabel.setOnMouseClicked(e -> Init.appStage.setScene(Init.inAppScene));

        lb.setLayoutY(220);
        lb2.setLayoutY(217);
        lb2.setLayoutX(110);


        signinBtn.setOnAction(e -> {
//            UserData newUser = new UserData(usernameField.getText(), passwordField.getText());
//            String message = checker.isValid(newUser);
//
//            if(message.equals("accept")){

//            }
//            try {
//                SongListManager.importLocalAudio();
//            } catch (IOException | ClassNotFoundException | InvalidAudioFrameException ex) {
//                throw new RuntimeException(ex);
//            }
        });

        this.getChildren().addAll(usernameField, passwordField, signinBtn, lb, lb2, guestLabel);
    }

    public void setPaneSwitch(SignUpPane signUpPane){
        this.paneSwitch = signUpPane;
    }
}
