package net.app.theoryofcompproj.automat;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import net.app.theoryofcompproj.Fonts;

public class InitialStateStackPane extends StackPane {
    Fonts fonts = new Fonts();
    public InitialStateStackPane(String state_name){
        Circle initial_state_circle = new Circle();
        StackPane initial_state = new StackPane();

        double radius = 30;
        initial_state_circle.setRadius(radius);
        initial_state_circle.setFill(Color.web("#0032E4"));

        Text state_text = new Text(state_name);
        state_text.setFill(Color.web("#FFFFFF"));

        state_text.setFont(fonts.getLemonMilk18());

        initial_state.setAlignment(state_text, Pos.CENTER);
        initial_state.getChildren().addAll(initial_state_circle, state_text);
    }

}
