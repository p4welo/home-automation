(function () {
	'use strict';

	angular
		.module('homeAutomation')
		.config(routerConfig);

	/** @ngInject */
	function routerConfig($stateProvider) {
		$stateProvider
			.state('home.devices', {
				url: '/devices',
				controller: 'devicesController',
				controllerAs: 'vm',
				templateUrl: 'app/devices/devices.html'
			});
	}

})();
