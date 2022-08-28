package com.hackathon.bbvAforo.controller;

import com.hackathon.bbvAforo.repository.CapacidadActualRepository;
import com.hackathon.bbvAforo.service.CapacidadActualService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bbvAforo.dto.Oficina;
import com.hackathon.bbvAforo.dto.OficinaAforo;

import java.math.BigDecimal;
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
    public Oficina obtenerCapacidadActual(
            @PathParam(value = "id") int id
    ) {
        return capacidadActualRepository.getCapacidadActual(id);
    }

    @GetMapping("/obtenerOficinas")
    public List<Oficina> getOficinas(@PathParam(value = "latUsuario") BigDecimal latUsuario, @PathParam(value = "longUsuario") BigDecimal longUsuario) {
        return capacidadActualService.getOficinas(latUsuario, longUsuario);
    }

    @GetMapping("/actualizarAforo")
    public Oficina getAforoServer(@PathParam(value = "idOficina") int idOficina){
         
        return capacidadActualService.getAforoServer(idOficina);
    }

    @PostMapping("/updateAforo")
    public ResponseEntity setAforoActual(@RequestBody OficinaAforo oficinaAforo){
        
        if(capacidadActualService.setAforoOficina(oficinaAforo) == 200)
        {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
