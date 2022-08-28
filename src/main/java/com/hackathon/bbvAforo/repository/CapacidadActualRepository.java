package com.hackathon.bbvAforo.repository;

import com.hackathon.bbvAforo.dto.Oficina;
import com.hackathon.bbvAforo.dto.OficinaAforo;
import com.hackathon.bbvAforo.repository.RowMapper.OficinaRowMapper;
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

    public Oficina getCapacidadActual(
            final int id
    ) {

        

        return this.jdbcTemplate.queryForObject(
                "select o.id, o.nombre, o.direccion, o.numventanillas, o.numplataformas, o.aforototal, o.aforoactual, o.colaexterna, aforo.clientes, aforo.noclientes, aforo.ventanilla, aforo.plataforma from oficinas as o left join aforooficina as aforo on o.id = aforo.idoficina where id = ?",
                new Object[] { id },
                (rs, rowNum) -> {
                    Oficina oficina = new Oficina();
                    oficina.setId(rs.getInt("id"));
                    oficina.setNombre(rs.getString("nombre"));
                    oficina.setestado(1);
                    oficina.setAforoActual(rs.getInt("aforoactual"));
                    oficina.setEsperaPlataforma(25);
                    oficina.setEsperaVentanilla(5);
                    return oficina;
                });
    }

    public Oficina getAforoServer(int idOficina) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM oficinas where idOficina = ?",
                new Object[]{idOficina},
                new OficinaRowMapper());

    }

    public List<Oficina> getOficinas(BigDecimal latitud, BigDecimal longitud) {

        BigDecimal latProcesada1 = latitud;
        BigDecimal latProcesada2 = latitud;

        BigDecimal longProcesada1 = longitud;
        BigDecimal longProcesada2 = longitud;

        BigDecimal diff = new BigDecimal(0.01);

        latProcesada1 = latProcesada1.subtract(diff);
        latProcesada2 = latProcesada2.add(diff);

        longProcesada1 = longProcesada1.subtract(diff);
        longProcesada2 = longProcesada2.add(diff);

        return this.jdbcTemplate.query(
                "SELECT * FROM oficinas where latitud between(?) and (?) and longitud between (?) and (?);",
                new Object[] { latProcesada1, latProcesada2, longProcesada1, longProcesada2 },
                (rs, rowNum) -> {
                    Oficina oficina = new Oficina();
                    oficina.setId(rs.getInt("id"));
                    oficina.setAforoActual(rs.getInt("aforoactual"));
                    oficina.setNombre(rs.getString("nombre"));
                    oficina.setDireccion(rs.getString("direccion"));
                    oficina.setLatOficina(rs.getBigDecimal("latitud"));
                    oficina.setLongOficina(rs.getBigDecimal("longitud"));

                    return oficina;
                }
        );
    }

    public int setAforoOficina(OficinaAforo oficinaAforo){
        this.jdbcTemplate.update(
            "UPDATE aforooficina SET clientes = ?, noclientes = ?, ventanilla = ?, plataforma = ? WHERE idoficina = ?",
            new Object[] { oficinaAforo.getCantClientes(),
                 oficinaAforo.getcantNoClientes(), 
                 oficinaAforo.getcantVentanilla(), 
                 oficinaAforo.getcantPlataforma(), oficinaAforo.getId() }
            );

        return this.jdbcTemplate.update("UPDATE oficinas SET aforoactual = ?, colaexterna = ? WHERE id = ?", new Object[] {
            (oficinaAforo.getcantPersonal() + oficinaAforo.getcantNoPersonal()), oficinaAforo.getcantExternos(), oficinaAforo.getId()
        });
    }
}