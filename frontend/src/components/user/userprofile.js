import React from 'react';
import { browserHistory } from 'react-router'
import Translate from 'react-translate-component';
import TranslateProperty from '../common/translateproperty';

export default class Userprofile extends React.Component {
  static loadProps(params, cb) {
    fetch('/api/opiskeluoikeudet',
      {credentials: 'same-origin'})
      .then(response => {
        if (response.status >= 400 || response.status === 302) {
          throw Error(response.status);
        }
        return response.json();
      })
      .then(study_rights => {
        cb(null, {study_rights});
      }).catch(() => {
        browserHistory.push('/error');
      });
  }

  goToArvo() {
    window.location = 'http://avopvastaustest.csc.fi/TK3HAK';
  }

  render() {
    let study_right = this.props.study_rights[0];
    return (
      <div>
        <Translate component="h4" content="profiledata.header"/>
        <Translate component="p" content="profiledata.about"/>
        <table>
          <tbody>
          <tr>
            <Translate component="td" content="profiledata.education"></Translate>
            <td>
              <TranslateProperty
                data={study_right.degree.name}>
              </TranslateProperty>
            </td>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.school"></Translate>
            <td>
              <TranslateProperty
                data={study_right.school.name}>
              </TranslateProperty>
            </td>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.municipality"></Translate>
            <td>
              <TranslateProperty
                data={study_right.municipality.name}>
              </TranslateProperty>
            </td>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.language"></Translate>
            <td>{study_right.lang}</td>
          </tr>
          <tr>
            <Translate component="td" content="profiledata.form_of_education"></Translate>
            <Translate component="td" content={study_right.type == 0 ? 'profiledata.type.day' : 'profiledata.type.multi'}></Translate>
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
