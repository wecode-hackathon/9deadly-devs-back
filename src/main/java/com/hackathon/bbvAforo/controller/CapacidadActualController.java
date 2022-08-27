package com.hackathon.bbvAforo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bbvAforo.dto.Oficina;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

import javax.websocket.server.PathParam;

@RestController
public class CapacidadActualController {

    @GetMapping("/obtenerCapacidadActual")
    public int greeting(@PathParam(value = "idOficina") int idOficina) {
        return 1;
    }

    @GetMapping("/obtenerOficinas")
    public ArrayList<Oficina> getOficinas(@PathParam(value = "latUsuario") BigDecimal latUsuario, @PathParam(value = "longUsuario") BigDecimal longUsuario) throws SQLException {
        ArrayList<Oficina> oficinas = new ArrayList<Oficina>();

        String url = "192.168.160.148:3306";
        Connection conn = DriverManager.getConnection(url,"grupo4","clark");


        BigDecimal latProcesada1 = latUsuario;
        BigDecimal latProcesada2 = latUsuario;

        BigDecimal longProcesada1 = longUsuario;
        BigDecimal longProcesada2 = longUsuario;

        BigDecimal diff = new BigDecimal(0.01);

        latProcesada1 = latProcesada1.subtract(diff);
        latProcesada2 = latProcesada2.subtract(diff);

        longProcesada1 = longProcesada1.subtract(diff);
        longProcesada2 = longProcesada2.subtract(diff);
        
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM oficinas where latitud between("+ latProcesada1 +") and ("+ latProcesada2 +") and longitud between ("+ longProcesada1 +") and ("+ longProcesada2 +");";
        

        ResultSet rs = stmt.executeQuery(query);

        

        return oficinas;
    }
}
