/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React from 'react';
import { Button } from 'reactstrap';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

class Alertas extends React.Component {
  render() {
    return (
        <div>

            <Breadcrumb>
        <BreadcrumbItem><a href="por">Funcionalidades</a></BreadcrumbItem>
        <BreadcrumbItem active>Alertas</BreadcrumbItem>
      </Breadcrumb>
        <Button color="primary">Reporte</Button>{' '}
        </div>
        
      
    );
  }
}
export default Alertas;



