package net.app.theoryofcompproj;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(BorderPane borderPane, String fxml) throws IOException {
        BorderPane nextBorderPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(fxml)));
        borderPane.getChildren().removeAll();
        borderPane.getChildren().setAll(nextBorderPane);
        borderPane.setCenter(nextBorderPane);

    }

}
