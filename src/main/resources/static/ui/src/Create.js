import React, { Component } from 'react';
import axios from 'axios';

export default class Create extends Component {
    constructor(props) {
        super(props);

        this.stateInicial = {
            name: ''
        }

        this.state = this.stateInicial;
    }

    handleChange = event => {
        const { name, value } = event.target;

        console.log("input event ", this.state);

        this.setState({
            [name]: value
        });
    }

    handleSubmit = event => {
        event.preventDefault();

        console.log("name", this.state.name);
        
        const store = {
            name: this.state.name
        };

        console.log("store", this.store);
        console.log("submit", this.state);
        
        axios.post(`http://localhost:8080/api/store`, { store })
            .then(res => {
                console.log(res);
                console.log(res.data);
            })

    }

    render() {

        const { name } = this.state;

        return (
            <form>
                <div className="row">
                    <div className="input-field col s4">
                        <label className="input-field" htmlFor="name" />
                        <input
                            className="validate"
                            id="name"
                            type="text"
                            name="name"
                            value={name}
                            onChange={this.handleChange}

                        />
                    </div>
                    <button className="waves-effect waves-light indigo lighten-2 btn" type="button" onClick={this.handleSubmit}>Save</button>
                    
                </div>
            </form>

        );
    }
}