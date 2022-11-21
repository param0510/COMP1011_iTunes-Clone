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
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("kind"));
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("trackName"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

//        thumbnailColumn.setCellValueFactory(new PropertyValueFactory<>("thumbnailImage"));

        try {
            APIUtility.readITunesApi("*");
            APIResponse apiResponse = APIUtility.getResultFromJson();
            List<Result> results = Arrays.stream(apiResponse.getResults()).toList();

            resultsTableView.getItems().addAll(results);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * I chose to remove the ActionEvent object for this one as it wasn't required for further application and I wanted to avoid any excess data to be transferred within the application.
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    public void searchButtonPressed() throws IOException, InterruptedException {

        resultsTableView.getItems().clear();

        String searchText = searchTextField.getText();
        APIUtility.readITunesApi(searchText);
        APIResponse apiResponse = APIUtility.getResultFromJson();
        List<Result> results = Arrays.stream(apiResponse.getResults()).toList();

        resultsTableView.getItems().addAll(results);
    }

    @FXML
    public void viewButtonPressed(ActionEvent event) throws IOException {
        if (resultsTableView.getSelectionModel().getSelectedItem() != null) {
            Result itemSelected = resultsTableView.getSelectionModel().getSelectedItem();
            SceneChanger.showItemView(event, "item-view.fxml", "Selected Item", itemSelected);

        }

    }

    @FXML
    public void enterKeyOnSearchBar(KeyEvent keyEvent) throws IOException, InterruptedException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            searchButtonPressed();
        }
    }


    // I had to hard code or repeat the scene loading commands due to the lack of ActionEvent object.
    @FXML
    public void enterKeyOnSelectedItem(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            if (resultsTableView.getSelectionModel().getSelectedItem() != null) {
                Result itemSelected = resultsTableView.getSelectionModel().getSelectedItem();

                Node keyEventSource = ((Node)keyEvent.getSource());

                double width = keyEventSource.getScene().getWidth();
                double height = keyEventSource.getScene().getHeight();

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("item-view.fxml"));

                Scene scene = new Scene(fxmlLoader.load(), width, height);

                Stage stage = (Stage) keyEventSource.getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Selection View");
                stage.show();

                ItemViewController ivc = fxmlLoader.getController();
                ivc.loadItem(itemSelected);
            }

        }
    }
}
