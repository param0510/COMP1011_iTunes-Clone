package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    // This instance variable is used to store the fxml file being loaded
    private static FXMLLoader fxmlLoader;

    /**
     * This method is used to change scenes through event handlers both on screen and keyboard
     * @param eventNodeSource - This is the source of the event handler be it a mouse click(ActionEvent) or a key press(KeyEvent)
     * @param fileName - Name of the fxml file to be loaded from resource directory
     * @param sceneTitle - Title for the new scene being loaded
     * @throws IOException
     */
    public static void changeScene(Node eventNodeSource, String fileName, String sceneTitle) throws IOException {

        double width = eventNodeSource.getScene().getWidth();
        double height = eventNodeSource.getScene().getHeight();

        fxmlLoader = new FXMLLoader(Main.class.getResource(fileName));

        Scene scene = new Scene(fxmlLoader.load(), width, height);

        Stage stage = (Stage) eventNodeSource.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(sceneTitle);
        stage.show();

        // Add icons later...
    }

    /**
     * This is an intermediate function for loading up the item-view.fxml file with additional commands regarding populating the scene objects, i.e. Labels, with the data from the Result object being passed from the previous scene.
     * @param eventNodeSource - Source of the event handler - View button press or Enter key press
     * @param fileName - File to be loaded - item-view.fxml
     * @param sceneTitle - Title for the new scene
     * @param itemSelected - Result object being transferred between scenes
     * @throws IOException
     */
    public static void showItemView(Node eventNodeSource, String fileName, String sceneTitle, Result itemSelected) throws IOException
    {
        changeScene(eventNodeSource, fileName, sceneTitle);
        ItemViewController ivc = fxmlLoader.getController();
        ivc.loadItem(itemSelected);

    }

}
