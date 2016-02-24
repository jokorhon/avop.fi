import React from 'react';
import Translate from 'react-translate-component';

export default class Arvo extends React.Component {

  render() {
    return (
      <div className="organization">
        <Translate component="p" className="description" content="content.tulokset.arvo" />
      </div>
    );
  }

}
