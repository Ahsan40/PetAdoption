package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import utils.Utils;

import java.io.IOException;

public class AnimalProfile {

    @FXML
    private Button AddFav;

    @FXML
    private Text Age;

    @FXML
    private Button Logout;

    @FXML
    private Button RegPets;

    @FXML
    private AnchorPane aPane;

    @FXML
    private Button activity;

    @FXML
    private Text breedName;

    @FXML
    private Text contactNumber;

    @FXML
    private Button favourites;

    @FXML
    private Text foodHabit;

    @FXML
    private Text location;

    @FXML
    private Text ownersName;

    @FXML
    private Text petsName;

    @FXML
    private Button profile;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void minimize(MouseEvent e) {

        HelloApplication.primaryStage.setIconified(true);
    }
    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException {
        Utils.changeScene("RegisteredPETS.fxml");
    }

    public void switchtoSceneHelloview(ActionEvent e) throws IOException {
        Utils.changeScene("hello-view.fxml");
    }


    @FXML
    public void switchtoSceneProfile(ActionEvent e) throws IOException {
        Utils.changeScene("Profile.fxml");
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

}