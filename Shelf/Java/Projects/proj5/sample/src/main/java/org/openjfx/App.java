package org.openjfx;

// Snippets from https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class App extends Application {

    WebView webView;
    VBox vBox;
    HBox root;
    GridPane gridPane;


    public App() {
        root = new HBox();
        gridPane = new GridPane();
        vBox = new VBox();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("WebView test");
        this.webView = new WebView();
        this.webView.getEngine().load("http://google.com");

        root.getChildren().add(new TextField("Salad"));

        this.vBox = new VBox(this.root, this.webView);

        Scene scene = new Scene(this.vBox, 960, 600);

        stage.setScene(scene);
        stage.show();
    }

}
