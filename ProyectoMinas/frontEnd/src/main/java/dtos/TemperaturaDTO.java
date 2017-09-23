/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import main.entities.IluminacionEntity;
import main.entities.TemperaturaEntity;



@XmlRootElement
public class TemperaturaDTO {

    public TemperaturaDTO (){
    }
    
    private String ubicacion;
    
    private int valor;
    
    private String unidad;
    
    private Date fecha; 
    
    public TemperaturaDTO(TemperaturaEntity entity){
        if(entity != null)
        {
            this.ubicacion = entity.getUbicacion();
            this.valor = entity.getValor();
            this.fecha = entity.getFecha();
            this.unidad = entity.getUnidad();
        }
        
    }
    public TemperaturaEntity toEntity(){
       TemperaturaEntity entity = new TemperaturaEntity();
       entity.setUbicacion(this.ubicacion);
       entity.setValor(this.valor);
       entity.setFecha(this.fecha);
       entity.setUnidad(this.unidad);
       return entity;
    }


    public String getUbicacion() {
        return ubicacion;
    }

    public int getValor() {
        return valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}