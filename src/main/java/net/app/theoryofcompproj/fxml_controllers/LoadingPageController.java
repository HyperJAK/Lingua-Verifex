package net.app.theoryofcompproj.fxml_controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import net.app.theoryofcompproj.Fonts;
import net.app.theoryofcompproj.interfaces.AutomatsInterface;
import net.app.theoryofcompproj.interfaces.LoadingInterface;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingPageController implements Initializable {
    Fonts fonts = new Fonts();

    @FXML
    private Pane loading_pane;
    @FXML
    private Text MainTitle;
    @FXML
    private Label MainTitle2;
    @FXML
    private Label loadingLabel;

    BackgroundFill backgroundFill =
            new BackgroundFill(
                    Color.valueOf("#F1F1F1"),
                    new CornerRadii(0),
                    new Insets(0)
            );
    Background background = new Background(backgroundFill);

    // Animation for loading label
    private int pointCount = 0;
    private void togglePoints(Label MainTitle) {
        if (pointCount == 0) {
            MainTitle.setText("loading app.");
            pointCount = 1;
        } else if (pointCount == 1) {
            MainTitle.setText("loading app..");
            pointCount = 2;
        } else if (pointCount == 2) {
            MainTitle.setText("loading app...");
            pointCount = 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Apply the custom font to the Text elements
        MainTitle.setFont(fonts.getLemonMilk48());
        MainTitle2.setFont(fonts.getLemonMilk36());

        // Create a new timeline for loading
        Timeline loadingTimeLine = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> togglePoints(loadingLabel))
        );
        loadingTimeLine.setCycleCount(Timeline.INDEFINITE);
        loadingTimeLine.play();

        // Set the background to the loading pane
        loading_pane.setBackground(background);
    }


}


