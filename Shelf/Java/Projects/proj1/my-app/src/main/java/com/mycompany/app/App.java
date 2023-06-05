package com.mycompany.app;

import JFX_HOME.application.Application;
import JFX_HOME.scene.Scene;
import JFX_HOME.scene.control.Button;
import JFX_HOME.scene.layout.VBox;
import JFX_HOME.stage.Stage;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    MyApp.main(null);
  }
}



class MyApp extends Application {

  @Override
  public void start(Stage primaryStage) {
    Button button = new Button("Click Me!");

    VBox layout = new VBox(10);
    layout.getChildren().add(button);

    Scene scene = new Scene(layout, 300, 250);

    primaryStage.setTitle("My App");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}


