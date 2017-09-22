/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;


import main.entities.SonidoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author b.gamba10
 */
@Stateless
public class SonidoPersistence {
    
    //----------------------------------------------------------------------------------------------------
    // ATRIBUTOS
    //----------------------------------------------------------------------------------------------------
    /**
     * Entity manager de la persistencia
     */
    @PersistenceContext(unitName = "nombreBD")
    protected EntityManager em;

    //----------------------------------------------------------------------------------------------------
    // METODOS
    //----------------------------------------------------------------------------------------------------
    /**
     * Nuevo SonidoEntity
     *
     * @param entity la entidad que se desea agregar
     * @return la entidad que fue agregada
     */
    public SonidoEntity create(SonidoEntity entity)
    {
        em.persist(entity);
        return entity;
    }

    /**
     * modifica la información de un SonidoEntity
     *
     * @param entity la entidad que se desea actualizar
     * @return la entidad que fue actualizada
     */
    public SonidoEntity update(SonidoEntity entity)
    {
        return em.merge(entity);
    }

    /**
     * Retorna una lista con todas las entidades (tuplas) de la tabla
     *
     * @return lista de SonidoEntities
     */
    public List<SonidoEntity> findAll()
    {
        Query query = em.createQuery("select u from SonidoEntity u");
        return query.getResultList();
    }

    /**
     * retorna un SonidoEntity de acuerdo a un ID
     *
     * @param id el id de la entidad que se desea encontrar
     * @return null si no encuentra la entidad con el ID, la entidad si la
     * encuentra
     */
    public SonidoEntity find(Long id)
    {
        SonidoEntity entity = em.find(SonidoEntity.class, id);
        return entity;
    }
    
    /**
     * Elimina una entidad (tupla) de la tabla a partir de su id
     *
     * @param id el id de la entidad que se desea eliminar.
     */
    public void delete(Long id)
    {
        SonidoEntity entity = em.find(SonidoEntity.class, id);
        em.remove(entity);
    }
}
