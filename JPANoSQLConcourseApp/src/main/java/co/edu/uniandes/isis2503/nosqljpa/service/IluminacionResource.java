/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.logic.IluminacionLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.IluminacionDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.IluminacionEntity;
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
@Path("/iluminacion")
@Secured({Role.Admin})
public class IluminacionResource {
    private IluminacionLogic iluminacionLogic; 
    public IluminacionResource()
    {
     this.iluminacionLogic = new IluminacionLogic();   
    }
    
     
     
     private List<IluminacionDTO> listEntity2DTO(List<IluminacionEntity> entityList){
        List<IluminacionDTO> list = new ArrayList<>();
        for (IluminacionEntity entity : entityList) {
            list.add(new IluminacionDTO(entity));
        }
        return list;
    }
     
    @GET
    public List<IluminacionDTO> getIluminacion() {
        
        return listEntity2DTO(iluminacionLogic.getIluminaciones());
    }  
    
    @POST
    public IluminacionDTO createIluminacion(IluminacionDTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new IluminacionDTO(iluminacionLogic.createIluminacion(dto.toEntity()));
    }
    
    
    
     
}
