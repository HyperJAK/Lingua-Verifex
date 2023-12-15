package net.app.theoryofcompproj.fxml_controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import net.app.theoryofcompproj.Fonts;
import net.app.theoryofcompproj.SceneSwitch;
import net.app.theoryofcompproj.Styling;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConvertPageController implements Initializable {

    Styling style = new Styling();
    Fonts fonts = new Fonts();

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button convert_btn;

    @FXML
    private TextArea cppInput;
    @FXML
    private TextArea JavaInput;


    @FXML
    void switchScene() throws IOException {
        new SceneSwitch(borderPane, "fxml/MainPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        convert_btn.setFont(fonts.getLemonMilk22());

        // For testing purposes
        convert_btn.setOnAction(e -> {
            if(cppInput.getText().equals("string a = \"test\";")){
                JavaInput.setText("String a = \"test\";");
            }else if(cppInput.getText().equals("int b = 69;")){
                JavaInput.setText("int b = 69;");
            }else if(cppInput.getText().equals("object(int) c = 12;")){
                JavaInput.setText("Integer c = 12;");
            }else if(cppInput.getText().equals("object(double) c = 22.2;")){
                JavaInput.setText("Double c = 22.2;");
            }else{
                JavaInput.setText("Error Occurred ! Please ensure Language is correctly written");
            }
        });
        addHoverListener(convert_btn, "BTN", "BTN2");
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
