import React from 'react';
import LinkWrapper from './LinkWrapper';

const Header = () => {
    return(
        <nav>
            <div className="nav-wrapper purple darken-4">
                <LinkWrapper to="/" className="brand-logo" activeStyle={{}}></LinkWrapper>
                <ul className="right">
                    <li><LinkWrapper to='/create'>Create</LinkWrapper></li>
                    <li><LinkWrapper to='/list'>List</LinkWrapper></li>
                </ul>
            </div>
        </nav>
    );
}
export default Header;