'use strict';

var url = require('url');
var proxy = require('proxy-middleware');

var apiProxy = url.parse('http://localhost:8080/api/');
apiProxy.route = '/api';

module.exports = function() {
  return [proxy(apiProxy)];
};
