/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import TableModels.ProductoTableModel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yiin Anton
 */
public class FXMLProductoController implements Initializable {
    
    @FXML
    private TableView<ProductoTableModel> tblProductos;
    @FXML
    private TableColumn<ProductoTableModel, Integer> col_ID;
    @FXML
    private TableColumn<ProductoTableModel, Integer> col_IDProveedor;
    @FXML
    private TableColumn<ProductoTableModel, String> col_Descripcion;
    @FXML
    private TableColumn<ProductoTableModel, Integer> col_Stock;
    @FXML
    private TableColumn<ProductoTableModel, Float> col_Precio;
    
    static ResultSet res;
    ObservableList<ProductoTableModel> productos = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        col_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_ID.setMinWidth(200);
        col_IDProveedor.setCellValueFactory(new PropertyValueFactory<>("id_Proveedor"));
        col_IDProveedor.setMinWidth(200);
        col_Descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        col_Descripcion.setMinWidth(200);
        col_Stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        col_Stock.setMinWidth(200);
        col_Precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        col_Precio.setMinWidth(200);
        try {
            CargarProductos();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblProductos.setItems(productos);
    }    
    
    public void CargarProductos() throws SQLException{  
        res = Conexiones.Conexion.Consulta("select * from Producto");
        while(res.next()){
        productos.add(new ProductoTableModel(res.getInt("ID_Producto"), res.getInt("ID_Proveedor"), res.getString("Descripcion"), res.getInt("Stock"), res.getFloat("Precio")));
        
        }
    }
    
}
