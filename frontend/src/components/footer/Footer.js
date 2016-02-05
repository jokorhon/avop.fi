require('./footer.scss');

import React from 'react';
import Translate from 'react-translate-component';

let Footer = () =>
  <footer>
    <div className="footer-wrap">
      <div className="row">
        <div className="u-full-width">
          <h4>Yhteystiedot</h4>
        </div>

      </div>
      <div className="row">
        <div className="one-third column">
          <Translate component="p" content="footer.arene.contribution" />
          <Translate component="p" content="footer.arene.description" />
        </div>

        <div className="one-third column">
          <Translate component="p" content="footer.okm.contribution" />
          <Translate component="p" content="footer.okm.description" />
        </div>

        <div className="one-third column">
          <Translate component="p" content="footer.csc.contribution" />
          <Translate component="p" content="footer.csc.description" />
          <address>avop@postit.csc.fi</address>
        </div>
      </div>
    </div>
  </footer>;

export default Footer;
