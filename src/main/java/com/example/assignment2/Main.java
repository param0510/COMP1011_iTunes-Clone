package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /**
     * This method loads up the initial scene on launch using FXMLoader class
     * @param stage - this is the stage on which the scene is loaded upon
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("library-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("item-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("iTunes");
        stage.setTitle("iTunes - Song");
        stage.setScene(scene);
        stage.show();

        ItemViewController ivc = fxmlLoader.getController();
        APIResponse apiResponse = APIUtility.getResultFromJson();
        Result itemSelected = apiResponse.getResults()[5];
        ivc.loadItem(itemSelected);
    }

    /**
     * This is the main method which launches the application
     * @param args
     */
    public static void main(String[] args) {

        launch();
    }
}