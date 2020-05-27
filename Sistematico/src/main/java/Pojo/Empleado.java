/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DewinU
 */
public class Empleado {
    private int id;
    private int carnet;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String cedula;
    private double salariob;
    private int antiguedad;
    private int hrsExtra;
    private double ingresoHrsExtra;
    private double ingresoAntiguedad;
    private double ingresoTotal;
    private double inssLaboral;
    private double ir;
    private double totalDeducciones;
    private double salarioNeto;
    private double inssPatronal;
    private double inatec;
    private double vac13mes;       
    private String ruta_foto;

    public Empleado() {
    }
    
    
    public Empleado(int id, String nombres, String apellidos, String direccion, String telefono, String cedula) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cedula = cedula;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSalariob() {
        return salariob;
    }

    public void setSalariob(double salariob) {
        this.salariob = salariob;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getHrsExtra() {
        return hrsExtra;
    }

    public void setHrsExtra(int hrsExtra) {
        this.hrsExtra = hrsExtra;
    }

    public double getIngresoHrsExtra() {
        return ((this.salariob/240) * 2 * this.hrsExtra);
    }

    public void setIngresoHrsExtra(double ingresoHrsExtra) {
        this.ingresoHrsExtra = ingresoHrsExtra;
    }

    public double getIngresoAntiguedad() {
        switch(this.antiguedad){
            case 1:
                return this.salariob * 0.03;
            case 2:
                return this.salariob * 0.05;
            case 3:
                return this.salariob * 0.07;
            case 4:
                return this.salariob * 0.09;
            case 5:
                return this.salariob * 0.1;
            case 6:
                return this.salariob * 0.11;
            case 7:
                return this.salariob * 0.12;
            case 8:
                return this.salariob * 0.13;
            case 9:
                return this.salariob * 0.14;
            case 10:
                return this.salariob * 0.15;
            case 11:
                return this.salariob * 0.1550;
            case 12:
                return this.salariob * 0.16;
            case 13:
                return this.salariob * 0.1650;
            case 14:
                return this.salariob * 0.17;
            case 15:
                return this.salariob * 0.1750;
            case 16:
                return this.salariob * 0.18;
            case 17:
                return this.salariob * 0.1850;
            case 18:
                return this.salariob * 0.19;
            case 19:
                return this.salariob * 0.1950;
            case 20:
                return this.salariob * 0.2;
            default:
                return 0;     
        }
    }

    public void setIngresoAntiguedad(double ingresoAntiguedad) {
        this.ingresoAntiguedad = ingresoAntiguedad;
    }

    public double getIngresoTotal() {
        return this.salariob + this.getIngresoHrsExtra() + this.getIngresoAntiguedad();
    }

    public void setIngresoTotal(double ingresoTotal) {
        this.ingresoTotal = ingresoTotal;
    }

    public double getInssLaboral() {
        return this.getIngresoTotal() * 0.07;
    }

    public void setInssLaboral(double inssLaboral) {
        this.inssLaboral = inssLaboral;
    }

    public double getIr() {
        double salarioAnual = (this.getIngresoTotal() - this.getInssLaboral()) * 12;
        if(salarioAnual > 100000 && salarioAnual <= 200000 ){
            return ((salarioAnual - 100000) * 0.15 / 12);
        }
        else if(salarioAnual > 200000 && salarioAnual <= 300000){
            return ((((salarioAnual - 200000) * 0.2) + 15000)/12);
            
        }
        else if(salarioAnual > 300000 && salarioAnual <= 500000){
            return ((((salarioAnual - 350000) * 0.25) + 45000)/12);
            
        }
        else if(salarioAnual > 500000){
            return ((((salarioAnual - 500000) * 0.3) + 82000)/12);
            
        }
        else{
            return 0;   
        }
    }

    public void setIr(double ir) {
        this.ir = ir;
    }

    public double getTotalDeducciones() {
        return this.getInssLaboral() + this.getIr();
    }

    public void setTotalDeducciones(double totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public double getSalarioNeto() {
        return this.getIngresoTotal() - this.getTotalDeducciones();
    }

    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public double getInssPatronal() {
        return this.getIngresoTotal() * 0.225;
    }

    public void setInssPatronal(double inssPatronal) {
        this.inssPatronal = inssPatronal;
    }

    public double getInatec() {
        return this.getIngresoTotal() * 0.02;
    }

    public void setInatec(double inatec) {
        this.inatec = inatec;
    }

    public double getVac13mes() {
        return this.salariob * (double)1/12; 
    }

    public void setVac13mes(double vac13mes) {
        this.vac13mes = vac13mes;
    }

    public String getRuta_foto() {
        return ruta_foto;
    }

    public void setRuta_foto(String ruta_foto) {
        this.ruta_foto = ruta_foto;
    }
    
    public List<String> toList(){
        List<String> empleado = new ArrayList<>();

        empleado.add(String.valueOf(id));
        empleado.add(nombres);
        empleado.add(apellidos);
        empleado.add(cedula);
        empleado.add(direccion);
        empleado.add(telefono);
        empleado.add(cedula);
        return empleado;
    }
    
    
    
}
