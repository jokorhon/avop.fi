require('normalize.css');
require('skeleton-css-webpack');
require('./main.scss');

import React from 'react';
import Header from './header/Header';
import Content from './content/Content';
import Footer from './footer/Footer';
import counterpart from 'counterpart';
import ProfileData from './profiledata/profiledata';

import localizations_fi from '../localizations/localizations_fi';
import localizations_en from '../localizations/localizations_en';
import localizations_sv from '../localizations/localizations_sv';

class AppComponent extends React.Component {

  constructor(props) {
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

    this.state = {
      profileData: props.profileData
    };

  }

  setProfileData(profileData) {
    this.setState({
      profileData: profileData
    });
  }

  render() {
    if(this.state.profileData) {
      return (
        <div>
          <Header></Header>
          <div className="container">
            <ProfileData profiledata={this.state.profileData}></ProfileData>
            <Footer></Footer>
          </div>
        </div>
      )
    } else {

    return (
      <div>
        <Header></Header>
        <div className="container">
          <Content></Content>
          <Footer></Footer>
        </div>
      </div>
    );
    }
  }
}

AppComponent.defaultProps = {
  profileData: undefined
};

export default AppComponent;

