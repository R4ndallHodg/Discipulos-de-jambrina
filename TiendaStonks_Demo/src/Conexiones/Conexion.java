package Conexiones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

public class Conexion {
    
    static Connection contacto = null;
    public static String usuario;
    public static String password;
    public static boolean status = false;
    
    public static Connection getConexion(){
        status = false;
        String url = "jdbc:sqlserver://LAPTOP-OGRLTHO9:1433;databaseName=DB_Tienda";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch (ClassNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Conexion");
            alert.setHeaderText("No se pudo establece la conexion... revisar Driver" );
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            
            /*JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Driver" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);*/
        }
        try{
            contacto = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            status = true;
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Conexion");
            alert.setHeaderText("No se pudo establece la conexion... Ingrese Nuevamente los Datos");
            alert.setContentText( e.getMessage());
            alert.showAndWait();
             /*JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);*/
        }
        return contacto;
    }
    
    
    public static void setcuenta(String usuario, String password){
        Conexion.usuario = usuario;
        Conexion.password = password;
    }
    
    public static boolean getstatus(){
        return  status;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Coenxion");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("No se pudo realizar la consultar");
            alert.showAndWait();
            /*JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);*/
        }
        return null;
    }
    
}
