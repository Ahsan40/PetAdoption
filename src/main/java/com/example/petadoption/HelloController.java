package com.example.petadoption;

import Classes.Animal;
import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable{
    HashMap<User, ArrayList<Animal>> DB;
    ArrayList<User>DBuser;


    @FXML
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView image;
    @FXML
    private Button SignUp;
    @FXML
    private Button SignIn;
    @FXML
    private Button Back1;
    @FXML
    private Button Back2;
    @FXML
    private Button Back3;
    @FXML
    private Button ConfirmU;
    @FXML
    private Button ConfirmC;
    @FXML
    private Button ConfirmD;
    @FXML
    private Text photoUploadUser;
    @FXML
    private Text photoUploadCat;
    @FXML
    private Text photoUploadDog;
    @FXML
    private Button Upforadoption;
    @FXML
    private Button ForAdoption;
    @FXML
    private Button activity;
    @FXML
    private Button profile;
    @FXML
    private Text Cat;
    @FXML
    private Text Dog;
    @FXML
    private Button Bcat;
    @FXML
    private Button Bdog;
    private String AnimalType;
    @FXML
    private Text warning;
    @FXML
    private PasswordField pTF;

    @FXML
    private TextField uTF;
    @FXML
    private Text Wrong;
    @FXML
    private CheckBox ChSP;
    @FXML
    private TextField tfshowPass;



    @FXML
    void changevisibility(ActionEvent e){
        if(ChSP.isSelected()){
            tfshowPass.setText(pTF.getText());
            tfshowPass.setVisible(true);
            pTF.setVisible(false);
            return;
        }
        pTF.setText(tfshowPass.getText());
        tfshowPass.setVisible(false);
        pTF.setVisible(true);

    }







    public void switchtoSceneSignup(ActionEvent e)throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("Signup.fxml")) ;
       stage=(Stage)((Node)e.getSource()).getScene().getWindow();
       scene=new Scene(root);
       stage.setScene(scene);
       stage.show();

    }
    public void switchtoSceneHelloview(ActionEvent e)throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml")) ;
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchtoSceneSignin1(ActionEvent e)throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("Sign1st.fxml")) ;
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchtoSceneProfile(ActionEvent e)throws IOException {

        String name="";
        String username="";
        String password="";
        String email="";
        String location="";
        String contact="";
        String profilePic="";
        File f= new File("data.txt");
        Scanner sc= new Scanner(f);
        String USername=uTF.getText();
        String pass=pTF.getText();
        String ShowPass= tfshowPass.getText();

        String line=" ";
        int flag=0;

        while (sc.hasNext()){
            line=sc.nextLine();
            String parts[]=line.split("##");
            name=parts[0];
            username=parts[1];
            password=parts[2];
            email=parts[3];
            location=parts[4];
            contact=parts[5];
            profilePic=parts[6];
            if(username.equals(USername)&&(password.equals(pass))||password.equals(ShowPass)){
                System.out.printf(profilePic);
                HelloApplication.profile= new User(name,username,password,email,location,contact, profilePic);
                Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Profile.fxml")));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else if(USername.isEmpty()|| (pass.isEmpty()&&ShowPass.isEmpty())){
                flag=-1;
            }
        }

        if (flag==-1) {

            Wrong.setText("Please Enter the Information");

        } else {

            Wrong.setText("The username or password is incorrect");

        }



    }
    public void switchtoSceneCatReg(ActionEvent e)throws IOException {
        AnimalType ="cat";


        Parent root= FXMLLoader.load(getClass().getResource("CatReg.fxml")) ;
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchtoSceneCatorDog(ActionEvent e)throws IOException {


        Parent root= FXMLLoader.load(getClass().getResource("CatorDog.fxml")) ;
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchtoSceneDogReg(ActionEvent e)throws IOException {
        AnimalType ="dog";

        Parent root= FXMLLoader.load(getClass().getResource("DogReg.fxml")) ;
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void fileSelector(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile == null)
            System.out.println(" - Canceled!");
        else {
            handleFile(selectedFile);
        }
    }

    private void handleFile(File selectedFile) {
        if(!selectedFile.getName().endsWith(".jpg")&&!selectedFile.getName().endsWith(".png")){
            warning.setText("File not Supported");

        }


    }
    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void minimize(MouseEvent e) {
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }








    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}