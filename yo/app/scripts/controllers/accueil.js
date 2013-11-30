'use strict';

angular.module('runTracker').controller('AccueilCtrl',
		function($scope,$http, $rootScope,$location) {
			$scope.user = {};
			if ($rootScope.user != null) {
				$scope.user = $rootScope.user;
			}
			$scope.goSeances = function() {
				$location.path("/seances");
			};
			$scope.goAccueil = function() {
				$location.path("/accueil");
			};
			$scope.goDelete = function() {
				$location.path("/DeleteUser");
			};
			$scope.goParcours = function() {
				$location.path("/Parcours");
			};
			$scope.goUpdate = function() {
				$location.path("/UpdateUser");
			};
		});