import React, { Fragment, Component } from 'react';
import Table from './Table';

class App extends Component {
    render() {
        return (
            <Fragment>
                <div className='container'>

                    <Table />
                </div>
            </Fragment>
        );
    }
}

export default App;