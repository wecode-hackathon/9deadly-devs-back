package com.hackathon.bbvAforo.controller;

import com.hackathon.bbvAforo.repository.CapacidadActualRepository;
import com.hackathon.bbvAforo.service.CapacidadActualService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    private CapacidadActualService capacidadActualService;

    public CapacidadActualController (CapacidadActualService capacidadActualService){
        this.capacidadActualService = capacidadActualService;
    }

    @GetMapping("/obtenerCapacidadActual")
    public List<Oficina> obtenerCapacidadActual(
            @PathParam(value = "latitud") BigDecimal latitud,
            @PathParam(value = "longitud") BigDecimal longitud
    ) {
        return capacidadActualRepository.getCapacidadActual(latitud, longitud);
    }

    @GetMapping("/obtenerOficinas")
    public List<Oficina> getOficinas(@PathParam(value = "latUsuario") BigDecimal latUsuario, @PathParam(value = "longUsuario") BigDecimal longUsuario) {
        return capacidadActualService.getOficinas(latUsuario, longUsuario);
    }

    @GetMapping("/actualizarAforo")
    public Oficina getAforoServer(@PathParam(value = "idOficina") int idOficina){
         
        return capacidadActualService.getAforoServer(idOficina);
    }


}
