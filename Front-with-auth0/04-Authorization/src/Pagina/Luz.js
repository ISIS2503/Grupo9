import React, { Component } from 'react';
import { Button, Glyphicon, Modal, FormControl, FormGroup, ControlLabel } from 'react-bootstrap';
import { API_URL } from './../constants';
import axios from 'axios';

class Luz extends Component {
	componentWillMount() {
	    this.setState({ 
	      showModal: false,
	      name: '',
	      code: ''
	    });
	 }
	handleNameChange(event) {
    	this.setState({ name: event.target.value });
  	}
  	handleCodeChange(event) {
    	this.setState({ code: event.target.value });
  	}
	deleteLuz() {
		const { getIdToken } = this.props.auth;
	    const headers = { Authorization: `Bearer ${getIdToken()}`};
	    axios.delete(`${API_URL}/luz/${this.props.id}`, { credentials: true, headers: headers })
		    .then(response => { 
		    	console.log("Deleted successfully");
		    	this.props.getLuz();
		    });
	}
	updateLuz() {
		const { getIdToken } = this.props.auth;
		const luz = { id: this.props.id, name: this.state.name, code: this.state.code };
	    const headers = { Authorization: `Bearer ${getIdToken()}`};
	    axios.put(`${API_URL}/luz`, luz, { credentials: true, headers: headers })
		    .then(response => { 
		    	console.log("Updated successfully");
		    	this.close();
		    	this.props.getLuz();
		    });
	}
	close() {
	    this.setState({ showModal: false });
	}

	open() {
	    this.setState({ showModal: true });
	}
	render() {
		return (
			<tr>
				<td>{this.props.number}</td>
				<td>{this.props.id}</td>
				<td>{this.props.ubicacion}</td>
				<td>{this.props.valor}</td>
                                <td>{this.props.unidad}</td>
                                <td>{this.props.fecha}</td>
			</tr>

		);
	}
}
export default Luz;