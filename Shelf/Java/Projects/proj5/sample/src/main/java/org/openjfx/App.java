package org.openjfx;

// Snippets from https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;
/**
 * JavaFX App
 */
public class App extends Application
{

    public static final String G_URL = "http://google.com";
    public static final String Y_URL = "http://yahoo.com";
    Image burger_img;
    Button sampleButton;

    WebView webView;
    List<WebView> webViews;
    VBox vBox;
    VBox testVBox;
    HBox root;
    VBox body;
    HBox footer;
    Label footerLabel;
    TextField searchBarField;
    Button findButton;
    Button tabButton;
    String url;
    TabPane tabPane;
    HBox tabPaneBox;
    HashSet<Tab> tabs; /// implement me
    Button optionButton;
    Button execButton;
    Canvas canvas;
    Canvas canvas_01;
    VBox sideBar;
    List<Node> sideBarComponents;
    GraphicsContext gc;
    GraphicsContext gc_01;

    /**
     * (i)    Initialize {@code root} with a {@code HBox} object.
     * (ii)   Initialize {@code footer} with a {@code HBox} object.
     * (iii)  Initialize {@code footerLabel} with a {@code Label} object.
     * (iv)   Initialize {@code vBox} with a {@code VBox} object.
     * (v)    Initialize {@code searchBarField} with a {@code TextField} object.
     *         Sets the default text to :url.
     * (vi)   Initialize
     * (vii)  Initialize
     * (viii) Set
     * (ix)   Initialize
     * (x)    Initialize
     */
    public App()
    {
        burger_img = new Image("file:resources/icons/burger.png");
        sampleButton = new Button();

        root = new HBox();
        body = new VBox();

        footer = new HBox();
        footerLabel = new Label();

        vBox = new VBox();
        testVBox = new VBox();

        searchBarField = new TextField(G_URL);

        execButton = new Button("::exec::");
        findButton = new Button("Hello:");
        tabButton = new Button("Tab");
        optionButton = new Button("Options");

        url = G_URL;

        tabPane = new TabPane();
        tabPaneBox = new HBox(tabPane);
        tabs = new HashSet<Tab>();

        webView = new WebView();
        webViews = new ArrayList<>();

        sideBar = new VBox();
        sideBarComponents = new ArrayList<>();

        canvas = new Canvas(250,250);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 100, 100);

        canvas_01 = new Canvas(250, 250);
        gc_01 = canvas_01.getGraphicsContext2D();
        gc_01.setFill(Color.BLUE);
        gc_01.fillRect(75, 75, 100, 100);

    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("WebView test");
        this.footer.getChildren().add( new HBox(
                            this.optionButton,
                            this.footerLabel));

        this.root.getChildren().add( new HBox(
                            this.execButton,
                            this.searchBarField,
                            this.findButton,
                            this.tabButton));

        this.body.getChildren().add( this.tabPaneBox );

        this.vBox = new VBox(
                this.root,
                this.body,
                this.footer);



        Scene scene = new Scene(this.vBox, 960, 600);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    /**
     * Overrides javafx.application.Application.init method.
     * Contains event handlers for components within the scene graph.
     * (1) Set action for Button findButton.
     *  (1.a) Verify button press.
     *  (1.b) Method call to handleFindButton();
     * (2) Set action for Button tabButton.
     *  (2.a) Print confirmation of activation.
     *  (2.b) Method call to handleTabButton();
     */
    @Override
    public void init()
    {

        this.findButton.setOnAction( event -> {
            System.out.println("(Button) findButton pressed.");
            handleFindButton();
        } );

        this.tabButton.setOnAction( event -> {
            System.out.println("(Button) tabButton pressed.");
            handleTabButton();
        } );

        this.execButton.setOnAction( event -> {
            System.out.println("(Button) executeButton pressed.");
            handleExecButton();
        } );

        this.optionButton.setOnAction( event -> {
            System.out.println("(Button) optionsButton pressed.");
            test();
        });
    }

