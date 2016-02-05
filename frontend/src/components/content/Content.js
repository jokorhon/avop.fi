require('./content.scss');

import React from 'react';
import Translate from 'react-translate-component';
import HakaLogin from './haka/Haka';
import Opintopolku from './tulokset/opintopolku';
import Vipunen from './tulokset/vipunen';
import Tietoarkisto from './tulokset/tietoarkisto';
import Arvo from './tulokset/arvo';

export default class Content extends React.Component {

  constructor() {
    super();
  }

  render() {
    return (
      <section>
        <div className="row">

          <div className="one-half column">
            <Translate component="h4" content="content.kysely.information" />
            <Translate component="p" content="content.kysely.about1" />
            <Translate component="p" content="content.kysely.about2" />
          </div>

          <div className="one-half column">
            <div id="theme">
              <div id="login-box">
                <Translate component="h4" content="content.login.header" />
                <Translate component="p" content="content.login.description" />
                <HakaLogin></HakaLogin>
              </div>
            </div>
          </div>
        </div>


        <div className="content-section">
          <div className="u-full-width separator">
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

          <div className="row organization-row" >
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
