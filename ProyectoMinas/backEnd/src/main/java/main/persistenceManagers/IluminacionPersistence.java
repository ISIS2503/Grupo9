/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.persistenceManagers;

import javax.ejb.Stateless;
import main.entities.IluminacionEntity;
import main.persistence.Persistencer;

/**
 *
 * @author b.gamba10
 */
//@Stateless
public class IluminacionPersistence extends Persistencer<IluminacionEntity, String>{

    public IluminacionPersistence(){
        this.entityClass = IluminacionEntity.class;
    }
}