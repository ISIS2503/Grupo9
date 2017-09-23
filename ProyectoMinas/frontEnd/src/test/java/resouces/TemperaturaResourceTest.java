/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;

import dtos.TemperaturaDTO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b.gamba10
 */
public class TemperaturaResourceTest {
    
    public TemperaturaResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTemperatura method, of class TemperaturaResource.
     */
    @Test
    public void testGetTemperatura() {
        System.out.println("getTemperatura");
        TemperaturaResource instance = new TemperaturaResource();
        List<TemperaturaDTO> expResult = null;
        List<TemperaturaDTO> result = instance.getTemperatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTemperatura method, of class TemperaturaResource.
     */
    @Test
    public void testCreateTemperatura() {
        System.out.println("createTemperatura");
        TemperaturaDTO dto = null;
        TemperaturaResource instance = new TemperaturaResource();
        TemperaturaDTO expResult = null;
        TemperaturaDTO result = instance.createTemperatura(dto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
