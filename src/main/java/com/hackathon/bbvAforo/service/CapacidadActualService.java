package com.hackathon.bbvAforo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathon.bbvAforo.dto.Oficina;
import com.hackathon.bbvAforo.repository.CapacidadActualRepository;

@Service
public class CapacidadActualService {

    private CapacidadActualRepository capacidadActualRepository;

    public CapacidadActualService(CapacidadActualRepository capacidadActualRepository ){
        this.capacidadActualRepository = capacidadActualRepository;
    }

    public List<Oficina> getOficinas(BigDecimal latitud, BigDecimal longitud) {
        return capacidadActualRepository.getOficinas(latitud, longitud);
    }

    public Oficina getAforoServer(int idOficina){
        return capacidadActualRepository.getAforoServer(idOficina);
    }

    
}
