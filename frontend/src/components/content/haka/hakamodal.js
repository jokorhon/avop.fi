import React from 'react';
import Translate from 'react-translate-component';

let hakalogo = require('../../../images/haka.gif');

export default class Hakamodal extends React.Component {

  render() {
    return (
      <div>
        <img src={hakalogo} alt="Haka"/>
        <div class="hakalogin">
          <Translate component="span" className="description" content="hakaloginmodal.homeorganization" />
          <Translate component="span" className="description" content="hakaloginmodal.help" />
        </div>
      </div>
    );
  }

}
