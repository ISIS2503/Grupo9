/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.PaginaTemperaturaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.TemperaturaEntity;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.core.Response;



/**
 *
 * @author b.gamba10
 */
@Stateless
public class TemperaturaPersistence extends Persistencer<TemperaturaEntity, String>{

    public TemperaturaPersistence(){
        this.entityClass = TemperaturaEntity.class;
    }
    
    public Response getAllPage(Integer page, Integer maxRecords) {
 
        PaginaTemperaturaDTO competitors = null;
        entityManager = emf.createEntityManager();
        int status = 200;
        try{
            entityManager.getTransaction().begin();
            Query count = entityManager.createQuery("select count(u) from CompetitorEntity u");
            Long regCount = 0L;
            regCount = Long.parseLong(count.getSingleResult().toString());
            Query query = entityManager.createQuery("select u from CompetitorEntity u");
            if(page != null && maxRecords != null){
                query.setFirstResult((page-1)*maxRecords);
                query.setMaxResults(maxRecords);
            }
            competitors = new PaginaTemperaturaDTO();
            competitors.setTotalRecords(regCount);
            competitors.setCompetitors(query.getResultList());
            entityManager.getTransaction().commit();
 
 
        }catch(Exception e){
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
            e.printStackTrace();
        }finally {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(competitors).build();
    }
}