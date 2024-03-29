package protune.view.in.searchpane;

import javafx.scene.layout.VBox;

public class SearchPane extends VBox {
    public SearchPane(){
        this.setVisible(false);
        this.setPrefSize(740, 480);
        this.setLayoutX(250);
        this.setLayoutY(10);
        this.getStyleClass().add("bg");

        SearchResult searchResultPane = new SearchResult();
        SearchBar searchBar = new SearchBar(searchResultPane);

        this.getChildren().addAll(searchBar, searchResultPane);
        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
    }
}
