import React from 'react';
import { browserHistory } from 'react-router'
import Translate from 'react-translate-component';
import TranslateProperty from '../common/translateproperty';

export default class Userprofile extends React.Component {
  constructor(props) {
    super(props);
    this.state = {selectedStudyRight: this.props.study_rights[0]};
  }

  static loadProps(params, cb) {
    fetch('/api/opiskeluoikeudet',
      {credentials: 'same-origin'})
      .then(response => {
        if (response.status >= 400 || response.status === 302) {
          throw Error(response.status);
        }
        return response.json();
      })
      .then(study_rights => cb(null, {study_rights}))
      .catch(() => browserHistory.push('/error'));
  }

  goToArvo() {
    window.location = 'http://avopvastaustest.csc.fi/TK3HAK';
  }

  selectStudyRight(event) {
    this.setState({
      selectedStudyRight: this.props.study_rights
        .find(x => x.id === event.target.value)
    });
  }

  render() {
    return (
      <div>
        <Translate component="h4" content="profiledata.header"/>
        <Translate component="p" content="profiledata.about"/>

        {(this.props.study_rights.length > 1) ?
          <select onChange={this.selectStudyRight.bind(this)} value={this.state.selectedStudyRight.id}>
            {
              this.props.study_rights.map(sr =>
                <TranslateProperty component="option"
                                   value={sr.id}
                                   data={sr.degree.name}>
                </TranslateProperty>
              )
            }
          </select>
          : ''}

        <table>
          <tbody>
          <tr>
            <Translate component="td" content="profiledata.education"></Translate>
            <TranslateProperty component="td"
                               data={this.state.selectedStudyRight.degree.name}>
            </TranslateProperty>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.school"></Translate>
            <TranslateProperty component="td"
                               data={this.state.selectedStudyRight.school.name}>
            </TranslateProperty>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.municipality"></Translate>
            <TranslateProperty component="td"
                               data={this.state.selectedStudyRight.municipality.name}>
            </TranslateProperty>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.language"></Translate>
            <td>{this.state.selectedStudyRight.lang}</td>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.form_of_education"></Translate>
            <Translate component="td"
                       content={this.state.selectedStudyRight.type == 0 ? 'profiledata.type.day' : 'profiledata.type.multi'}></Translate>
          </tr>
          </tbody>
        </table>
        <Translate component="p" content="profiledata.reminder"></Translate>
        <button onClick={this.goToArvo}>
          <Translate component="span" content="profiledata.submit"></Translate>
        </button>
      </div>
    )
  }

}
