package com.hackathon.bbvAforo.repository.RowMapper;

import org.springframework.jdbc.core.RowMapper;

import com.hackathon.bbvAforo.dto.Oficina;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OficinaRowMapper implements RowMapper<Oficina> {

    @Override
    public Oficina mapRow(ResultSet rs, int rowNum) throws SQLException {

        Oficina oficina = new Oficina();
        oficina.setId(rs.getInt("id"));
        oficina.setNombre(rs.getString("nombre"));
        oficina.setLatOficina(rs.getBigDecimal("latitud"));
        oficina.setLongOficina(rs.getBigDecimal("longitud"));

        return oficina;

    }
}