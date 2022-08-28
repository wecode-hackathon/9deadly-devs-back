package com.hackathon.bbvAforo.repository;

import com.hackathon.bbvAforo.dto.Oficina;
import com.hackathon.bbvAforo.dto.OficinaAforo;
import com.hackathon.bbvAforo.repository.RowMapper.OficinaRowMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;  


import java.math.BigDecimal;
import java.util.List;

@Repository
public class CapacidadActualRepository {

    private static Logger LOG = LoggerFactory.getLogger(CapacidadActualRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public CapacidadActualRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Oficina getCapacidadActual(
            final int id
    ) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM oficinas WHERE id = ?",
                new Object[] { id },
                (rs, rowNum) -> {
                    Oficina oficina = new Oficina();
                    oficina.setId(rs.getInt("id"));
                    oficina.setNombre(rs.getString("nombre"));
                    oficina.setestado(1);
                    oficina.setAforoActual(rs.getInt("aforoactual"));
                    oficina.setEsperaPlataforma(15);
                    oficina.setEsperaVentanilla(5);
                    return oficina;
                });
    }

    public Oficina getAforoServer(int idOficina){
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM oficinas where idOficina = ?",
                new Object[] { idOficina },
                new OficinaRowMapper());

    }

    public List<Oficina> getOficinas(BigDecimal latitud, BigDecimal longitud) {
        
        BigDecimal latProcesada1 = latitud;
        BigDecimal latProcesada2 = latitud;
    
        BigDecimal longProcesada1 = longitud;
        BigDecimal longProcesada2 = longitud;
    
        BigDecimal diff = new BigDecimal(0.01);
    
        latProcesada1 = latProcesada1.subtract(diff);
        latProcesada2 = latProcesada2.subtract(diff);
    
        longProcesada1 = longProcesada1.subtract(diff);
        longProcesada2 = longProcesada2.subtract(diff);

        return this.jdbcTemplate.query(
                "SELECT * FROM oficinas where latitud between(?) and (?) and longitud between (?) and (?);",
                new Object[] { latProcesada1, latProcesada2, longProcesada1, longProcesada2 },
                (rs, rowNum) -> {
                    Oficina oficina = new Oficina();
                    oficina.setAforoActual(rs.getInt("aforoactual"));
                    oficina.setNombre(rs.getString("nombre"));
                    oficina.setDireccion(rs.getString("direccion"));
                    oficina.setLatOficina(rs.getBigDecimal("latitud"));
                    oficina.setLongOficina(rs.getBigDecimal("longitud"));

                    return oficina;
                });
    }

    public int setAforoOficina(OficinaAforo oficinaAforo){

        return this.jdbcTemplate.update(
            "UPDATE * FROM oficinas SET aforoactual = ?, numclientes = ?, numnoclientes = ?, numexterno WHERE id = ?",
            new Object[] { oficinaAforo.getCantClientes(), oficinaAforo.getId() }
            );
    }
}