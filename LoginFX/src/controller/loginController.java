package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.database;

import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    database database;
    @FXML
    TextField userTxtField;
    @FXML
    PasswordField passwordTxtField;

    public void closeLogin(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void checkLogin() throws SQLException {
        String username = userTxtField.getText();
        String password = passwordTxtField.getText();
        if(database.is_register(username, password)){
            System.out.println("Correcto");
        }
        else{
            System.out.println("Incorrecto");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            database = new database();
        } catch (URISyntaxException e) {
        } catch (SQLException throwables) {
        }

    }
}
