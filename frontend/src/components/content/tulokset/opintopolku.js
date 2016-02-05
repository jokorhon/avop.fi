import React from 'react';

let opintopolku_logo = require('../../../images/opintopolkufi.png');

export default class Opintopolku extends React.Component {

  render() {
    return (

      <div className="organization">
        <img src={opintopolku_logo} alt="Opintopolku.fi"/>
        <p className="description">Katseluoikeudet (Arvo-katselija) voi anoa Opintopolun virkailijantyöpöydän kautta
          (Omat tiedot)</p>
      </div>
    );
  }

}


