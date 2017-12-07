/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.logic.ReporteLogic;
import javax.ws.rs.GET;
public class Reporte {
     public Reporte()
    {
        this.reporteLogic = new ReporteLogic();
    }
    
     private ReporteLogic reporteLogic; 
     
     
    @GET
    public String getReporte() {
        
        
        return ReporteLogic.getReporte();
    }
}
