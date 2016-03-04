'use strict';

import baseConfig from './base';

let config = {
  appEnv: 'test',
  loginTarget: '?target=https://avopfitest.csc.fi/user'
};

export default Object.freeze(Object.assign(baseConfig, config));
