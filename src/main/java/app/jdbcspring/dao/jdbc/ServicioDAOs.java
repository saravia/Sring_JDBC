/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcspring.dao.jdbc;

import app.jdbcspring.dao.ServicioDAO;
import app.jdbcspring.model.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Administrador
 */
public class ServicioDAOs extends JdbcDaoSupport implements ServicioDAO{
    private double costoHora;

    public List<Servicio> list() {
       
         String sql = "select * from servicio";

        List<Servicio> servicios = new ArrayList<Servicio>();

        List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);

        for (Map row : rows) {

            Servicio local = new Servicio();
            local.setId(Long.parseLong(String.valueOf(row.get("ID"))));
            
            local.setDescripcion((String) row.get("descripcion"));
           local.setCostoHora(costoHora);
            servicios.add(local);

        }
        return servicios;
    }

  public Servicio get(Servicio t) {
        String sql = "select * from servicio where id = ?";

       Servicio servicio = (Servicio) this.getJdbcTemplate().queryForObject(sql, new Object[]{t.getId()}, new ServicioRowMapper());
        return servicio;
    }

    public void save(Servicio t) {
         String sql = "insert into servicio ( descripcion, costo_hora) "
                + "values(?, ?);";

        try {

            this.getJdbcTemplate().update(sql, new Object[]{
              
                t.getDescripcion(),
               t.getCostoHora()
               
            });

        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    
    }

    public void update(Servicio t) {
        
   String sql = "update servicio set  descripcion=?, costo_hora=? "
                + " where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
              
                t.getDescripcion(),
                t.getCostoHora(),
                t.getId(),
               
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void delete(Servicio t) {
      
    this.getJdbcTemplate().update("delete from servicio where id=?",new Object[]{t.getId()});
    }

   
   

   
    
}
