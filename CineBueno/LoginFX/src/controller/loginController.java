package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Database;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    Database database;
    @FXML
    TextField userTxtField;
    @FXML
    PasswordField passwordTxtField;

    public void closeLogin(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void checkLogin(ActionEvent event) throws SQLException, IOException {
        String username = userTxtField.getText();
        String password = passwordTxtField.getText();
        if(database.is_register(username, password)){
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            System.out.println("Correcto");
            Parent mainPane = FXMLLoader.load(getClass().getResource("../views/mainFrame.fxml"));
            Scene main = new Scene(mainPane);
            Stage window = new Stage();
            window.setScene(main);
            window.setMaximized(true);
            window.show();
        }
        else{
            userTxtField.getStyleClass().add("error-text-field");
            passwordTxtField.getStyleClass().add("error-text-field");
            userTxtField.clear();
            passwordTxtField.clear();
            System.out.println("Incorrecto");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            database = new Database();
        } catch (URISyntaxException e) {
        } catch (SQLException throwables) {
        }

    }
}
