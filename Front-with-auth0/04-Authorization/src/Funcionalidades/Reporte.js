/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import { Table, Button, FormGroup, ControlLabel, FormControl, Glyphicon, Pagination } from 'react-bootstrap';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';
import axios from 'axios';
import React from 'react';

class Reporte extends React.Component {
    
    
    getblah() {
        axios.get('http://localhost:8084/reporte')
                .then(response => this.setState({reporte: response.data.medidas}))
                .catch(error => this.setState({message: error.message}));
    }
  render() {
        return (
                <div>  
           <Breadcrumb>
        <BreadcrumbItem><a href="por">Funcionalidades</a></BreadcrumbItem>
        <BreadcrumbItem active>Reporte</BreadcrumbItem>
      </Breadcrumb>
        <Button color="primary">Reporte</Button>{' '}
        <table>
            <tr>
              <th>Reporte</th>
            </tr>
            <tr>
              <td>Numero de Alertas Fuera De Rango</td>
              <td>reporte.AFR</td>
            </tr>
            <tr>
              <td>Numero de Alertas Fuera de Linea</td>
              <td>reporte.AFL</td>
            </tr>
            <tr>
              <td>Promedio Ruido</td>
              <td>reporte.Ruido</td>
            </tr>
            <tr>
              <td>Promedio Temperatura</td>
              <td>reporte.Temperatura</td>
            </tr>
            <tr>
              <td>Promedio Iluminacion</td>
              <td>reporte.Luz</td>
            </tr>
            <tr>
              <td>Promedio Gases</td>
              <td>reporte.CO</td>
            </tr>
          </table>
             
         
                </div>


                );
    }
}
export default Reporte;



