package com.hackathon.bbvAforo.dto;


public class OficinaAforo {

    private int id;
    private int cantPersonas;
    private int cantPersonal;
    private int cantNoPersonal;
    private int cantClientes;
    private int cantNoClientes;
    private int cantPlataforma;
    private int cantVentanilla;
    private int cantExternos;
    

    public OficinaAforo(){

    }

    public OficinaAforo(int id, int cantPersonas, int cantPersonal, int cantNoPersonal, int cantClientes, int cantNoClientes, int cantPlataforma, int cantVentanilla, int cantExternos){
        this.id = id;
        this.cantPersonas = cantPersonas;
        this.cantPersonal = cantPersonal;
        this.cantNoPersonal = cantNoPersonal;
        this.cantClientes = cantClientes;
        this.cantNoClientes = cantNoClientes;
        this.cantPlataforma = cantPlataforma;
        this.cantVentanilla = cantVentanilla;
        this.cantExternos = cantExternos;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        
    public int getcantPersonal() {
        return cantPersonal;
    }

    public void setcantPersonal(int cantPersonal) {
        this.cantPersonal = cantPersonal;
    }

    public int getcantPersonas() {
        return cantPersonas;
    }

    public void setcantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getcantNoPersonal() {
        return cantNoPersonal;
    }

    public void setcantNoPersonal(int cantNoPersonal) {
        this.cantNoPersonal = cantNoPersonal;
    }

        
    public int getCantClientes() {
        return cantClientes;
    }

    public void setCantClientes(int cantClientes) {
        this.cantClientes = cantClientes;
    }

            
    public int getcantNoClientes() {
        return cantNoClientes;
    }

    public void setcantNoClientes(int cantNoClientes) {
        this.cantNoClientes = cantNoClientes;
    }

    public int getcantPlataforma() {
        return cantPlataforma;
    }

    public void setcantPlataforma(int cantPlataforma) {
        this.cantPlataforma = cantPlataforma;
    }

            
    public int getcantVentanilla() {
        return cantVentanilla;
    }

    public void setcantVentanilla(int cantVentanilla) {
        this.cantVentanilla = cantVentanilla;
    }

    public int getcantExternos() {
        return cantExternos;
    }

    public void setcantExternos(int cantExternos) {
        this.cantExternos = cantExternos;
    }

    

}
