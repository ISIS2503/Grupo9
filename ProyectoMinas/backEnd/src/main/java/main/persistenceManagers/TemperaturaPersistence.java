/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.persistenceManagers;

import javax.ejb.Stateless;
import main.entities.TemperaturaEntity;
import main.persistence.Persistencer;

/**
 *
 * @author b.gamba10
 */
//@Stateless
public class TemperaturaPersistence extends Persistencer<TemperaturaEntity, String>{

    public TemperaturaPersistence(){
        this.entityClass = TemperaturaEntity.class;
    }
}