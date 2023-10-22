package net.app.theoryofcompproj;

import java.io.File;
import java.io.IOException;
import java.net.URL;


import com.fasterxml.jackson.core.JsonParseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App extends Application {
    @Override

    public void start(Stage stage) throws IOException {

        StackPane stack = FXMLLoader.load(new URL(App.class.getResource("LinguaVerfix.fxml").toExternalForm()));

        Scene scene = new Scene(stack, 400, 400);
        stage.setTitle("Lingua Verfix");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}