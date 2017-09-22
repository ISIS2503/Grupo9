package logic;


import entities.COEntity;
import entities.MedidasEntity;
import entities.PresionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import persistence.MedidasPersistence;
import persistence.PresionPersistence;


/**
 *
 * @author n.acevedos
 */
@Stateless
public class PresionLogic {
    
    public PresionLogic()
            {
                
            }
    
    @Inject private PresionPersistence persistence;
    
    /**
     * Obtiene la lista de los registros de Usuario.
     *
     * @return Colección de objetos de UsuarioEntity.
     * 
     */
   
    public List<PresionEntity> getPresiones() {
        return persistence.findAll(); 
    }
    
    /**
     * Obtiene los datos de una instancia de Usuario a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de UsuarioEntity con los datos del Usuario consultado.
     * @throws co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException
     *
     */
    public PresionEntity getPresion(Long id) {
        PresionEntity ue= persistence.find(id);
         if (ue == null)
         {
             System.out.println("No existe un usuario con ese id"); 
         }
         return ue; 
    }
    
    /**
     * Se encarga de crear un Usuario en la base de datos.
     *
     * @param entity Objeto de UsuarioEntity con los datos nuevos
     * @return Objeto de UsuarioEntity con los datos nuevos y su ID.
     * @throws co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException
     * @generated
     */
    public MedidasEntity createPresion(PresionEntity entity) {
       
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Actualiza la información de una instancia de Usuario.
     *
     * @param entity Instancia de UsuarioEntity con los nuevos datos.
     * @return Instancia de UsuarioEntity con los datos actualizados.
     * 
     */
    // TODO: revisar las validaciones al momento de actualizar
    public MedidasEntity updatePresion(PresionEntity entity) {
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de Usuario de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     *
     */
    // TODO: revisar las validaciones al momento de borrar
    public void deletePresion(Long id){
       
        persistence.delete(id);
        
    }
    
    
    
}