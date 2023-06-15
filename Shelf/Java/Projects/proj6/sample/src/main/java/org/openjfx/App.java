package org.openjfx;

// Snippets from https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
    Image www_img;
    Image tab_img;
    Image book_img;
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
    Tab sampleTab_01;
    Tab sampleTab_02;
    TabPane tabPane;
    VBox tabPaneBox;
    HashSet<Tab> tabs; /// implement me
    GridPane gp;

    GridPane gridPane;
    VBox sideBar;
    Boolean isSideBarShowing;
    Label sideBarLabel;
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
        burger_img = new Image("https://img.icons8.com/color/48/menu--v1.png", 20, 20, false, false);
        www_img = new Image("https://img.icons8.com/ios/50/domain--v1.png");
        tab_img = new Image("https://img.icons8.com/color/48/add-tab.png",25, 25, false, false);
        book_img = new Image("https://img.icons8.com/fluency/48/comic-book.png", 25, 25, false, false);
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
        tabButton = new Button();
        optionButton = new Button("Options");

        url = G_URL;

        sampleTab = new Tab();
        sampleTab_01 = new Tab("Tab");
        sampleTab_02 = new Tab("Tab");
        tabPane = new TabPane();
        tabPaneBox = new VBox();
        tabs = new HashSet<Tab>();
        gp = new GridPane();

        webView = new WebView();
        webViews = new ArrayList<>();

        gridPane = new GridPane();
        sideBar = new VBox(8);
        isSideBarShowing = false;
        sideBarLabel = new Label("( Sidebar )");
        sideBarComponents = new ArrayList<>();
        showSideBar = new Button();

        canvas = new Canvas(350,350);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 100, 100);

        canvas_01 = new Canvas(350, 350);
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

        fillBody();

        this.tabButton.setOnAction( event -> {
            System.out.println("(Button) tabButton pressed.");
            handleTabButton();
        });

        this.findButton.setOnAction( event -> {
            System.out.println("(Button) findButton pressed.");
            handleFindButton();
        });

        this.sampleButton.setOnAction( event -> {
            System.out.println("(Button) sampleButton pressed.");
            handleSampleButton();
        });

        this.execButton.setOnAction( event -> {
            System.out.println("(Button) execButton pressed.");
            handleExecButton();
        });
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("WebView test");

        this.vBox = new VBox(
                this.root,
                this.body
                /*this.footer*/);

        Scene scene = new Scene(vBox, 550, 600);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void generateAppBooklet() {
        System.out.println("(Method) App.generateAppBooklet() called.");
        VBox bookletContent = new VBox();
        String bookletContentCss = "-fx-border-color:black;\n" +
                                   "-fx-alignment: center;\n" +
                                   "-fx-hgrow: true;\n";

        bookletContent.setStyle(bookletContentCss);
        bookletContent.getChildren().add(new ImageView(burger_img));
        this.tabPane.getTabs().add(new Tab("tab",bookletContent));
    }

    public void handleExecButton() {
        System.out.println("(Method) App.handleExecButton() called.");
        generateAppBooklet();
    }

    public void handleSampleButton() {
        System.out.println("(Method) App.handleSampleButton() called.");
        Platform.runLater(() -> {
            this.webView.getEngine().load(G_URL);
            this.tabPane.getTabs().add(new Tab("web", this.webView));
        });
    }

    public void handleFindButton() {
        System.out.println("(Method) App.handleFindButton() called.");
        String searchText = this.searchBarField.getText();
        Platform.runLater(() -> {
            this.gp.add(new ImageView(new Image(searchText)), 0, 3);

        });
    }

    public void handleTabButton()
    {
        System.out.println("(Method) App.handleTabButton() called.");
        this.tabPane.getTabs().add(newTabInit());
    }

    public Tab newTabInit()
    {
        System.out.println("(Method) App.newTabInit() called.");
        VBox tabContent = new VBox();
        this.gp.getChildren().clear();
        this.gp.add(canvas_01, 0, 0);
        this.gp.add(findButton, 0, 2);
        this.gp.add(searchBarField, 0, 1);
        tabContent.getChildren().add(gp);
        Tab tab = new Tab("Home", tabContent);
        return tab;
    }

    /**
     * Called from App.init(..)
     */
    public void fillBody()
    {
        this.body.setFillWidth(true);
        sideBarInit();
        tabPaneBoxInit();
        this.bodyContent.getChildren().addAll(tabPaneBox);
        this.body.getChildren().add(bodyContent);
    }

    public void handleShowSideBar()
    {
        System.out.println("(Method) App.handleShowSideBar() called. ");
        if ( isSideBarShowing ) {
            this.isSideBarShowing = false;
            this.tabPaneBox.setPrefWidth(this.tabPaneBox.getWidth() + 100);
            this.bodyContent.getChildren().clear();
            this.bodyContent.getChildren().add(tabPaneBox);
        } else {
            this.isSideBarShowing = true;
            this.tabPaneBox.setPrefWidth(this.tabPaneBox.getWidth() - 100);
            this.bodyContent.getChildren().clear();
            this.bodyContent.getChildren().addAll(sideBar, tabPaneBox);

        }
    }

    public void sideBarInit()
    {
        this.gridPane.setAlignment(Pos.BASELINE_CENTER);

        String styleGridCss = "-fx-background-color: honeydew;\n" +
                              "-fx-vgap: 10;\n"+
                              "-fx-hgap: 10;\n" +
                              "-fx-padding: 10 20 10 20;\n";

        this.gridPane.setStyle(styleGridCss);
        this.gridPane.setMinHeight(570);

        String tabButtonCss = "-fx-alignment: baseline-center;\n";
        this.tabButton.setStyle(tabButtonCss);
        this.tabButton.setGraphic(new ImageView(tab_img));
        this.gridPane.add(tabButton, 0, 0);

        this.sampleButton.setGraphic(new ImageView(www_img));
        this.sampleButton.setText(null);
        this.sampleButton.setAlignment(Pos.CENTER);
        this.gridPane.add(new HBox(sampleButton), 0, 1);

        this.execButton.setText(null);
        this.execButton.setGraphic(new ImageView(book_img));
        this.gridPane.add(execButton, 0, 2);
        this.gridPane.setAlignment(Pos.BASELINE_CENTER);
        VBox vBox_01 = new VBox(sideBarLabel);

        String sideBarCss = "-fx-border-color: black ;\n" +
                            "-fx-border-width: 2;\n";

        this.sideBar.setStyle(sideBarCss);

        vBox_01.setAlignment(Pos.BOTTOM_CENTER);
        this.sideBar.getChildren().addAll(gridPane, vBox_01);
        this.sideBar.setFillWidth(true);
    }

    public void tabPaneBoxInit()
    {
        this.sampleTab = new Tab("canvas", canvas);
        this.tabPane.setCenterShape(true);
        this.tabPane.getTabs().add(sampleTab);
        this.tabPaneBox.setPrefWidth(550);
        this.tabPaneBox.setFillWidth(true);
        this.showSideBar.setGraphic(new ImageView(burger_img));
        this.tabPaneBox.getChildren().addAll(showSideBar, tabPane);
    }




}
