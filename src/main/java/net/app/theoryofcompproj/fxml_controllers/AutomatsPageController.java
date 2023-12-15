package net.app.theoryofcompproj.fxml_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.app.theoryofcompproj.*;
import net.app.theoryofcompproj.interfaces.LanguageCheckerInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AutomatsPageController implements Initializable {

    Styling style = new Styling();
    Fonts fonts = new Fonts();
    JsonManip jsonManip = new JsonManip();


    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView arrowBtnAutomats;

    @FXML
    private Button check_btn;
    @FXML
    private Button reset_btn;

    @FXML
    private CheckBox int_checkbox;
    @FXML
    private CheckBox double_checkbox;
    @FXML
    private CheckBox float_checkbox;
    @FXML
    private CheckBox char_checkbox;
    @FXML
    private CheckBox string_checkbox;

    @FXML
    private CheckBox variable_checkbox;

    @FXML
    private CheckBox if_checkbox;
    @FXML
    private CheckBox do_while_checkbox;
    @FXML
    private CheckBox while_checkbox;
    @FXML
    private CheckBox for_checkbox;

    @FXML
    private CheckBox main_checkbox;
    @FXML
    private CheckBox array_checkbox;

    @FXML
    void onCheckBtnSwitch() throws IOException {
        jsonManip.writeToSelectedAutomatsJson(int_checkbox.isSelected(),
                double_checkbox.isSelected(), float_checkbox.isSelected()
                ,char_checkbox.isSelected(),string_checkbox.isSelected(),variable_checkbox.isSelected(),
                if_checkbox.isSelected(),do_while_checkbox.isSelected(),while_checkbox.isSelected(),
                for_checkbox.isSelected(),main_checkbox.isSelected(),array_checkbox.isSelected());

        new SceneSwitch(borderPane, "fxml/LanguageCheckerPage.fxml");
    }
    @FXML
    void switchScene() throws IOException {
        new SceneSwitch(borderPane, "fxml/MainPage.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Apply the custom font to the Text elements
        int_checkbox.setFont(fonts.getLemonMilk22());
        double_checkbox.setFont(fonts.getLemonMilk22());
        float_checkbox.setFont(fonts.getLemonMilk22());
        char_checkbox.setFont(fonts.getLemonMilk22());
        string_checkbox.setFont(fonts.getLemonMilk22());

        if_checkbox.setFont(fonts.getLemonMilk22());
        do_while_checkbox.setFont(fonts.getLemonMilk22());
        while_checkbox.setFont(fonts.getLemonMilk22());
        for_checkbox.setFont(fonts.getLemonMilk22());

        variable_checkbox.setFont(fonts.getLemonMilk22());

        main_checkbox.setFont(fonts.getLemonMilk22());
        array_checkbox.setFont(fonts.getLemonMilk22());

        // Change Style on Hover for buttons
        addHoverListener(reset_btn, "BTN_RED", "BTN2_RED");
        addHoverListener(check_btn, "BTN", "BTN2");

        reset_btn.setOnMouseClicked(e-> resetAutomats());
        check_btn.setOnMouseClicked(e-> {
            try {
                jsonManip.writeToSelectedAutomatsJson(int_checkbox.isSelected(),
                        double_checkbox.isSelected(), float_checkbox.isSelected()
                ,char_checkbox.isSelected(),string_checkbox.isSelected(),variable_checkbox.isSelected(),
                        if_checkbox.isSelected(),do_while_checkbox.isSelected(),while_checkbox.isSelected(),
                for_checkbox.isSelected(),main_checkbox.isSelected(),array_checkbox.isSelected());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    // Reset All CheckBoxes
    public void resetAutomats(){
        int_checkbox.setSelected(false);
        double_checkbox.setSelected(false);
        float_checkbox.setSelected(false);
        char_checkbox.setSelected(false);
        string_checkbox.setSelected(false);

        if_checkbox.setSelected(false);
        do_while_checkbox.setSelected(false);
        while_checkbox.setSelected(false);
        for_checkbox.setSelected(false);

        variable_checkbox.setSelected(false);

        main_checkbox.setSelected(false);
        array_checkbox.setSelected(false);

    }

    // On Hover change Style
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
