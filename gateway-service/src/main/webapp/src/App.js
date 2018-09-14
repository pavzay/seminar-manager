import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class App extends Component {

    state = {
        speakers: []
    }


    componentDidMount() {
        const client = axios.create({
            baseURL: 'http://localhost:8080/'
        });

        client.post('uaa/oauth/token?scope=ui&grant_type=password&username=test&password=test', {}, {
            headers: {
                'Authorization': 'Basic dWk6dWk='
            }
        })
            .then(response => {
                console.log(response);
                let accessToken = response.data['access_token'];
                console.log('accessToken ' + accessToken);

                client.get('speakers', {headers: {
                        'Authorization': 'Bearer ' +accessToken
                    }})
                    .then(response => {
                        console.log(response);
                        let speakers = response.data;
                        this.setState({speakers: speakers});
                    });
            });

    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <h1 className="App-title">Seminar Manger</h1>
                </header>
                <p className="App-intro">
                    {
                        this.state.speakers.map(speaker => (
                            <p>{speaker.name}</p>
                        ))
                    }
                </p>
            </div>
        );
    }
}

export default App;
