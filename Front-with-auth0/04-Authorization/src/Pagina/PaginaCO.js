import React, { Component } from 'react';
import { Table, Button, FormGroup, ControlLabel, FormControl, Glyphicon, Pagination } from 'react-bootstrap';
import { API_URL } from './../constants';
import CO from './CO';
import axios from 'axios';

class PaginaCO extends Component {
  componentWillMount() {
    this.setState({ 
      cos: [],
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
    this.getCo();
  }
  handleNameChange(event) {
    this.setState({ name: event.target.value });
  }
  handleCodeChange(event) {
    this.setState({ code: event.target.value });
  }
  addCO(event) {
    event.preventDefault();
    const { getIdToken } = this.props.auth;
    const headers = { Authorization: `Bearer ${getIdToken()}`};
    const co = { name: this.state.name, code: this.state.code };
    axios.post(`${API_URL}/co`, co, { credentials: true, headers: headers })
    .then(response => this.getFloors())
    .catch(error => this.setState({ message: error.message }));
  }
  handleSelect(eventKey){
    console.log(this);
        this.state.currentPage = eventKey;
    this.getCO();
  }
  getCO() {
    
    var paginaActual = this.state.currentPage;
    var url = '/co/pagina?page=' + paginaActual + '&maxRecords=10';
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
      <h1>COs</h1>
      
      
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
          {this.state.cos.map((co, index) => {
          return (
            <CO
              key={index}
              number={index + 1}
              id={co.id}
              ubicacion={co.ubicacion}
              valor={co.valor}
              unidad={co.unidad}
              fecha={co.fecha}
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

export default PaginaCO;
