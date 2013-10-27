package app.jdbcspring.dao.jdbc;

import app.jdbcspring.model.Servicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ServicioRowMapper implements RowMapper<Servicio> {
     
      public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
       Servicio local = new Servicio();
        local.setId(rs.getLong(1));
        local.setCostoHora(rowNum);
        local.setDescripcion(rs.getString(3));
  

        return local;
    }
}
