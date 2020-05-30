package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class mainFrame {
    @FXML
    ComboBox<String> funciones;

    @FXML
    private TextField salaTxt;

    @FXML
    private ChoiceBox<String> asientosCh;

    @FXML
    private TextField cantidadTxt;

    @FXML
    public void movieSelection(ActionEvent e) {

        String tanda = funciones.getValue();

        if((tanda.equals("Funcion 10:00 AM - 11:30 PM")) || (tanda.equals("Funcion 3:00 AM - 4:30 PM"))) {
            salaTxt.setText("Sala A");
        } else if (tanda.equals("Funcion 11:30 AM - 1:30 PM")) {
            salaTxt.setText("Sala F");
        } else if ((tanda.equals("Funcion 1:30 AM - 3:00 PM")) || (tanda.equals("Funcion 4:30 AM - 6:00 PM"))) {
            salaTxt.setText("Sala B");
        } else {
            salaTxt.setText("Sala D");
        }

        int lastRow = 'A' + 7;
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= 12; seatNum++) {
                asientosCh.getItems().add(row + String.format("%02d", seatNum));
            }
        }
    }

}
