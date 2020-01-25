import React, { Component } from 'react';

class Table extends Component {
    render() {
        const  {stores} = this.props;
        return (
           <TableStores stores={stores} />
        );
    }
}

const TableStores = props => {
    const lines = props.stores.map((l,i) => {
         return(
            <tr key={i}>
                 <td>{l.id}</td>
                 <td>{l.name}</td>
             </tr>
         );
    });

    return(
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
            </thead>
            <tbody>
                {lines}
            </tbody>
        </table>
    );
}
   
export default Table;