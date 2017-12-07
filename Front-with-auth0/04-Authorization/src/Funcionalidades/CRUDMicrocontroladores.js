/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React from 'react';
import { Button } from 'reactstrap';

class CRUDMicrocontroladores extends React.Component {
  render() {
    return (
        <div>    
        <Button color="primary">Reporte</Button>{' '}
        
        <form>
  <label>
    Name:
    <input type="text" name="name" />
  </label>
  <input type="submit" value="Submit" />
</form>
      </div>
    );
  }
}
export default CRUDMicrocontroladores;