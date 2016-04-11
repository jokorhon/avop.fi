require('./content.scss');

import React from 'react';
import config from 'config';
import Translate from 'react-translate-component';
import Opintopolku from './tulokset/opintopolku';
import Vipunen from './tulokset/vipunen';
import Tietoarkisto from './tulokset/tietoarkisto';
import Arvo from './tulokset/arvo';

let hakaLoginImage = require('../../images/haka_landscape_large.gif');

export default class Content extends React.Component {

  constructor(props) {
    super(props);
  }

  extractCurrentDomain() {
    return window.location.protocol + '//' +
      window.location.hostname +
      ((window.location.port === '') ? '' : ':' + window.location.port);
  }

  render() {
    return (
      <section>
        <div className="row">
          <div className="u-full-width">
            <div id="themeimage">
              <div id="haka-login">
                <Translate component="h4" content="content.login.header"/>
                <Translate component="p" content="content.login.description"/>
                <div id="haka" onClick={this.login}>
                  <a href={config.hakaLoginUrl(this.extractCurrentDomain(), this.props.params.lang)}>
                    <img src={hakaLoginImage} alt="haka-login"/>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div className="row content-section">
          <div className="u-full-width">
            <Translate component="h4" content="content.kysely.information"/>
          </div>
        </div>

        <div className="row content-section">
          <div className="one-half column">
            <Translate component="p" content="content.kysely.about1"/>
          </div>

          <div className="one-half column">
            <Translate component="p" content="content.kysely.about2"/>
          </div>
        </div>

        <div className="content-section">
          <div className="u-full-width ">
            <Translate component="h4" content="content.tulokset.header"></Translate>
          </div>

          <div className="row organization-row">
            <div className="one-half column">
              <Vipunen></Vipunen>
            </div>

            <div className="one-half column">
              <Opintopolku></Opintopolku>
            </div>
          </div>

          <div className="row organization-row">
            <div className="one-half column">
              <Tietoarkisto></Tietoarkisto>
            </div>

            <div className="one-half column">
              <Arvo></Arvo>
            </div>
          </div>
        </div>

      </section>
    );
  }
}
