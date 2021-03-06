import React from 'react';
import {browserHistory} from 'react-router';
import Translate from 'react-translate-component';
import TranslateProperty from '../common/translateproperty';
let logo = require('../../images/logo-fi.png');

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
      .then(study_rights => {
        cb(null, {study_rights})
      })
      .catch(e => window.location = '/' + params.params.lang + '/error/' + e.message);
  }

  selectStudyRight(event) {
    this.setState({
      selectedStudyRight: this.props.study_rights
        .find(x => x.id === event.target.value)
    });
  }

  onSubmit(event) {
    event.preventDefault();
    let data = {
      opiskeluoikeus_id: this.state.selectedStudyRight.id,
      kieli: this.props.params.lang
    };
    fetch('/api/rekisteroidy', {
      method: 'post',
      credentials: 'same-origin',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    }).then(response => {
        if (response.status == 401) {
          throw Error(response.status);
        }
        return response.json();
      })
      .then(registration => window.location = registration['kysely_url'])
      .catch(e => browserHistory.push(`/${this.props.params.lang}/error/` + e.message));
  }

  render() {
    if (this.props.study_rights.length === 0) {
      return <div>
        <Translate component="p" content="errors.missing_rights"/>
      </div>;
    }
    return (
      <div>
        <section id="theme">
          <div className="container">
            <div className="row">

              <div className="six columns">
                <div className="u-full-width">
                  <div id="logo">
                    <img src={logo} alt="Avop"/>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </section>
        <section id="userprofile">
          <div className="container">
            <div className="row">
              <div className="u-full-width"><Translate component="h4" content="profiledata.header"/></div>
              <div className="u-full-width"><Translate component="p" content="profiledata.about"/></div>

              <form onSubmit={this.onSubmit.bind(this)}>
                {(this.props.study_rights.length > 1) ?
                  <select onChange={this.selectStudyRight.bind(this)}
                          value={this.state.selectedStudyRight.id}>
                    {
                      this.props.study_rights.map(sr =>
                        <TranslateProperty component="option"
                                           value={sr.id}
                                           data={sr.koulutus.nimi}>
                        </TranslateProperty>
                      )
                    }
                  </select>
                  : ''
                }
                <div className="u-full-width">
                  <table>
                    <tbody>
                    <tr>
                      <Translate component="td" content="profiledata.education"></Translate>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.koulutus.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.school"></Translate>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.oppilaitos.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.municipality"></Translate>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.kunta.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.language"></Translate>
                      <td>{this.state.selectedStudyRight.kieli}</td>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.form_of_education"></Translate>
                      <Translate component="td"
                                 content={this.state.selectedStudyRight.koulutusmuoto == 0 ? 'profiledata.type.day' : 'profiledata.type.multi'}></Translate>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div className="u-full-width"><Translate component="p" content="profiledata.reminder"></Translate></div>
                <div className="u-full-width">
                  <button type="submit">
                    <Translate component="span" content="profiledata.submit"></Translate>
                  </button>
                </div>
              </form>
            </div>
          </div>
        </section>
      </div>
    )
  }

}
