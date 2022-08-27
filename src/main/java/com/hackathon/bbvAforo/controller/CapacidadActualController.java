package com.hackathon.bbvAforo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bbvAforo.dto.Oficina;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController
public class CapacidadActualController {

    @GetMapping("/obtenerCapacidadActual")
    public int greeting(@PathParam(value = "idOficina") int idOficina) {
        return 1;
    }

    @GetMapping("/obtenerOficinas")
    public List<Oficina> getOficinas(@PathParam(value = "latUsuario") BigDecimal latUsuario, @PathParam(value = "longUsuario") BigDecimal longUsuario) {
        ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
        return oficinas;
    }
}
