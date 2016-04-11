import React from 'React';
import Translate from 'react-translate-component';

export default class Organization extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      localizationKey: props.localizationKey
    }
  }

  render() {
    return (
      <div>
        <Translate component="p" className="description" content={this.props.localizationKey}/>
      </div>
    );
  }
}
