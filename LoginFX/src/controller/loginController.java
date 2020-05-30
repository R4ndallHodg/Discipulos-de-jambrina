package controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.stage.StageStyle;
import pojo.database;

public class loginController implements Initializable {

    database database;
    @FXML
    TextField userTxtField;
    @FXML
    PasswordField passwordTxtField;

    public void closeLogin(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void checkLogin() throws SQLException, IOException {
        String username = userTxtField.getText();
        String password = passwordTxtField.getText();
        if(database.is_register(username, password)){
            System.out.println("Correcto");
            Parent root = FXMLLoader.load(getClass().getResource("../views/mainFrame.fxml"));
            Scene scene = new Scene(root);
            Stage  stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setMaximized(true);
            stage.show();
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
