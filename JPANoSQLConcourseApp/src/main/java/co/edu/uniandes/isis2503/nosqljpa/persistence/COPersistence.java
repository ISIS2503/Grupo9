/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.persistence;

import main.entities.COEntity;
import main.persistence.Persistencer;

/**
 *
 * @author b.gamba10
 */
public class COPersistence extends Persistencer<COEntity, String>{

    public COPersistence(){
        this.entityClass = COEntity.class;
    }
}
