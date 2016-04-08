import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, IndexRoute, browserHistory} from 'react-router';
import AsyncProps from 'async-props'
import Main from './components/Main';
import Error from './components/Error';
import Userprofile from './components/user/userprofile';
import Home from './components/home/Home';

// Render the main component into the dom
ReactDOM.render(
  <Router history={browserHistory} render={(props) =>
   <AsyncProps {...props}
    renderLoading={() => <div>Loading...</div>}/>}>
    <Route path="/" component={Main}>
      <IndexRoute component={Home} />
      <Route path="user" component={Userprofile} />
      <Route path="error/:status" component={Error} />
      <Route path="*" component={Error}/>
    </Route>
  </Router>,
  document.getElementById('container')
);
