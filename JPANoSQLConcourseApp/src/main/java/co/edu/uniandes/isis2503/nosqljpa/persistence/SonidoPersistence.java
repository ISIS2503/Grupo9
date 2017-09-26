/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;



/**
 *
 * @author b.gamba10
 */
public class SonidoPersistence extends Persistencer<SonidoEntity, String>{

    public SonidoPersistence(){
        this.entityClass = SonidoEntity.class;
    }
}