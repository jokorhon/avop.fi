require('./header.scss');

import React from 'react';
import LocaleSwitcher from './localeSwitcher';
import Translate from 'react-translate-component';

export default class Header extends React.Component {

  render() {
    return (
      <header>
        <div className="container">
          <div className="row">
            <div className="one-half column">
              <h3 id="logo">AVOP</h3>
              <Translate id="logotext" component="p" content="header.logotext" />
            </div>

            <div className="one-half column">
              <LocaleSwitcher></LocaleSwitcher>
            </div>
          </div>
        </div>
      </header>
    );
  }

}
