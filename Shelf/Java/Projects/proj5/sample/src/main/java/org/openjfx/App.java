package org.openjfx;

// Snippets from https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File ;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application
{

    public static final String G_URL = "http://google.com";
    public static final String Y_URL = "http://yahoo.com";

    WebView webView;
    VBox vBox;
    HBox root;
    HBox footer;
    Label footerLabel;
    TextField searchBarField;
    Button findButton;
    Button tabButton;
    String url;
    TabPane tabPane;

    public App()
    {
        root = new HBox();
        footer = new HBox();
        footerLabel = new Label();
        vBox = new VBox();
        searchBarField = new TextField(":url");
        findButton = new Button("Hello:");
        tabButton = new Button("Tab");
        url = G_URL;
        tabPane = new TabPane();
        webView = new WebView();
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("WebView test");

        footer.getChildren().add(this.footerLabel);

        root.getChildren().add(new HBox(this.searchBarField, this.findButton, this.tabButton));

        this.vBox = new VBox(this.root, this.tabPane, this.footer);

        handleTabButton();

        Scene scene = new Scene(this.vBox, 960, 600);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init()
    {
        this.findButton.setOnAction( event -> {
                System.out.println("(Button)findButton pressed.");
                handleFindButton();
            } );

        this.tabButton.setOnAction( event -> {
                System.out.println("(Button)tabButton pressed.");
                handleTabButton();
            } );
    }

    public void handleFindButton()
    {
        this.url = this.searchBarField.getText().toString();
        this.footer.getChildren().add(new Label(this.url));
        this.webView.getEngine().load(url);
        this.webView.getEngine().getLocation();
        this.searchBarField.setText(":url");
    }

    public void handleTabButton()
    {
        this.tabPane.getTabs().add(new Tab("Home", new Label("Browser Home")));
        Platform.runLater(()->this.vBox.getChildren().add(tabPane));
    }

}
