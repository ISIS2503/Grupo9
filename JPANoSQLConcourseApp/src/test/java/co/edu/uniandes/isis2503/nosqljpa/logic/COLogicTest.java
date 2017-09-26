package co.edu.uniandes.isis2503.nosqljpa.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import co.edu.uniandes.isis2503.nosqljpa.model.entity.COEntity;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;


/**
 *
 * @author n.acevedos
 */

public class COLogicTest extends TestCase{
    
   
    private COLogic coLogic;
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
        coLogic = new COLogic(); 
        COEntity entity = new COEntity(); 
        
        fecha = new Date(); 
        ubicacion = ("La casa de bibi"); 
        valor = 223; 
        
        entity.setFecha(fecha);
        entity.setUnidad("ppm");
        entity.setUbicacion(ubicacion);
        entity.setValor(valor);
        
        coLogic.createCO(entity);
    }
    
     protected void setUp1()
    {
        coLogic = new COLogic(); 
        COEntity entity = new COEntity(); 
        
        fecha = new Date(); 
        ubicacion = ("La casa de juan"); 
        valor = 16; 
        entity.setFecha(fecha);
        entity.setUnidad("ppm");
        entity.setUbicacion(ubicacion);
        entity.setValor(valor);
        
        COEntity entity1 = new COEntity(); 
        
        fecha = new Date(); 
        ubicacion = ("La casa de bibi"); 
        valor = 23; 
        entity1.setFecha(fecha);
        entity1.setUnidad("ppm");
        entity1.setUbicacion(ubicacion);
        entity1.setValor(valor);
        
        coLogic.createCO(entity);
        coLogic.createCO(entity1);
    }
   
     public void testCrearYGetCOLogic()
     {
         setUp();
         int numero = coLogic.getCOs().size();
         assertEquals("Debe haber una entidad", 1, numero); 
     }
     
     public void testCrearYGetCOLogic2()
     {
         setUp1();
         int numero = coLogic.getCOs().size();
         assertEquals("Debe haber dos entidades", 2, numero); 
     }
}
    
    