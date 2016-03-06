import React from 'react';
let translator = require('counterpart');

export default class TranslateProperty extends React.Component {
  static defaultLang = 'fi';

  constructor(props) {
    super(props);
    this.state = {
      locale: this.getTranslator().getLocale()
    };
  }

  componentDidMount() {
    this.getTranslator().onLocaleChange((l) => this.localeChanged(l));
  }

  getTranslator() {
    return translator;
  }

  localeChanged(newLocale) {
    this.setState({locale: newLocale});
  }

  render() {
    let str = this.props.data[this.state.locale];
    if (str === undefined) {
      str = this.props.data[TranslateProperty.defaultLang];
    }
    return (<span>{str}</span>);
  }
}

