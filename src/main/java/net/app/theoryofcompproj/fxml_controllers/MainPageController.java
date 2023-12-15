package net.app.theoryofcompproj.fxml_controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import net.app.theoryofcompproj.Fonts;
import net.app.theoryofcompproj.SceneSwitch;
import net.app.theoryofcompproj.Styling;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    Styling style = new Styling();
    Fonts fonts = new Fonts();

    @FXML
    private Text MainTitle;
    @FXML
    private Text MainTitle2;
    @FXML
    private Button button_automats;
    @FXML
    private Button button_tokenize;
    @FXML
    private Button button_convert;
    @FXML
    private BorderPane main_pane;

    BackgroundFill backgroundFill =
            new BackgroundFill(
                    Color.valueOf("#F1F1F1"),
                    new CornerRadii(0),
                    new Insets(0)
            );

    Background background = new Background(backgroundFill);

    @FXML
    void SwitchSceneAutomats() throws IOException {
        new SceneSwitch(main_pane, "fxml/AutomatsPage.fxml");
    }

    @FXML
    void SwitchSceneTokenize() throws IOException {
        new SceneSwitch(main_pane, "fxml/TokenizePage.fxml");
    }

    @FXML
    void SwitchSceneConvert() throws IOException {
        new SceneSwitch(main_pane, "fxml/ConvertPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Apply the custom font to the Text elements
        button_automats.setFont(fonts.getLemonMilk22());
        button_tokenize.setFont(fonts.getLemonMilk22());
        button_convert.setFont(fonts.getLemonMilk22());

        MainTitle.setFont(fonts.getLemonMilk48());
        MainTitle2.setFont(fonts.getLemonMilk36());

        MainTitle.getStyleClass().add("text");
        MainTitle2.getStyleClass().add("text");

        main_pane.setBackground(background);

        // Change Style on Hover for buttons
        button_automats.setTextFill(Color.WHITE);
        button_automats.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(button_automats,"BTN","BTN2");

        button_tokenize.setTextFill(Color.WHITE);
        button_tokenize.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(button_tokenize,"BTN","BTN2");

        button_convert.setTextFill(Color.WHITE);
        button_convert.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(button_convert,"BTN","BTN2");


    }
}
