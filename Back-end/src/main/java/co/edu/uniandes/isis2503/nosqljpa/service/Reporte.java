/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.logic.ReporteLogic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/reporte")
public class Reporte {
     public Reporte()
    {
        this.reporteLogic = new ReporteLogic();
    }
    
     private ReporteLogic reporteLogic; 
     
     
    @GET
    public String getReporte() {
        
        
        return reporteLogic.getReport();
    }
}
