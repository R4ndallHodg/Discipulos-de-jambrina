/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxloginform;

import database.dbConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author DewinU
 */
public class FXMLLoginDemoController implements Initializable {
    
    
    dbConnection database;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    public void loginInfo() throws SQLException, URISyntaxException{
        String user = txtUsername.getText();
        String password = txtPassword.getText();
        
        if(database.is_register(user, password)){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Congrats");
            alert.setContentText("Usuario Registrado");
            alert.showAndWait();   
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setContentText("Usuario Incorrecto");
            alert.showAndWait();   
        }
                     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            database = new dbConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FXMLLoginDemoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLLoginDemoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
