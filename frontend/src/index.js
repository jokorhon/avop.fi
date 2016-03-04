import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, browserHistory, Redirect} from 'react-router';
import AsyncProps from 'async-props'
import Main from './components/Main';
import Userprofile from './components/user/userprofile';
import Home from './components/home/Home';

// Render the main component into the dom
// enable push state later: history={browserHistory}
ReactDOM.render(
  <Router render={(props) => <AsyncProps {...props}/>}>
    <Redirect from="/" to="/home" />
    <Route path="/" component={Main}>
      <Route path="home" component={Home} />
      <Route path="user" component={Userprofile} />
      <Route path="*" component={Main} />
    </Route>
  </Router>,
  document.getElementById('container')
);
