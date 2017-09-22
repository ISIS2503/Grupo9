/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.COEntity;
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
public class COPersistence {
    
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
     * Nuevo COEntity
     *
     * @param entity la entidad que se desea agregar
     * @return la entidad que fue agregada
     */
    public COEntity create(COEntity entity)
    {
        em.persist(entity);
        return entity;
    }

    /**
     * modifica la información de un COEntity
     *
     * @param entity la entidad que se desea actualizar
     * @return la entidad que fue actualizada
     */
    public COEntity update(COEntity entity)
    {
        return em.merge(entity);
    }

    /**
     * Retorna una lista con todas las entidades (tuplas) de la tabla
     *
     * @return lista de COEntities
     */
    public List<COEntity> findAll()
    {
        Query query = em.createQuery("select u from COEntity u");
        return query.getResultList();
    }

    /**
     * retorna un COEntity de acuerdo a un ID
     *
     * @param id el id de la entidad que se desea encontrar
     * @return null si no encuentra la entidad con el ID, la entidad si la
     * encuentra
     */
    public COEntity find(Long id)
    {
        COEntity entity = em.find(COEntity.class, id);
        return entity;
    }
    
    /**
     * Elimina una entidad (tupla) de la tabla a partir de su id
     *
     * @param id el id de la entidad que se desea eliminar.
     */
    public void delete(Long id)
    {
        COEntity entity = em.find(COEntity.class, id);
        em.remove(entity);
    }
}
