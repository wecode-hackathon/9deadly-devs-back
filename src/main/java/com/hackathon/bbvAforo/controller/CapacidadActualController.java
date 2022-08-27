package com.hackathon.bbvAforo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class CapacidadActualController {
    @GetMapping("/obtenerCapacidadActual")
    public int greeting(@PathParam(value = "idOficina") int idOficina) {
        return 1;
    }
}
