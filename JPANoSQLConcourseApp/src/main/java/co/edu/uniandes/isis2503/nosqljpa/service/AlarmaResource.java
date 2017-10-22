/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.logic.AlarmaLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.AlarmaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.AlarmaEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/co")
public class AlarmaResource {
    
    private AlarmaLogic coLogic;  
    
    public AlarmaResource()
    {
        this.coLogic = new AlarmaLogic();  
    }
     
     private List<AlarmaDTO> listEntity2DTO(List<AlarmaEntity> entityList){
        List<AlarmaDTO> list = new ArrayList<>();
        for (AlarmaEntity entity : entityList) {
            list.add(new AlarmaDTO(entity));
        }
        return list;
    }
     
    @GET
    public List<AlarmaDTO> getAlarma() {
        
        return listEntity2DTO(coLogic.getAlarmas());
    }  
    
    @POST
    public AlarmaDTO createAlarma(AlarmaDTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new AlarmaDTO(coLogic.createAlarma(dto.toEntity()));
    }
    
    
    
     
}
