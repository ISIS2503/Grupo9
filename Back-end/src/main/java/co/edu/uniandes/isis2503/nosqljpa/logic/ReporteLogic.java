package co.edu.uniandes.isis2503.nosqljpa.logic;




import co.edu.uniandes.isis2503.nosqljpa.model.entity.COEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.IluminacionEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.TemperaturaEntity;
import co.edu.uniandes.isis2503.nosqljpa.persistence.AlarmaFueraDeLineaPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.AlarmaFueraDeRangoPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.COPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.IluminacionPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.SonidoPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.TemperaturaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;




/**
 *
 * @author n.acevedos
 */
public class ReporteLogic {
    private AlarmaFueraDeLineaPersistence AFL;
    private AlarmaFueraDeRangoPersistence AFR;
    private IluminacionPersistence ILU;
    private SonidoPersistence SON;
    private COPersistence CO;
    private TemperaturaPersistence TEM;
    public ReporteLogic()
    {
         AFL= new AlarmaFueraDeLineaPersistence();
         AFR = new AlarmaFueraDeRangoPersistence();
         ILU = new IluminacionPersistence();
         SON = new SonidoPersistence();
         CO = new COPersistence();
         TEM = new TemperaturaPersistence();
    }
    
     
    public String getReport() {
        double promT = 0;
        double promC = 0;
        double promS = 0;
        double promI = 0;
        List<IluminacionEntity> datosI = ILU.all();
        List<SonidoEntity> datosS = SON.all();
        List<COEntity> datosC = CO.all();
        List<TemperaturaEntity> datosT = TEM.all();
        for (TemperaturaEntity te : datosT) 
        {
            promT+=te.getValor();
        }
         for (SonidoEntity te : datosS) 
        {
            promS+=te.getValor();
        }
          for (IluminacionEntity te : datosI) 
        {
            promI+=te.getValor();
        }
           for (COEntity te : datosC) 
        {
            promC+=te.getValor();
        }
        String resp = "{ \"AFR\": "+AFR.all().size()+
                   ", \"AFL\": "+AFL.all().size()+
                   ", \"Temperatura\": "+(promT/datosT.size())+
                   ", \"Ruido\": "+(promS/datosS.size())+
                   ", \"CO\": "+(promC/datosC.size())+
                   ", \"Luz\": "+(promI/datosI.size())+"}";
        return resp;
    }
    
    
}