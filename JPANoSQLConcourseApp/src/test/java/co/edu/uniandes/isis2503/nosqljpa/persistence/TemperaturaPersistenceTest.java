package co.edu.uniandes.isis2503.nosqljpa.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import co.edu.uniandes.isis2503.nosqljpa.model.entity.TemperaturaEntity;
import java.util.Date;
import junit.framework.TestCase;


/**
 *
 * @author n.acevedos
 */

public class TemperaturaPersistenceTest extends TestCase{
    
   
    private TemperaturaPersistence temperaturaPersistence;
    private Date fecha; 
    private String ubicacion; 
    private int valor; 

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    protected void setUp()
    {
        temperaturaPersistence = new TemperaturaPersistence(); 
        TemperaturaEntity entity = new TemperaturaEntity(); 
        
        fecha = new Date(); 
        ubicacion = ("La casa de bibi"); 
        valor = 23; 
        
        entity.setFecha(fecha);
        entity.setUnidad("C");
        entity.setUbicacion(ubicacion);
        entity.setValor(valor);
        
        temperaturaPersistence.add(entity);
    }
    
     protected void setUp1()
    {
        temperaturaPersistence = new TemperaturaPersistence(); 
        TemperaturaEntity entity = new TemperaturaEntity(); 
        
        fecha = new Date(); 
        ubicacion = ("La casa de juan"); 
        valor = 16; 
        entity.setFecha(fecha);
        entity.setUnidad("C");
        entity.setUbicacion(ubicacion);
        entity.setValor(valor);
        
        TemperaturaEntity entity1 = new TemperaturaEntity(); 
        
        fecha = new Date(); 
        ubicacion = ("La casa de bibi"); 
        valor = 23; 
        entity1.setFecha(fecha);
        entity1.setUnidad("C");
        entity1.setUbicacion(ubicacion);
        entity1.setValor(valor);
        
        temperaturaPersistence.add(entity);
        temperaturaPersistence.add(entity1);
    }
   
     public void testCrearYGetTemperaturaPersistence()
     {
         setUp();
         int numero = temperaturaPersistence.all().size();
         assertEquals("Debe haber una entidad", 1, numero); 
     }
     
     public void testCrearYGetTemperaturaPersistence2()
     {
         setUp1();
         int numero = temperaturaPersistence.all().size();
         assertEquals("Debe haber dos entidades", 2, numero); 
     }
}
    
    