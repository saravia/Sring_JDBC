/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcspring.test;

import app.jdbcspring.dao.ServicioDAO;
import app.jdbcspring.model.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class AppTest {
    private static double costoHora;
    private static long id;
     public static void main(String[] args) {
        // AppTest.saveLocal();
        AppTest.saveservicio();
        // AppTest.getLocal(new Local(13));
    }
   public static void saveservicio() {
      ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
      ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setDescripcion("Almuerzo campestre");
        servicio.setCostoHora(costoHora);
        servicio.setId(id);
        servicioDAO.save(servicio);
    }
        
    }

    
     

