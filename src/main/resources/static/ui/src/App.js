import React, { Fragment, Component } from 'react';
import axios from 'axios';
import Table from './Table';

class App extends Component {
    state = { stores: [] }
    
    componentDidMount() {
        axios
            .get("http://localhost:8080/store")
            .then(res => {
                const stores = res.data.content;
                this.setState({ stores });
        })
        .catch(error => console.log("catch error: ", error));
    }    

    render() {
        return (
            <Fragment>
                <div className='container'>
                    <Table stores={this.state.stores} />
                </div>
            </Fragment>
        );
    }
}

export default App;