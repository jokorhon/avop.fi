require('./localeswitcher.scss');

import React from 'react';
import counterpart from 'counterpart';
import localizations_fi from '../../localizations/localizations_fi';
import localizations_en from '../../localizations/localizations_en';
import localizations_sv from '../../localizations/localizations_sv';

export default class LocaleSwitcher extends React.Component {

  constructor() {
    super();

    let browserLanguage = window.navigator.userLanguage || window.navigator.language;

    counterpart.registerTranslations('fi', localizations_fi);
    counterpart.registerTranslations('en', localizations_en);
    counterpart.registerTranslations('sv', localizations_sv);

    if(browserLanguage.startsWith('fi')) {
      counterpart.setLocale('fi');
    } else if(browserLanguage.startsWith('sv')) {
      counterpart.setLocale('sv');
    } else {
      counterpart.setLocale('en');
    }
  }

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
