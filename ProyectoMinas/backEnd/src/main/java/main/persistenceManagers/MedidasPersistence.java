/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.persistenceManagers;

import main.entities.MedidasEntity;
import main.persistence.Persistencer;

/**
 *
 * @author b.gamba10
 */
public class MedidasPersistence extends Persistencer<MedidasEntity, String>{

    public MedidasPersistence(){
        this.entityClass = MedidasEntity.class;
    }
}