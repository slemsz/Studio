package org.openjfx;

// Snippets from https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage stage) {
        stage.setTitle("File Chooser Sample");

        FileChooser fileChooser = new FileChooser();

        Button openButton = new Button("Open a Picture...");
        Button openMultipleButton = new Button("Open Pictures...");
        Button browseButton = new Button("...");

        openButton
            .setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(ActionEvent e) {
                                 configureFileChooser(fileChooser);
                                 File file = fileChooser.showOpenDialog(stage);
                                 if (file != null) {
                                     openFile(file);
                                 }
                             }
                         }
                         );
        openMultipleButton
            .setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(ActionEvent e) {
                                 configureFileChooser(fileChooser);
                                 List<File> list =
                                     fileChooser.showOpenMultipleDialog(stage);
                                 if (list != null) {
                                     for (File file : list) {
                                         openFile(file);
                                     }
                                 }
                             }
                         }
                         );
        browseButton
            .setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(ActionEvent e) {
                                 DirectoryChooser directoryChooser =
                                     new DirectoryChooser();
                                 File selectedDirectory =
                                     directoryChooser.showDialog(stage);
                                 if (selectedDirectory != null) {
                                     selectedDirectory.getAbsolutePath();
                                 }
                             }
                         }
                         );

        GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(openButton, 0, 0);
        GridPane.setConstraints(openMultipleButton, 1, 0);
        GridPane.setConstraints(browseButton, 2, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, openMultipleButton, browseButton);

        Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters()
            .addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
                    );
    }


    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger
                .getLogger(App.class.getName())
                .log(Level.SEVERE, null, ex);
        }
    }

}
