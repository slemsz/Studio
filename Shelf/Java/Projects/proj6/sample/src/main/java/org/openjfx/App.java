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
import java.util.Date;
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
    HBox bodyContent;
    HBox footer;
    Label footerLabel;
    TextField searchBarField;

    Button findButton;
    Button tabButton;
    Button optionButton;
    Button execButton;

    String url;
    Tab sampleTab;
    TabPane tabPane;
    VBox tabPaneBox;
    HashSet<Tab> tabs; /// implement me

    VBox sideBar;
    List<Node> sideBarComponents;
    Button showSideBar;

    Canvas canvas;
    Canvas canvas_01;
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

        root = new HBox();
        body = new VBox();
        bodyContent = new HBox();

        footer = new HBox();
        footerLabel = new Label();

        vBox = new VBox();
        testVBox = new VBox();

        searchBarField = new TextField(G_URL);

        sampleButton = new Button("Sample");
        execButton = new Button("::exec::");
        findButton = new Button("Hello:");
        tabButton = new Button("Tab");
        optionButton = new Button("Options");

        url = G_URL;

        sampleTab = new Tab();
        tabPane = new TabPane();
        tabPaneBox = new VBox();
        tabs = new HashSet<Tab>();

        webView = new WebView();
        webViews = new ArrayList<>();

        sideBar = new VBox();
        sideBarComponents = new ArrayList<>();
        showSideBar = new Button("show");

        canvas = new Canvas(350,350);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 100, 100);

        canvas_01 = new Canvas(250, 250);
        gc_01 = canvas_01.getGraphicsContext2D();
        gc_01.setFill(Color.BLUE);
        gc_01.fillRect(75, 75, 100, 100);

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
        System.out.println("App.init() called.");
        this.showSideBar.setOnAction( event -> {
            System.out.println("(Button) showSideBar pressed.");
            handleShowSideBar();
        });
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("WebView test");

        fillBody();

        this.vBox = new VBox(
                this.root,
                this.body,
                this.footer);

        Scene scene = new Scene(this.vBox, 550, 600);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    /**
     * Called from App.start(..)
     */
    public void fillBody()
    {
        this.sideBar = new VBox(new Label("label"), new Button("button"));
        this.sampleTab = new Tab("canvas", canvas);
        this.tabPane.getTabs().add(sampleTab);
        this.tabPaneBox.getChildren().addAll(showSideBar, tabPane);
        this.bodyContent.getChildren().addAll(sideBar, tabPaneBox);
        this.body.getChildren().add(bodyContent);
    }

    public void handleShowSideBar() {
        System.out.println("(Method) App.handleShowSideBar() called. ");
    }



}
