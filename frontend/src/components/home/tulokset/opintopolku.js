import React from 'react';
import Translate from 'react-translate-component';

let opintopolku_logo = require('../../../images/opintopolkufi.png');

export default class Opintopolku extends React.Component {

  render() {
    return (

      <div className="organization">
        <img src={opintopolku_logo} alt="Opintopolku.fi"/>
        <Translate component="p" className="description" content="content.tulokset.opintopolku" />
      </div>
    );
  }

}


