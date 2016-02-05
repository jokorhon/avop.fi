import React from 'react';

let tietoarkisto_logo = require('../../../images/yhteiskuntatieteellinentietoarkisto.jpg');

export default class Tietoarkisto extends React.Component {

  render() {
    return (
      <div className="organization">
        <img src={tietoarkisto_logo} alt="Opintopolku.fi"/>
        <p className="description">Koko kyselyaineisto on saatavissa tutkimuskäyttöön yhteiskuntatieteellisestä tietoarkistosta</p>
      </div>
    );
  }

}

