import React from 'react';
import Header from '../header/Header';
import Footer from '../footer/Footer';
import Userprofile from './userprofile';

export default class User extends React.Component {

    render() {
      return (
        <div>
          <Header></Header>
          <div className="container">
            <Userprofile></Userprofile>
            <Footer></Footer>
          </div>
        </div>
      );
    }

}
