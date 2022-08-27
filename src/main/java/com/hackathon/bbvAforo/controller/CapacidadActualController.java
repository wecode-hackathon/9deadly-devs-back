package com.hackathon.bbvAforo.controller;

import com.hackathon.bbvAforo.repository.CapacidadActualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bbvAforo.dto.Oficina;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController
public class CapacidadActualController {

    @Autowired
    private CapacidadActualRepository capacidadActualRepository;

    @GetMapping("/obtenerCapacidadActual")
    public List<Oficina> obtenerCapacidadActual(
            @PathParam(value = "latitud") BigDecimal latitud,
            @PathParam(value = "longitud") BigDecimal longitud
    ) {

        return capacidadActualRepository.getNumber();
    }

    @GetMapping("/obtenerOficinas")
    public List<Oficina> getOficinas(@PathParam(value = "latUsuario") BigDecimal latUsuario, @PathParam(value = "longUsuario") BigDecimal longUsuario) {
        ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
        return oficinas;
    }
}
