'use strict';

import baseConfig from './base';

let config = {
  appEnv: 'dev',
  hakaLoginUrl: (currentDomain) => `${currentDomain}/user`
};

export default Object.freeze(Object.assign({}, baseConfig, config));
