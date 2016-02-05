require('normalize.css');
require('skeleton-css-webpack');
require('./main.scss');

import React from 'react';
import Header from './header/Header';
import Content from './content/Content';
import Footer from './footer/Footer';

class AppComponent extends React.Component {

  render() {
    return (
      <div>
        <Header></Header>
        <div className="container">
          <Content></Content>
          <Footer></Footer>
        </div>
      </div>
    );
  }
}

AppComponent.defaultProps = {};

export default AppComponent;
