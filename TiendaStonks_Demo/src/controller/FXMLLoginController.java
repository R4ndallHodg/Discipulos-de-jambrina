/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yiin Anton
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private Button btnConectar;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPwd;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void btnConectarAction(ActionEvent event){
        Conexiones.Conexion.setcuenta(txtUser.getText(), txtPwd.getText());
        Conexiones.Conexion.getConexion();
        if(Conexiones.Conexion.getstatus()){
            System.out.println("AL FIN MIERDA SIUUUUUUU");
            try {
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLProducto.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Datos");
            alert.setHeaderText("INICIO DE SESION");
            alert.setContentText("INGRESE NUEVAMENTE LOS DATOS");
            alert.showAndWait();
            txtUser.setText("");
            txtPwd.setText("");
        } 
    }
    
    
}
