package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("library-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("iTunes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
//        APIUtility.readITunesApi("Comedy");
//        APIResponse apiResponse = APIUtility.getResultFromJson();
//        System.out.println(apiResponse);
    }
}