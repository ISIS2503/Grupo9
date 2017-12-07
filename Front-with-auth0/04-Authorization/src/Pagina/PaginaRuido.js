import React, { Component } from 'react';
import { Table, Button, FormGroup, ControlLabel, FormControl, Glyphicon, Pagination } from 'react-bootstrap';
import { API_URL } from './../constants';
import Ruido from './Ruido';
import axios from 'axios';

class Pagina extends Component {
  componentWillMount() {
    this.setState({ 
      ruidoss: [],
      message: '',
      ubicacion: '',
      valor: '',
      unidad:'',
      fecha:'',
      totalRecords: '',
      currentPage:1
    });
    this.handleSelect = this.handleSelect.bind(this);
  }
  componentDidMount() {
    this.getRuido();
  }
  handleNameChange(event) {
    this.setState({ name: event.target.value });
  }
  handleCodeChange(event) {
    this.setState({ code: event.target.value });
  }
  addRuido(event) {
    event.preventDefault();
    const { getIdToken } = this.props.auth;
    const headers = { Authorization: `Bearer ${getIdToken()}`};
    const ruido = { name: this.state.name, code: this.state.code };
    axios.post(`${API_URL}/sonido`, ruido, { credentials: true, headers: headers })
    .then(response => this.getFloors())
    .catch(error => this.setState({ message: error.message }));
  }
  handleSelect(eventKey){
    console.log(this);
        this.state.currentPage = eventKey;
    this.getRuido();
  }
  getRuido() {
    
    var paginaActual = this.state.currentPage;
    var url = '/sonido/pagina?page=' + paginaActual + '&maxRecords=10';
    const { getIdToken } = this.props.auth;
    const headers = { Authorization: `Bearer ${getIdToken()}`};
    axios.get(`${API_URL}` + url, { credentials: true, headers: headers })
    .then(response => this.setState({ temperaturas: response.data.medidas, totalRecords: response.data.totalRecords }))
    .catch(error => this.setState({ message: error.message }));
     
  }
  render() {
    const { isAuthenticated } = this.props.auth;
    return (
      <div className="container">
      <h1>Ruido</h1>
      
      
      <Table striped bordered condensed hover className="center">
        <thead>
          <tr>
            <th>#</th>
            <th>ID</th>
            <th>Ubicacion</th>
            <th>Valor</th>
            <th>Unidad</th>
            <th>Fecha</th>
          </tr>
        </thead>
        <tbody>
          {this.state.ruidos.map((ruido, index) => {
          return (
            <Ruido
              key={index}
              number={index + 1}
              id={ruido.id}
              ubicacion={ruido.ubicacion}
              valor={ruido.valor}
              unidad={ruido.unidad}
              fecha={ruido.fecha}
              auth={this.props.auth}
              getFloors={() => this.getFloors()}
            />
          );
        })}
        </tbody>
      </Table>
       
       <div>
        <Pagination
        prev
        next
        first
        last
        ellipsis
        boundaryLinks
        items={Math.ceil(this.state.totalRecords / 10)}
        maxButtons={5}
        activePage={this.state.currentPage}
        onSelect={this.handleSelect}
      />
      
        <br />
      </div>
      
      <h2>{this.state.message}</h2>
      </div>
      );
  }
}

export default PaginaRuido;
