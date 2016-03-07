import React from 'react';

export default class Error extends React.Component {
  render() {
    return (
      <div>
        <h2>Error {this.props.params.status}</h2>
      </div>
    )
  }
}

