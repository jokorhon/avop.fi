import React from 'react';
import Translate from 'react-translate-component';

export default class ProfileData extends React.Component {

    render() {
        return (
          <div>
            <Translate component="h4" content="profiledata.header" />
            <Translate component="p" content="profiledata.about" />
            <table>
              <tbody>
                <tr>
                  <Translate component="td" content="profiledata.education"></Translate>
                </tr>
                <tr>
                  <Translate component="td" content="profiledata.school"></Translate>
                  <td>{this.props.profiledata.school}</td>
                </tr>
                <tr>
                  <Translate component="td" content="profiledata.municipality"></Translate>
                </tr>
                <tr>
                  <Translate component="td" content="profiledata.language"></Translate>
                </tr>
                <tr>
                  <Translate component="td" content="profiledata.form_of_education"></Translate>
                </tr>
              </tbody>
            </table>
            <Translate component="p" content="profiledata.reminder"></Translate>
          </div>
        )
    }

}
