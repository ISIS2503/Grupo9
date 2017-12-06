
import React, { Component } from 'react';
import openSocket from 'socket.io-client';
import { SocketProvider } from 'socket.io-react';
import io from 'socket.io-client';
import RTChart from 'react-rt-chart';

const DOMNode = document.getElementById('renderTarget');

class Home extends Component {
constructor(props){
    super(props);
    
     this.state={
        value: 0,
        time: new Date()
    };
    
    this.handle = this.handle.bind(this);

    this.socket = io.connect("http://localhost:8086/thermalcomfort");
    this.socket.on('mesurements', msg => {
         console.log(msg);
         var mensaje = msg.replace("'","\"");
        var json = JSON.parse(mensaje);
        console.log(json.value);
        this.setState({
        value: JSON.parse(json.value),
        time: JSON.parse(json.time)
        
    });
    });

    
}

handle(msg){
    this.setState({
        value: msg.value,
        time: msg.time
        
    });
    console.log(msg.value);
}

    render() {
        const {isAuthenticated, login} = this.props.auth;
        var data = {
                  date: new Date(),
                  Data: this.state.value
                };
        return (
                <div className="container">
                    {this.state.value}
                    {
                        isAuthenticated() && (
                            
                            <RTChart
                            fields={['Data']}
                            data={data} />
                            
                        )
                    }
                    {
                        !isAuthenticated() && (
                                    <h4>
                                        You are not logged in! Please{' '}
                                        <a style={{cursor: 'pointer'}}
                                           onClick={login.bind(this)}
                                           >
                                            Log In
                                        </a>
                                        {' '}to continue.
                                    </h4>
                                            )
                    }
                </div>
                            );
                }
    }

    export default Home;
