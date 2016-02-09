require('./footer.scss');

import React from 'react';
import Translate from 'react-translate-component';

let okm_logo = require('../../images/OKM_logo.png');
let csc_logo = require('../../images/csc-logo-teksti-fi.png');
let arene_logo = require('../../images/arene.png');

let Footer = () =>
  <footer>
    <div className="footer-wrap">
      <div className="row">
        <div className="u-full-width">
          <Translate component="h4" content="footer.header"/>
        </div>

      </div>
      <div className="row">
        <div className="one-third column organization">
          <Translate className="bold" component="p" content="footer.arene.contribution" />
          <img src={arene_logo} alt="Arene Ry"/>
          <Translate component="p" content="footer.arene.description" />
        </div>

        <div className="one-third column organization">
          <Translate className="bold" component="p" content="footer.okm.contribution" />
          <img src={okm_logo} alt="Opetus- ja kulttuuriministeriö"/>
          <Translate component="p" content="footer.okm.description" />
        </div>

        <div className="one-third column organization">
          <Translate className="bold" component="p" content="footer.csc.contribution" />
          <img src={csc_logo} alt="CSC - Tieteen tietotekniikan keskus Oy"/>
          <Translate component="p" content="footer.csc.description" />
          <address>avop@postit.csc.fi</address>
        </div>
      </div>
    </div>
  </footer>;

export default Footer;
