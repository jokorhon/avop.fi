require('./localeswitcher.scss');

import React from 'react';
import counterpart from 'counterpart';


export default class LocaleSwitcher extends React.Component {

  setLocale(code) {
    counterpart.setLocale(code);
  }

  render () {
    return (
        <div id="languages">
          <span className="language-selection" onClick={this.setLocale.bind(this, 'fi')}>Suomeksi</span>
          <span className="language-selection" onClick={this.setLocale.bind(this, 'sv')}>På Svenska</span>
          <span className="language-selection" onClick={this.setLocale.bind(this, 'en')}>In English</span>
        </div>
    );
  }
}
