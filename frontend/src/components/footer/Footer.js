require('./footer.scss');

import React from 'react';
import Translate from 'react-translate-component';

let okm_logo = require('../../images/OKM_logo.png');
let csc_logo = require('../../images/csc-logo-teksti-fi.png');
let arene_logo = require('../../images/arene.png');

let Footer = () =>
  <footer className="container">
    <div className="row">
      <div className="u-full-width">
        <Translate component="h4" content="footer.header"/>
      </div>

    </div>
    <div className="row">
      <div className="one-third column arene">
        <img className="img-arene" src={arene_logo} alt="Arene Ry"/>
        <Translate component="p" content="footer.arene.description"/>
      </div>

      <div className="one-third column okm">
        <img className="img-okm" src={okm_logo} alt="Opetus- ja kulttuuriministeriö"/>
        <Translate component="p" content="footer.okm.description"/>
      </div>

      <div className="one-third column csc">
        <img className="img-csc" src={csc_logo} alt="CSC - Tieteen tietotekniikan keskus Oy"/>
        <Translate component="div" content="footer.csc.description"/>
        <span>avop@postit.csc.fi</span>
      </div>
    </div>
  </footer>;

export default Footer;
