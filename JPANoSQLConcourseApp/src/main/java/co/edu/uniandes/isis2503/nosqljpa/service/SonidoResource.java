/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.logic.SonidoLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SonidoDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/sonido")
public class SonidoResource {
    
    public SonidoResource()
    {
        this.temperaturaLogic = new SonidoLogic();
    }
    
     private SonidoLogic temperaturaLogic; 
     
     private List<SonidoDTO> listEntity2DTO(List<SonidoEntity> entityList){
        List<SonidoDTO> list = new ArrayList<>();
        for (SonidoEntity entity : entityList) {
            list.add(new SonidoDTO(entity));
        }
        return list;
    }
     
    @GET
    public List<SonidoDTO> getSonido() {
        
        return listEntity2DTO(temperaturaLogic.getSonidos());
    }  
    
    @POST
    public SonidoDTO createSonido(SonidoDTO dto){
        return new SonidoDTO(temperaturaLogic.createSonidos(dto.toEntity()));
    }
    
    
    
     
}
