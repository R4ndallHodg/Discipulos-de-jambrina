/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

/**
 *
 * @author Yiin Anton
 */
public class ProductoTableModel {
    
    private int id;
    private int id_Proveedor;
    private String descripcion;
    private int stock;
    private float precio;

    public ProductoTableModel() {
    }

    
    
    public ProductoTableModel(int id, int id_Proveedor, String descripcion, int stock, float precio) {
        this.id = id;
        this.id_Proveedor = id_Proveedor;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(int id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
}
