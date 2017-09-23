/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;
import dtos.TemperaturaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import main.entities.TemperaturaEntity;
import main.logic.TemperaturaLogic;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/temperatura")
public class TemperaturaResource {
    
    public TemperaturaResource()
    {
        
    }
    
     @Inject 
     private TemperaturaLogic temperaturaLogic; 
     
     private List<TemperaturaDTO> listEntity2DTO(List<TemperaturaEntity> entityList){
        List<TemperaturaDTO> list = new ArrayList<>();
        for (TemperaturaEntity entity : entityList) {
            list.add(new TemperaturaDTO(entity));
        }
        return list;
    }
     
    @GET
    public List<TemperaturaDTO> getTemperatura() {
        
        return listEntity2DTO(temperaturaLogic.getTemperaturas());
    }  
    
    @POST
    public TemperaturaDTO createTemperatura(TemperaturaDTO dto){
        return new TemperaturaDTO(temperaturaLogic.createTemperaturas(dto.toEntity()));
    }
    
    
    
     
}
