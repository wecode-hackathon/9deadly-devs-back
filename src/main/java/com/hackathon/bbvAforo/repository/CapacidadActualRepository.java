package com.hackathon.bbvAforo.repository;

import com.hackathon.bbvAforo.dto.Oficina;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CapacidadActualRepository {

    private static Logger LOG = LoggerFactory.getLogger(CapacidadActualRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public CapacidadActualRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oficina> getCapacidadActual(
            final BigDecimal latitud,
            final BigDecimal longitud
    ) {
        return this.jdbcTemplate.query(
                "SELECT * FROM oficinas WHERE latitud = ? AND longitud = ?",
                new Object[] { latitud, longitud },
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
}