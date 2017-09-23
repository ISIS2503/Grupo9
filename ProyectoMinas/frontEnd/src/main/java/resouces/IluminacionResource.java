/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;
import dtos.IluminacionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import main.entities.IluminacionEntity;
import main.logic.IluminacionLogic;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/iluminacion")
public class IluminacionResource {
    
    public IluminacionResource()
    {
        
    }
    
     @Inject 
     private IluminacionLogic iluminacionLogic; 
     
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
        return new IluminacionDTO(iluminacionLogic.createIluminacion(dto.toEntity()));
    }
    
    
    
     
}
