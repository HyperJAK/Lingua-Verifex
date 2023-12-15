package net.app.theoryofcompproj.fxml_controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import net.app.theoryofcompproj.SceneSwitch;
import net.app.theoryofcompproj.Styling;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TokenizePageController implements Initializable {

    Styling style = new Styling();

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button tokenize_btn;
    @FXML
    private TextField tokens_text;
    @FXML
    private TextField string_text;

    @FXML
    void switchScene() throws IOException {
        new SceneSwitch(borderPane, "fxml/MainPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tokenize_btn.setOnAction(e->{
            tokens_text.setText("KEYWORD ID SYMBOL ID SEMI");
        });
        addHoverListener(tokenize_btn, "BTN", "BTN2");
    }

    private void addHoverListener(Button button, String id1, String id2) {
        button.setTextFill(Color.WHITE);
        button.setId(id1); // SET CSS ID
        style.ChangeButtonColor(button, id1, id2);

        // Add hover event listener
        button.setOnMouseEntered(event -> {
            button.setId(id2);
            style.ChangeButtonColor(button, id1, id2);
        });

        button.setOnMouseExited(event -> {
            button.setId(id1);
            style.ChangeButtonColor(button, id1, id2);
        });
    }
}
