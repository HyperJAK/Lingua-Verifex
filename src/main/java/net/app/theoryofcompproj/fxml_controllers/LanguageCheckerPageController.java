package net.app.theoryofcompproj.fxml_controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import net.app.theoryofcompproj.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LanguageCheckerPageController implements Initializable {

    Automat automat = new Automat();
    Styling style = new Styling();
    Fonts fonts = new Fonts();
    JsonManip jsonManip = new JsonManip();

    Map<String, Boolean> automats_text_map = new HashMap<>();

    @FXML
    private BorderPane borderPane;
    @FXML
    private Text int_text;
    @FXML
    private Text double_text;
    @FXML
    private Text float_text;
    @FXML
    private Text char_text;
    @FXML
    private Text string_text;

    @FXML
    private Text variable_text;

    @FXML
    private Text if_text;
    @FXML
    private Text do_while_text;
    @FXML
    private Text while_text;
    @FXML
    private Text for_text;

    @FXML
    private Text main_text;
    @FXML
    private Text array_text;

    @FXML
    private TextField string_input;
    @FXML
    private TextField check_input;

    @FXML
    private Button checkBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int_text.setFont(fonts.getLemonMilk18());
        double_text.setFont(fonts.getLemonMilk18());
        float_text.setFont(fonts.getLemonMilk18());
        char_text.setFont(fonts.getLemonMilk18());
        string_text.setFont(fonts.getLemonMilk18());
        variable_text.setFont(fonts.getLemonMilk18());
        if_text.setFont(fonts.getLemonMilk18());
        do_while_text.setFont(fonts.getLemonMilk18());
        while_text.setFont(fonts.getLemonMilk18());
        for_text.setFont(fonts.getLemonMilk18());
        main_text.setFont(fonts.getLemonMilk18());
        array_text.setFont(fonts.getLemonMilk18());

        //main_stack_pane.getChildren().add(a.InitialStateStackPane("q0"));
        check_input.setEditable(false);

        checkBtn.setOnMouseClicked(e -> {
            sendTriggerValue();
            sendStringValue();
            setTextFieldValue();
        });

        addHoverListener(checkBtn, "BTN", "BTN2");

        InitializeTextColor();
    }

    @FXML
    void switchScene() throws IOException {
        new SceneSwitch(borderPane, "fxml/AutomatsPage.fxml");
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

    private void InitializeTextColor(){
        automats_text_map = jsonManip.readFromSelectedAutomatsJson();

        for(Map.Entry<String, Boolean> entry: automats_text_map.entrySet()){
            if(entry.getValue()){
                if(entry.getKey().equals("int")){
                    int_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("double")){
                    double_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("float")){
                    float_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("char")){
                    char_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("string")){
                    string_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("variable")){
                    variable_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("if")){
                    if_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("do_while")){
                    do_while_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("while")){
                    while_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("for")){
                    for_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("main")){
                    main_text.setFill(Color.GREEN);
                }
                if(entry.getKey().equals("array")){
                    array_text.setFill(Color.GREEN);
                }
            }else{
                if(entry.getKey().equals("int")){
                    int_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("double")){
                    double_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("float")){
                    float_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("char")){
                    char_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("string")){
                    string_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("variable")){
                    variable_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("if")){
                    if_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("do_while")){
                    do_while_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("while")){
                    while_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("for")){
                    for_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("main")){
                    main_text.setFill(Color.RED);
                }
                if(entry.getKey().equals("array")){
                    array_text.setFill(Color.RED);
                }
            }
        }
    }

    // For testing purposes
    private void setTextFieldValue(){
        if(string_input.getText().equals("int a = 2; double b = 6.9;")){
            check_input.setText("Language is Available!");
        }
        else if(string_input.getText().equals("int a = 2;")){
            check_input.setText("Language is Available!");
        }
        else if(string_input.getText().equals("double b = 6.9;")){
            check_input.setText("Language is Available!");
        }
        else if(string_input.getText().equals("double b = 6.9; int a = 2; ")){
            check_input.setText("Language is Available!");
        }else{
            check_input.setText("Language is Not Available!");
        }
    }
    private void sendStringValue(){
        String newValue = string_input.getText();
        jsonManip.writeToLanguageAvailable(newValue);
    }

    private void sendTriggerValue(){
        jsonManip.sendTrigger();
    }

}
