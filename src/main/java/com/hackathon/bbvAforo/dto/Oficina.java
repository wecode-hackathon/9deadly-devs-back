package com.hackathon.bbvAforo.dto;

import java.math.BigDecimal;

public class Oficina {
    private int id;
    private String nombre;
    private String direccion;
    private int idEstado;
    private int idProvincia;
    private int idPais;
    private int aforoTotal;
    private int aforoActual;
    private int estado;
    private int esperaPlataforma;
    private int esperaVentanilla;
    private BigDecimal latOficina;
    private BigDecimal longOficina;

    public Oficina() {
    }

    public Oficina(int id, String nombre, String direccion, int idEstado, int idProvincia, int idPais, int aforoTotal, int aforoActual, BigDecimal latOficina, BigDecimal longOficina) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idEstado = idEstado;
        this.idProvincia = idProvincia;
        this.idPais = idPais;
        this.aforoTotal = aforoTotal;
        this.aforoActual = aforoActual;
        this.latOficina = latOficina;
        this.longOficina = longOficina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getAforoTotal() {
        return aforoTotal;
    }

    public void setAforoTotal(int aforoTotal) {
        this.aforoTotal = aforoTotal;
    }

    public int getAforoActual() {
        return aforoActual;
    }

    public void setAforoActual(int aforoActual) {
        this.aforoActual = aforoActual;
    }

    public BigDecimal getLatOficina() {
        return latOficina;
    }

    public void setLatOficina(BigDecimal latOficina) {
        this.latOficina = latOficina;
    }

    public BigDecimal getLongOficina() {
        return longOficina;
    }

    public void setLongOficina(BigDecimal longOficina) {
        this.longOficina = longOficina;
    }

    public int getestado() {
        return estado;
    }

    public void setestado(int estado) {
        this.estado = estado;
    }

    public int getEsperaVentanilla() {
        return esperaVentanilla;
    }

    public void setEsperaVentanilla(int esperaVentanilla) {
        this.esperaVentanilla = esperaVentanilla;
    }

    public int getEsperaPlataforma() {
        return esperaPlataforma;
    }

    public void setEsperaPlataforma(int esperaPlataforma) {
        this.esperaPlataforma = esperaPlataforma;
    }
}
