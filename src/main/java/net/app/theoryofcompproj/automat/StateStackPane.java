package net.app.theoryofcompproj.automat;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import net.app.theoryofcompproj.Fonts;

public class StateStackPane extends StackPane {
    Fonts fonts = new Fonts();
    public StateStackPane(String state_name){
        Circle state_circle = new Circle();
        StackPane state = new StackPane();

        double radius = 30;
        state_circle.setRadius(radius);
        state_circle.setFill(Color.web("#D9D9D9"));

        Text state_text = new Text(state_name);
        state_text.setFill(Color.web("#000000"));

        state_text.setFont(fonts.getLemonMilk18());

        state.setAlignment(state_text, Pos.CENTER);
        state.getChildren().addAll(state_circle, state_text);
    }
}
