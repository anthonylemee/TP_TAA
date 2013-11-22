'use strict';

angular.module('runTracker').controller('AccueilCtrl',
		function($scope, $rootScope) {
			$scope.user = {};
			if ($rootScope.user != null) {
				console.log($rootScope.user);
				$scope.user.avatar = $rootScope.user.id;
				$scope.user.birth = $rootScope.user.avatar;
			}
			console.log($scope.user.avatar);
		});
