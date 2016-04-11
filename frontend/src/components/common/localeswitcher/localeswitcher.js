require('./localeswitcher.scss');

import React from 'react';
import {Link} from 'react-router';

export default class LocaleSwitcher extends React.Component {
  render () {
    return (
        <div id="languages">
          <Link className="language-selection" to="/fi">Suomeksi</Link>
          <Link className="language-selection" to="/sv">På Svenska</Link>
          <Link className="language-selection" to="/en">In English</Link>
        </div>
    );
  }
}
