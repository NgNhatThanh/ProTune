package protune.view.in.mainzone.searchpane;

import javafx.scene.layout.VBox;

public class SearchPane extends VBox {
    public SearchPane(){
        this.getStyleClass().add("bg");

        SearchResult searchResultPane = new SearchResult();
        SearchBar searchBar = new SearchBar(searchResultPane);

        this.getChildren().addAll(searchBar, searchResultPane);
        this.getStylesheets().add(getClass().getResource("/stylesheet/inapp.css").toExternalForm());
    }
}
