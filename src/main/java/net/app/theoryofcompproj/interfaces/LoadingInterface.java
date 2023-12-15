package net.app.theoryofcompproj.interfaces;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoadingInterface extends Scene {

    private final Duration delay = Duration.seconds(3);
    public LoadingInterface(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public void changeToNewStage(Stage primaryStage, Stage loadingStage) {
        loadingStage.close();
        primaryStage.show();
    }
    public Duration getDelay() {
        return delay;
    }
}
