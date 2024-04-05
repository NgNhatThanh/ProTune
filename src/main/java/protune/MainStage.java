package protune;

import javafx.stage.Stage;

public class MainStage extends Stage {
    public void comeIn(){
        Init.inAppScene.modify();
        this.setScene(Init.inAppScene);
    }

    public void comeOut(){
        this.setScene(Init.logScene);
    }
}
