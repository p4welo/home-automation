(function () {
	'use strict';

	angular
		.module('homeAutomation')
		.config(routerConfig);

	/** @ngInject */
	function routerConfig($stateProvider, $urlRouterProvider) {
		$stateProvider
			.state('home', {
				templateUrl: 'app/main/main.html',
				abstract: true
			});

		$urlRouterProvider.otherwise('/devices');
	}
})();
