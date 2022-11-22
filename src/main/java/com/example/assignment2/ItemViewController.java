package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Import also not working
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

public class ItemViewController  {

    @FXML
    public Label artistNameLabel;

    @FXML
    private Label collectionNameLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label trackNameLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private ImageView coverImageView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label urlLinkLabel;

//    @FXML
//    private MediaView songMediaView;

    // Didn't actually find any use for the initialize interface, so I just removed/commented it.
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Does nothing ...
//    }

    /**
     * This is the method which loads up the selected item from the TableView object in the previous scene. This gives a more detailed view of the Result object transferred from the 'Library' scene
     * @param selectedItem - this is the Result object that is selected in the TableView
     */
    @FXML
    public void loadItem(Result selectedItem) {

        // Used this for testing purpose
//        System.out.println(selectedItem.getWrapperType());
//        System.out.println(selectedItem.getArtistName());
//        System.out.println(selectedItem.getCollectionName());
//        System.out.println(selectedItem.getTrackName());
//        System.out.println(selectedItem.getPrimaryGenreName());

        titleLabel.setText(selectedItem.getTrackName());

    //  Another way - by using local resources
//        FileInputStream fileInputStream = new FileInputStream("src/main/resources/com/example/assignment2/sampleImg.jpg");
//        Image image = new Image(fileInputStream);
        Image image = new Image(selectedItem.getArtworkUrl100());
        coverImageView.setImage(image);

        typeLabel.setText(selectedItem.getKind());
        artistNameLabel.setText(selectedItem.getArtistName());
        collectionNameLabel.setText(selectedItem.getCollectionName());
        genreLabel.setText(selectedItem.getPrimaryGenreName());
        trackNameLabel.setText(selectedItem.getTrackName());

        urlLinkLabel.setText(selectedItem.getPreviewUrl());

//        Testing the Result object being passed on ...
//        System.out.println(selectedItem);


//         This does not work!!

//        Media media = new Media(selectedItem.getPreviewUrl());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.play();
    }

    /**
     * This is a trigger for the back button to switch scenes and load up the library view from the detailed view scene
     * @param event - back button is pressed
     * @throws IOException
     */
    @FXML
    public void backButtonPressed(ActionEvent event) throws IOException {
        Node eventNodeSource = (Node)event.getSource();
        SceneChanger.changeScene(eventNodeSource, "library-view.fxml", "Library");
    }

    /**
     * This is another eventHandler for the enter key to be pressed after any TableView item selection
     * @param keyEvent - Enter key pressed from the keyboard
     * @throws IOException
     */
    @FXML
    public void escKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {

            Node eventNodeSource = (Node)keyEvent.getSource();
            SceneChanger.changeScene(eventNodeSource, "library-view.fxml", "Library");
        }
    }
}
