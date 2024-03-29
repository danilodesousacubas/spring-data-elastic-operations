import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

import { BrowserRouter, Switch, Route} from 'react-router-dom';
import Table from './Table';

// ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA

ReactDOM.render(
    <BrowserRouter>
        <Switch>
            <Route path='/' exact={true} component={App} />
            {<Route path='/create' component={App} /> }
            {<Route path='/list' component={Table} /> }
            {/* <Route component={NotFound} /> */}

        </Switch>
    </BrowserRouter>
    , document.getElementById('root'));

serviceWorker.unregister();
