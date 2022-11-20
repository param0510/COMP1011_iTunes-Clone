package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void changeScene(ActionEvent event, String fileName, String sceneTitle) throws IOException {

        double width = (((Node)event.getSource()).getScene().getWidth());
        double height = (((Node)event.getSource()).getScene().getHeight());

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fileName));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(sceneTitle);
        stage.show();

        // Add icons later...
    }
}