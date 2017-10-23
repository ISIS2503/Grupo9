'''
Created on 21/10/2017

@author: b.gamba10
'''
import json
import smtplib
from kafka import KafkaConsumer
from collections import namedtuple
import datetime

 
consumer = KafkaConsumer('email', value_deserializer=lambda m:json.loads(m.decode('ascii')),
                         group_id='my-group',
                         bootstrap_servers=['172.24.42.27:8090'])

server = smtplib.SMTP('smtp.gmail.com', 587)
server.connect("smtp.gmail.com", 587)
server.ehlo()
server.starttls()
server.ehlo()
server.login("alertasynotificacionesg9@gmail.com", "12345grupo9")
 

for message in consumer:

    print ("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                          message.offset, message.key,
                                          message.value))
    
    obj = json.loads(message.value,object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))

    payload ={
        
        "valor": obj.valor,
        "ubicacion": obj.ubicacion,
        "unidad": obj.unidad,
        "tipo": obj.tipo,
        "timestamp": obj.timestamp
    }
    
    
    if obj.tipo == "fr":
        SUBJECT = 'Alerta: Fuera de Rango'
        TEXT ='El microcontrolador ubicado en ' + obj.ubicacion + 'esta fuera de rango \n El valor es ' + str(obj.valor) + ' ' + obj.unidad + '\n\nFecha: ' +''+ str(datetime.datetime.fromtimestamp(float(obj.timestamp)/1000.0))

        message = """Subject: %s\n\n%s
        """ % (SUBJECT, TEXT)
        
    elif obj.tipo == "fl":
        SUBJECT = 'Alerta: Fuera de Linea'
        TEXT = 'El sensor que mide ' + obj.unidad + ' del microcontrolador ubicado en ' + obj.ubicacion + ' esta fuera de linea\n\nDesde: ' + str(datetime.datetime.fromtimestamp(float(obj.timestamp)/1000.0))

        message = """Subject: %s\n\n%s
        """ % (SUBJECT, TEXT)
        
    server.sendmail("alertasynotificacionesg9@gmail.com", "jm.dominguez@uniandes.edu.co", message)
    
    
server.quit()    