require('./localeswitcher.scss');

import React from 'react';
import counterpart from 'counterpart';
import localizations_fi from '../../localizations/localizations_fi';
import localizations_en from '../../localizations/localizations_en';
import localizations_sv from '../../localizations/localizations_sv';

export default class LocaleSwitcher extends React.Component {

  constructor() {
    super();
    counterpart.registerTranslations('fi', localizations_fi);
    counterpart.registerTranslations('en', localizations_en);
    counterpart.registerTranslations('sv', localizations_sv);
    counterpart.setLocale('fi');
  }

  setLocaleFi() {
    counterpart.setLocale('fi');
  }

  setLocaleEn() {
    counterpart.setLocale('en');
  }

  setLocaleSv() {
    counterpart.setLocale('sv');
  }

  render () {
    return (
        <div id="languages">
          <span onClick={this.setLocaleFi}>Suomeksi</span>
          <span onClick={this.setLocaleSv}>På Svenska</span>
          <span onClick={this.setLocaleEn}>In English</span>
        </div>
    );
  }
}
