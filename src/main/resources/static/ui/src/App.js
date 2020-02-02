import React, { Fragment, Component } from 'react';
import axios from 'axios';
import Table from './Table';
import Header from './Header';
import 'materialize-css/dist/css/materialize.min.css';
import Create from './Create';

class App extends Component {
    state = { stores: [] }

    componentDidMount() {
        axios
            .get("http://localhost:8080/api/store")
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
                    <Header />
                        <br />
                        <Create />
                        <Table stores={this.state.stores} />
                    </div>
            </Fragment>
                );
            }
        }
        
export default App;