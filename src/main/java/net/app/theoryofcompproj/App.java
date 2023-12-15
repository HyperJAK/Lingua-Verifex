package net.app.theoryofcompproj;

import java.io.IOException;
import java.net.URL;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import net.app.theoryofcompproj.fxml_controllers.AutomatsPageController;
import net.app.theoryofcompproj.interfaces.*;

public class App extends Application {

    private final double DefaultWidth = 1336;
    private final double DefaultHeight = 740;

    @Override

    public void start(Stage loadingStage) throws IOException {

        Styling style = new Styling();
        JsonManip jsonManip = new JsonManip();
        GlobalVariables globalVariables = new GlobalVariables();

        // On Startup Initialize necessary data in data structures
        //jsonManip.init_onStartup_nbOfAutomats();
        //System.out.print(globalVariables.getNbOfAutomats());

        // Initialize Panes
        BorderPane MainPane = FXMLLoader.load(new URL(App.class.getResource("fxml/MainPage.fxml").toExternalForm()));
        Pane LoadingPane = FXMLLoader.load(new URL(App.class.getResource("fxml/LoadingPage.fxml").toExternalForm()));
        BorderPane AutomatsPane = FXMLLoader.load(new URL(App.class.getResource("fxml/AutomatsPage.fxml").toExternalForm()));
        BorderPane LanguagecheckerBorderPane = FXMLLoader.load(new URL(App.class.getResource("fxml/LanguageCheckerPage.fxml").toExternalForm()));
        BorderPane TokenizeBorderPane = FXMLLoader.load(new URL(App.class.getResource("fxml/TokenizePage.fxml").toExternalForm()));
        BorderPane ConvertBorderPane = FXMLLoader.load(new URL(App.class.getResource("fxml/ConvertPage.fxml").toExternalForm()));

        // Initialize Main Stage
        Stage mainStage = new Stage();

        // Initialize User Interfaces (Scenes)

        // Initialize Main Interface
        MainInterface mainInterface = new MainInterface(MainPane, DefaultWidth, DefaultHeight);
        mainInterface.setFill(Color.TRANSPARENT);
        mainInterface.getStylesheets().addAll(style.getDefaultCss(),style.getHoverCss());

        // Initialize Loading Interface
        LoadingInterface loadingInterface = new LoadingInterface(LoadingPane, 580, 270);
        loadingInterface.setFill(Color.TRANSPARENT);
        loadingInterface.getStylesheets().addAll(style.getDefaultCss(),style.getHoverCss());

        // Initialize Automats Interface
        AutomatsInterface automatsInterface = new AutomatsInterface(AutomatsPane, DefaultWidth, DefaultHeight);
        automatsInterface.setFill(Color.TRANSPARENT);
        automatsInterface.getStylesheets().addAll(style.getDefaultCss(),style.getHoverCss());

        // Initialize LanguageChecker Interface
        LanguageCheckerInterface languageCheckerInterface = new LanguageCheckerInterface(LanguagecheckerBorderPane, DefaultWidth, DefaultHeight);
        languageCheckerInterface.setFill(Color.TRANSPARENT);
        languageCheckerInterface.getStylesheets().addAll(style.getDefaultCss(),style.getHoverCss());

        // Initialize Tokenize Interface
        TokenizeInterface tokenizeInterface = new TokenizeInterface(TokenizeBorderPane, DefaultWidth, DefaultHeight);
        tokenizeInterface.setFill(Color.TRANSPARENT);
        tokenizeInterface.getStylesheets().addAll(style.getDefaultCss(),style.getHoverCss());

        // Initialize Tokenize Interface
        ConvertInterface convertInterface = new ConvertInterface(ConvertBorderPane, DefaultWidth, DefaultHeight);
        convertInterface.setFill(Color.TRANSPARENT);
        convertInterface.getStylesheets().addAll(style.getDefaultCss(),style.getHoverCss());

        // Add Attributes to Stages
        loadingStage.setScene(loadingInterface);
        loadingStage.setResizable(false);

        mainStage.setScene(mainInterface);
        mainStage.setResizable(true);

        // Add New Animation for loading screen (change stage after delay)
        KeyFrame keyFrame = new KeyFrame(loadingInterface.getDelay(), event -> loadingInterface.changeToNewStage(mainStage,loadingStage));
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(1);
        timeline.play();

        loadingStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}