import React from 'react';

let vipunen_logo = require('../../../images/vipunen-fi-allekkain.png');

export default class Vipunen extends React.Component {

  render() {
    return (
      <div className="organization">
        <img src={vipunen_logo} alt="Vipunen" />
        <p className="description">Kyselyn tuloksista johdettuja tilastoraportteja on avoimesti saatavilla opetushallinnon tilastopalvelu Vipusessa:</p>
      </div>
    );
  }

}


