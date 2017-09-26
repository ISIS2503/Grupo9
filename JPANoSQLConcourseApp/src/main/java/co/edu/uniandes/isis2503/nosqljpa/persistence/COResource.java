/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;
import dtos.CODTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import main.entities.COEntity;
import main.logic.COLogic;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/co")
public class COResource {
    
    public COResource()
    {
        
    }
    
     @Inject 
     private COLogic coLogic; 
     
     private List<CODTO> listEntity2DTO(List<COEntity> entityList){
        List<CODTO> list = new ArrayList<>();
        for (COEntity entity : entityList) {
            list.add(new CODTO(entity));
        }
        return list;
    }
     
    @GET
    public List<CODTO> getCO() {
        
        return listEntity2DTO(coLogic.getCOs());
    }  
    
    @POST
    public CODTO createCO(CODTO dto){
        return new CODTO(coLogic.createCO(dto.toEntity()));
    }
    
    
    
     
}
