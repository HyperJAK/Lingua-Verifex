package net.app.theoryofcompproj.automat;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import net.app.theoryofcompproj.Fonts;

public class FinalStateStackPane extends StackPane {

    Fonts fonts = new Fonts();
    public  FinalStateStackPane(String state_name){
        Circle final_state_circle = new Circle();
        StackPane final_state = new StackPane();

        double radius = 30;
        final_state_circle.setRadius(radius);
        final_state_circle.setFill(Color.web("#D9D9D9"));
        final_state_circle.setStroke(Color.web("#000000"));

        Text state_text = new Text(state_name);
        state_text.setFill(Color.web("#000000"));

        state_text.setFont(fonts.getLemonMilk18());

        final_state.setAlignment(state_text, Pos.CENTER);
        final_state.getChildren().addAll(final_state_circle, state_text);
    }
}
