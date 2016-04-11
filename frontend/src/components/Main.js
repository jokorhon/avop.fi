require('normalize.css');
require('skeleton-css-webpack');
require('./main.scss');

import React from 'react';
import Header from './header/Header';
import Footer from './footer/Footer';
import counterpart from 'counterpart';

import localizations_fi from '../localizations/localizations_fi';
import localizations_en from '../localizations/localizations_en';
import localizations_sv from '../localizations/localizations_sv';

class AppComponent extends React.Component {

  constructor(props) {
    super(props);
    counterpart.registerTranslations('fi', localizations_fi);
    counterpart.registerTranslations('en', localizations_en);
    counterpart.registerTranslations('sv', localizations_sv);
    this.setLocale();
  }

  setLocale() {
    if (this.props.params.lang.startsWith('fi')) {
      counterpart.setLocale('fi');
    } else if (this.props.params.lang.startsWith('sv')) {
      counterpart.setLocale('sv');
    } else {
      counterpart.setLocale('en');
    }
  }

  componentDidUpdate() {
    this.setLocale();
  }

  render() {
    return (
      <div>
        <Header></Header>
        <div className="container">
          {this.props.children}
          <Footer></Footer>
        </div>
      </div>
    )
  }
}

export default AppComponent;