    /**
     * Takes nothing and returns nothing.
     * Updates variables within scope.
     * Alters Scene graph.
     * In order:
     *  (1) {@code url} takes the value of the text contained within (TextField)searchBarField.
     *  (2) Display current URL location at the bottom of the gui viewer.
     *  (3) Load URL.
     *  (4) Set displayed url text.
     *  (5) Load to scene graph.
     * Specifically:
     *      handles the actionEvent of the findButton Button.
     */
    public void handleFindButton()
    {
        this.url = this.searchBarField.getText().toString();
        this.footer.getChildren().add(new Label(this.url));
        this.webView.getEngine().load(this.url);
        //this.webView.getEngine().getLocation();
        this.searchBarField.setText(":url");
        Platform.runLater(() -> {
            this.tabPane.getTabs().add(new Tab("WebView", new VBox(this.webView)));
        });
    }

    /**
     * Takes nothing and returns nothing.
     * Updates variables within scope.
     * (1) Adds a tab to the tabPane object.
     * (2) Edit List of WebView Objects.
     *  (2.a) Add new webView Object to List
     * (3) Add a new Tab to the TabPane.
     * (4) Load the tabPane to the scene graph.
     */
    public void handleTabButton()
    {
        this.webView.getEngine().load(G_URL);
        this.tabs.add(new Tab("Home", this.body));
        loadTabs();
    }

    /**
     * Test button for the purpose of running dev experiments.
     * (1) Verify method call.
     * (2) Call test method.
     */
    public void handleExecButton()
    {
        System.out.println("(Method) App.handleExecButton() called.");
        //test();
        //loadTabs();
        test_origin_scene();
    }

    /**
     * Test Method:
     * (1) Verify method call.
     * (2) Edit List of sideBarComponents set to display in the new tab.
     * (3) Empty current sidebar items
     * (4) For every item in sideBarComponents, add them to the sidebar
     * (5) Add the sidebar and canvas to our test vbox object
     * (6) Add the testVBox to the tabPane.
     * (7)
     *
     * ...
     * (n) Load to the scene graph.
     */
    public void test()
    {
        System.out.println("(Method) App.test() called.");
        this.sideBarComponents.add(new HBox(new Label("Hello there"), this.execButton));

        this.sideBar.getChildren().clear();
        this.sideBarComponents.forEach( item -> this.sideBar.getChildren().add(item));
        this.testVBox.getChildren().add(new HBox(this.sideBar, this.canvas));
        this.tabPane.getTabs().add(new Tab("Test", this.testVBox));

        Platform.runLater(() ->
        {
            this.body.getChildren().clear();
            this.tabPaneBox.getChildren().add(tabPane);
            this.body.getChildren().add(this.tabPaneBox);
            System.out.println("New Task");
        });
    }

    public void test_origin_scene()
    {
        System.out.println("(Method) App.test_origin_scene() called.");

        this.sampleButton.setPrefHeight(65);
        this.sampleButton.setPrefWidth(65);
        this.sampleButton.setAlignment(Pos.TOP_CENTER);

        Platform.runLater(() ->
        {
            change_canvas_color(gc_01);
            this.tabPane.getTabs().add(new Tab("uhh", new HBox(this.canvas, this.canvas_01)));
        });
    }

    public void change_canvas_color(GraphicsContext scope) {
        scope.setFill(Color.RED);
    }

    public Optional<Image> loadImage(String imageName) {
        Image img;
        try
        {
            img = new Image("file:/resources/icons/burger.png");
            System.out.println("Image Found");
            return Optional.<Image>ofNullable(img);
        }
        catch (Exception e) {
            e.printStackTrace();
            return Optional.<Image>empty();
        }
    }

    public void runThread(Runnable task) {
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * This method updates the scene graph to the current state of the
     * values in the HashSet {@code tabs}.
     */
    public void loadTabs() {
        System.out.println("Tabs loaded.");
    }

}
