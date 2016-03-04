'use strict';

import baseConfig from './base';

let config = {
  appEnv: 'dist',
  loginTarget: '?target=https://www.avop.fi/user'
};

export default Object.freeze(Object.assign({}, baseConfig, config));
