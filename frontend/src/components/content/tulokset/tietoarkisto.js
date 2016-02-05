import React from 'react';
import Translate from 'react-translate-component';

let tietoarkisto_logo = require('../../../images/yhteiskuntatieteellinentietoarkisto.jpg');

export default class Tietoarkisto extends React.Component {

  render() {
    return (
      <div className="organization">
        <img src={tietoarkisto_logo} alt="Opintopolku.fi"/>
        <Translate component="p" className="description" content="content.tulokset.tietoarkisto" />
      </div>
    );
  }

}

