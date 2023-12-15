package net.app.theoryofcompproj;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;
public class Styling {

    //initialize CSS Files
    private final String DefaultCss = this.getClass().getResource("css/Default.css").toExternalForm();
    private final String HoverCss = this.getClass().getResource("css/DefaultHover.css").toExternalForm();
    public void ChangeButtonColor(Button btn, String id1, String id2) {

        EventHandler<ActionEvent> eventHandler = e -> {
            btn.setId(id2);
        };

        Timeline time = new Timeline(
                new KeyFrame(Duration.millis(50), eventHandler));

        btn.setOnMouseEntered(e -> {
            time.play();
            btn.setTextFill(Color.rgb(0,50,228));
            btn.setCursor(Cursor.HAND);
        });

        btn.setOnMouseExited(e -> {
            time.stop();
            btn.setTextFill(Color.WHITE);
            btn.setId(id1);
        });
    }

    //Getters
    public String getDefaultCss() {
        return DefaultCss;
    }

    public String getHoverCss() {
        return HoverCss;
    }


}
