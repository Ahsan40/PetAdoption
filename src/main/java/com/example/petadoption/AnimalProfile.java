package com.example.petadoption;

import Classes.Animal;
import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utils.Operations;
import utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.petadoption.HelloApplication.sendObj;

public class AnimalProfile implements Initializable {

    boolean existInFavorite;
    @FXML
    private Button btnAddFav;
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
    private Text txtAdoptionStatus;
    @FXML
    private Text petsName;
    @FXML
    private Button profile;
    @FXML
    private Rectangle animalPic;
    @FXML
    private Button btnReqForAdopt;

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
    public void switchtoSceneFav(ActionEvent e) throws IOException {
        Utils.changeScene("favourite.fxml");
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

    private void updateBtnAddFavouriteText() {
        btnAddFav.setText(existInFavorite ? "Remove From Favourite" : "Add To Favourite");
    }


    @FXML
    void btnAddFavAction(ActionEvent event) throws IOException {
        Operations.toggleFavourite(!existInFavorite);
        existInFavorite = !existInFavorite;
        updateBtnAddFavouriteText();
    }

    @FXML
    void btnReqForAdoptAction(ActionEvent event) throws IOException {
        // sending registration data
        System.out.println(" - Sending Request to Adopt Pet");
        sendObj.writeObject("requestToAdoptPet");
        sendObj.writeObject(HelloApplication.profile);
        sendObj.writeObject(HelloApplication.animal);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Animal a = HelloApplication.animal;
        try {
            existInFavorite = Operations.checkFavourite();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        btnAddFav.setDisable(!a.getStatus().equalsIgnoreCase("available"));
        updateBtnAddFavouriteText();
        btnReqForAdopt.setDisable(!a.getStatus().equalsIgnoreCase("available"));
        breedName.setText(a.getBreedName());
        petsName.setText(a.getPetname());
        Age.setText(a.getAge());
        foodHabit.setText(a.getFoodhabit());
        animalPic.setFill(new ImagePattern(new Image("file:" + Utils.imgTotempImg(a.getAnimalPic()))));
        txtAdoptionStatus.setText(a.getStatus());
        User owner;
        try {
            HelloApplication.sendObj.writeObject("getUserFromUserName");
            HelloApplication.sendObj.writeObject(a.getOwner());
            owner = (User) HelloApplication.receiveObj.readObject();

            // Update Owner Info
            ownersName.setText(owner.getName());
            System.out.println(" - Owner Name: " + owner.getName());
            location.setText(owner.getLocation());
            contactNumber.setText(owner.getContact());
            btnReqForAdopt.setVisible(!a.getOwner().equals(HelloApplication.profile.getUsername()));
        } catch (Exception ignored) {
        }
    }
}