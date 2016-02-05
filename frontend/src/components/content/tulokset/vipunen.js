import React from 'react';
import Translate from 'react-translate-component';

let vipunen_logo = require('../../../images/vipunen-fi-allekkain.png');

export default class Vipunen extends React.Component {

  render() {
    return (
      <div className="organization">
        <img src={vipunen_logo} alt="Vipunen" />
        <Translate component="p" className="description" content="content.tulokset.vipunen" />
      </div>
    );
  }

}


