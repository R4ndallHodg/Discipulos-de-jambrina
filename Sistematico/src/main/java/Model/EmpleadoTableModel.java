/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Empleado;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DewinU
 */
public class EmpleadoTableModel extends AbstractTableModel{
    
    private List<String> columnNames;
    private List<Empleado> data;

    public EmpleadoTableModel() {
        super();
        columnNames = new ArrayList<>();
        data = new ArrayList<>();
    }

    
    public EmpleadoTableModel(List<String> columnNames, List<Empleado> data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.isEmpty() || rowIndex < 0 || rowIndex >= data.size()) {
            return null;
        }
        
        else{
            List<String> empleado = data.get(rowIndex).toList();
            if (columnIndex < 0 || columnIndex >= empleado.size()){
                return null;
            }
            else{
                return empleado.get(columnIndex);
            }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
    
    
    public int addRow() {
        return addRow(new Empleado());
    }

    public int addRow(Empleado row) {
        data.add(row);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
        return data.size() - 1;
    }

    public void deleteRow(int row) {
        if (row < 0) {
            return;
        }
        data.remove(row);
        fireTableRowsDeleted(row, row);   
    }
    
    public void loadFromJson() throws FileNotFoundException {
        Gson gson = new Gson();
        data.addAll(Arrays.asList(gson.fromJson(new FileReader(getClass().
                    getResource("/Data/data.json").getPath()), Empleado[].class)));
        String[] names = {"N° Empleado", "Nombres", "Apellidos", "Cedula", "Direccion", "Telefono", "Correo"};
        columnNames = Arrays.asList(names);
    }

    public void updateData(List<Empleado>data) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        FileWriter w =  new FileWriter(("./src/main/resources/data/Data.json"));
        w.write(gson.toJson(data));
        w.close();
    }
    
}
