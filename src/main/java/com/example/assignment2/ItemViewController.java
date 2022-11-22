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

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Does nothing as of now
//        artistNameLabel.setText("Chainsmokers");

//        artistNameLabel.setText("Artist Name");
//        collectionNameLabel.setText("Collection Name Label");
//        genreLabel.setText("Genre Label");
//        trackNameLabel.setText("Track name Label");
//        typeLabel.setText("type Label");
//    }

    @FXML
    public void loadItem(Result selectedItem) throws FileNotFoundException {

        System.out.println(selectedItem.getWrapperType());
        System.out.println(selectedItem.getArtistName());
        System.out.println(selectedItem.getCollectionName());
        System.out.println(selectedItem.getTrackName());
        System.out.println(selectedItem.getPrimaryGenreName());

        titleLabel.setText(selectedItem.getTrackName());

    //  Another way - by using local resources
//        FileInputStream fileInputStream = new FileInputStream("src/main/resources/com/example/assignment2/sampleImg.jpg");
//        Image image = new Image(fileInputStream);
        Image image = new Image(selectedItem.getArtworkUrl100());
        coverImageView.setImage(image);

        // Remove this one...
        typeLabel.setText(selectedItem.getKind());

        artistNameLabel.setText(selectedItem.getArtistName());
        collectionNameLabel.setText(selectedItem.getCollectionName());
        genreLabel.setText(selectedItem.getPrimaryGenreName());
        trackNameLabel.setText(selectedItem.getTrackName());

        urlLinkLabel.setText(selectedItem.getPreviewUrl());

//         This does not work!!

//        Media media = new Media(selectedItem.getPreviewUrl());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.play();
    }

    @FXML
    public void backButtonPressed(ActionEvent event) throws IOException {
        SceneChanger.showLibraryView(event, "library-view.fxml", "Library");
    }

    // I had to hard code or repeat the scene loading commands due to the lack of ActionEvent object.
    @FXML
    public void escKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {

            // Another way of settting up the stage from source elements
            double width = titleLabel.getScene().getWidth();
            double height = titleLabel.getScene().getHeight();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("library-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), width, height);

            Stage stage = (Stage) titleLabel.getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle("Library");
            stage.show();
        }
    }
}
