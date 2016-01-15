(function () {
	'use strict';

	angular
		.module('homeAutomation')
		.run(runBlock);

	/** @ngInject */
	function runBlock($log) {

		$log.debug('runBlock end');
	}

})();
