package com.hackathon.bbvAforo.repository;

import com.hackathon.bbvAforo.dto.Oficina;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CapacidadActualRepository {

    private static Logger LOG = LoggerFactory.getLogger(CapacidadActualRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public CapacidadActualRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oficina> getNumber() {
        return this.jdbcTemplate.query("SELECT * FROM oficinas", (rs, rowNum) -> new Oficina());
    }
}