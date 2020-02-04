import React, { Component } from 'react';
import axios from 'axios';

export default class Table extends Component {
    state = { stores: [] }

    componentDidMount() {
        console.log("component did mount");

        axios
        .get("http://localhost:8080/api/store")
        .then(res => {
            console.log("stores -->", res.data.content);
            const stores = res.data.content;
            this.setState({ stores });
        })
        .catch(error => console.log("catch error: ", error));
    }
    
    handleChange = event => {
        this.setState({ id: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();
    
        axios.delete(`http://localhost:8080/api/store/${this.state.id}`)
          .then(res => {
            console.log(res);
            console.log(res.data);
          })
      }

    render() {
        
        // const { stores } = this.props;
        return (
            <TableStores stores={this.state.stores} />
        );
    }
}

const TableStores = props => {
    
    const lines = props.stores.map((l, i) => {
        return (
            <tr key={i}>
                <td>{l.id}</td>
                <td>{l.name}</td>
                <td>{l.email}</td>
                <td>
                    <button 
                        className="waves-effect waves-light indigo lighten-2 btn" 
                        type="button"
                        onClick={}
                        >
                                Remove
                    </button>
                </td>
            </tr>
        );
    });

    return (
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>email</th>
                    <th>actions</th>
                </tr>
            </thead>
            <tbody>
                {lines}
            </tbody>
        </table>
    );
}

