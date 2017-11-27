/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.TemperaturaEntity;
import javax.ejb.Stateless;



/**
 *
 * @author b.gamba10
 */
@Stateless
public class TemperaturaPersistence extends Persistencer<TemperaturaEntity, String>{

    public TemperaturaPersistence(){
        this.entityClass = TemperaturaEntity.class;
    }
}