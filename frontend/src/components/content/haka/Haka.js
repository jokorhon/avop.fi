import React from 'react';

let hakaLoginImage = require('../../../images/haka_landscape_large.gif');

export default class HakaLogin extends React.Component {

  constructor() {
    super();
  }

  render() {
    return (
      <div id="haka" onClick={this.login}>
        <a href="https://avop.fi/Shibboleth.sso/Login">
          <img src={hakaLoginImage} alt="haka-login"/>
        </a>
      </div>
    );
  }

}
