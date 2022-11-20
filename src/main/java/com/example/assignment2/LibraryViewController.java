package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class LibraryViewController implements Initializable {

//    @FXML
//    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<Result, String> artistNameColumn;

    @FXML
    private TableColumn<Result, String> countryColumn;

    // Change this to Date type later
    @FXML
    private TableColumn<Result, String> releaseDateColumn;

    @FXML
    private TableColumn<Result, String> typeColumn;

    @FXML
    private TableView<Result> resultsTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("wrapperType"));
    }

    @FXML
    public void searchButtonPressed(ActionEvent event) throws IOException, InterruptedException {

        resultsTableView.getItems().clear();

        String searchText = searchTextField.getText();
        APIUtility.readITunesApi(searchText);
        APIResponse apiResponse = APIUtility.getResultFromJson();
        List<Result> results = Arrays.stream(apiResponse.getResults()).toList();

        resultsTableView.getItems().addAll(results);
    }

    @FXML
    public void viewButtonPressed(ActionEvent event) {

    }
}
