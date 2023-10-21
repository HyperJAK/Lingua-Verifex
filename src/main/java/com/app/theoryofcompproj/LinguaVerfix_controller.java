package com.app.theoryofcompproj;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;

public class LinguaVerfix_controller implements Initializable {

    @FXML
    private Label testLabel;

    @FXML
    private Pane mainPane;

    @FXML
    private Button testButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //this function automatically runs at the start of the program, use it to initialize any needed variables
        testLabel.setPrefWidth(50);
        testLabel.setTextAlignment(TextAlignment.CENTER);
        testLabel.setAlignment(Pos.CENTER);
        testLabel.setWrapText(true);
    }

    @FXML
    void TestButton_MouseReleased(MouseEvent event) {
        testLabel.setText("Button was clicked");

    }


}


