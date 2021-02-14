package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;



public class LoginController implements Initializable {
    @FXML
    private Label txtClock;
    @FXML
    private Label txtDate;
    





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LocalDate date = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String formatDateTime = now.format(format);
        txtClock.setText(String.valueOf(date));
        txtDate.setText(String.valueOf(formatDateTime));
    }

    public void closePane(javafx.event.ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }


    public void loginAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        Parent mainPane = null;
        try {
            mainPane = FXMLLoader.load(getClass().getResource("../views/MainMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene main = new Scene(mainPane);

        Stage window = new Stage();
        window.show();
    }
}
