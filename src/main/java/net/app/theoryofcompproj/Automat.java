package net.app.theoryofcompproj;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Automat {

    Fonts fonts = new Fonts();
    private final double radius = 30;

    public StackPane InitialStateStackPane(String state_name){
        Circle initial_state_circle = new Circle();
        StackPane initial_state = new StackPane();

        initial_state_circle.setRadius(radius);
        initial_state_circle.setFill(Color.web("#0032E4"));

        Text state_text = new Text(state_name);
        state_text.setFill(Color.web("#FFFFFF"));

        state_text.setFont(fonts.getLemonMilk18());

        initial_state.setAlignment(state_text, Pos.CENTER);
        initial_state.getChildren().addAll(initial_state_circle, state_text);

        return  initial_state;
    }
    public StackPane StateStackPane(String state_name){
        Circle state_circle = new Circle();
        StackPane state = new StackPane();

        state_circle.setRadius(radius);
        state_circle.setFill(Color.web("#D9D9D9"));

        Text state_text = new Text(state_name);
        state_text.setFill(Color.web("#000000"));

        state_text.setFont(fonts.getLemonMilk18());

        state.setAlignment(state_text, Pos.CENTER);
        state.getChildren().addAll(state_circle, state_text);

        return  state;
    }
    public StackPane FinalStateStackPane(String state_name){
        Circle final_state_circle = new Circle();
        StackPane final_state = new StackPane();

        final_state_circle.setRadius(radius);
        final_state_circle.setFill(Color.web("#D9D9D9"));
        final_state_circle.setStroke(Color.web("#000000"));

        Text state_text = new Text(state_name);
        state_text.setFill(Color.web("#000000"));

        state_text.setFont(fonts.getLemonMilk18());

        final_state.setAlignment(state_text, Pos.CENTER);
        final_state.getChildren().addAll(final_state_circle, state_text);

        return  final_state;
    }

    public Pane int_automat(){
        Pane int_automat_pane = new Pane();

        int_automat_pane.setPrefSize(900,300);

        StackPane initialStateStackPane = InitialStateStackPane("q0");
        StackPane stateStackPane = StateStackPane("q1");
        StackPane finalStackPane = FinalStateStackPane("q2");

        double maxWidth = Math.max(
                initialStateStackPane.getBoundsInLocal().getMaxX(),
                Math.max(stateStackPane.getBoundsInLocal().getMaxX(), finalStackPane.getBoundsInLocal().getMaxX())
        );

        double maxHeight = Math.max(
                initialStateStackPane.getBoundsInLocal().getMaxY(),
                Math.max(stateStackPane.getBoundsInLocal().getMaxY(), finalStackPane.getBoundsInLocal().getMaxY())
        );

        Pane intAutomatPane = new Pane(initialStateStackPane, stateStackPane, finalStackPane);
        intAutomatPane.setPrefSize(maxWidth, maxHeight);


        int_automat_pane.getChildren().addAll(initialStateStackPane,stateStackPane,finalStackPane);

        return int_automat_pane;
    }
}
