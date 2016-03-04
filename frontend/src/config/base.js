'use strict';

// Settings configured here will be merged into the final config object.
export default {
  hakaLoginUrl: (currentDomain) => `/Shibboleth.sso/Login?target=${currentDomain}/user`
}
