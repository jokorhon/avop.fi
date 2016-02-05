require('./haka.scss');

import React from 'react';
import Ajax from 'simple-ajax';
import Modal from 'react-modal';

let hakaLoginImage = require('../../../images/haka_landscape_large.gif');

const customStyles = {
  content: {
    top: '50%',
    left: '50%',
    right: 'auto',
    bottom: 'auto',
    marginRight: '-50%',
    transform: 'translate(-50%, -50%)'
  }
};

export default class HakaLogin extends React.Component {

  constructor() {
    super();
    this.login = this.login.bind(this);
    this.state = {modalIsOpen: false};
  }

  login() {
    let ajax = new Ajax({
      method: 'GET',
      url: 'url'
    });

    ajax.send();
    ajax.on('success', () => {

    });
  }

  openModal() {
    this.setState({modalIsOpen: true});
  }

  closeModal() {
    this.setState({modalIsOpen: false});
  }

  render() {
    return (
      <div id="haka" onClick={this.login}>
        <img src={hakaLoginImage} onClick={this.openModal.bind(this)} alt="haka-login"/>
        <Modal
          isOpen={this.state.modalIsOpen}
          onRequestClose={this.closeModal.bind(this)}
          style={customStyles} >

          <button onClick={this.closeModal.bind(this)}>close</button>

        </Modal>

      </div>
    );
  }

}
