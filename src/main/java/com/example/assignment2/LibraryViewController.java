package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class LibraryViewController implements Initializable {

//    @FXML
//    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<Result, String> typeColumn;

    @FXML
    private TableColumn<Result, String> artistNameColumn;

    @FXML
    private TableColumn<Result, String> nameColumn;

    @FXML
    private TableColumn<Result, String> countryColumn;

    // Change this to Date type later
    @FXML
    private TableColumn<Result, String> releaseDateColumn;

    @FXML
    private TableColumn<Result, Image> thumbnailColumn;

    @FXML
    private TableView<Result> resultsTableView;

    private List<Result> results;
    private APIResponse apiResponse;

    /**
     * This is the initialize method which loads up whenever the library-view.fxml scene is loaded
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        typeColumn.setCellValueFactory(new PropertyValueFactory<>("kind"));
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("trackName"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

//        thumbnailColumn.setCellValueFactory(new PropertyValueFactory<>("thumbnailImage"));

        // This enables me to retain the search history through the pre-written json file.
        apiResponse = APIUtility.getResultFromJson();
        if (apiResponse == null) {
            try {
                APIUtility.readITunesApi("all");
                APIResponse apiResponse = APIUtility.getResultFromJson();
                results = Arrays.stream(apiResponse.getResults()).toList();

                resultsTableView.getItems().clear();
                resultsTableView.getItems().addAll(results);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            results = Arrays.stream(apiResponse.getResults()).toList();
            resultsTableView.getItems().clear();
            resultsTableView.getItems().addAll(results);
        }
    }

    /**
     * This is an eventHandler for the search button to be pressed after the user enters the search term in the text field
     * I chose to remove the ActionEvent object for this one as it wasn't required for further application, and I wanted to avoid any excess data to be transferred within the application.
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    public void searchButtonPressed() throws IOException, InterruptedException {
        resultsTableView.getItems().clear();

        String searchText = searchTextField.getText();
        APIUtility.readITunesApi(searchText);
        apiResponse = APIUtility.getResultFromJson();
        if (apiResponse != null) {

            results = Arrays.stream(apiResponse.getResults()).toList();

            // Try this one later... To filter out any Result objects with null artistName
//        results = Arrays.stream(apiResponse.getResults()).collect(Collectors.filtering(a -> a.getArtistName())).toList();

            resultsTableView.getItems().addAll(results);
            searchTextField.clear();
        }
        else {
            // TRY TO DISPLAY THIS USING WINDOW POP UP...
            System.out.println("Sorry we can't find anything with: " + "'s'");
        }

    }

    /**
     * This is an eventHandler for enter key being pressed after entering the search term in the search text field
     * @param keyEvent - Enter key is pressed from keyboard
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    public void enterKeyOnSearchBar(KeyEvent keyEvent) throws IOException, InterruptedException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            searchButtonPressed();
        }
    }

    /**
     * this is an eventHandler for view button being pressed which loads up a detailed view scene by using the SceneChanger class
     * @param event - view button is clicked/pressed.
     * @throws IOException
     */
    @FXML
    public void viewButtonPressed(ActionEvent event) throws IOException {
        if (resultsTableView.getSelectionModel().getSelectedItem() != null) {
            Result itemSelected = resultsTableView.getSelectionModel().getSelectedItem();
            Node eventNodeSource = (Node)event.getSource();
            SceneChanger.showItemView(eventNodeSource, "item-view.fxml", "Selected Item", itemSelected);
        }
    }

    /**
     * this is another event handler for pressing enter key after selecting an item (Result class object) in the table view object
     * @param keyEvent - Enter key is pressed on the keyboard
     * @throws IOException
     */
    // I had to hard code or repeat the scene loading commands due to the lack of ActionEvent object.
    @FXML
    public void enterKeyOnSelectedItem(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            if (resultsTableView.getSelectionModel().getSelectedItem() != null) {
                Result itemSelected = resultsTableView.getSelectionModel().getSelectedItem();

                Node eventNodeSource = (Node)keyEvent.getSource();
                SceneChanger.showItemView(eventNodeSource, "item-view.fxml", "Selected Item", itemSelected);
            }

        }
    }
}
