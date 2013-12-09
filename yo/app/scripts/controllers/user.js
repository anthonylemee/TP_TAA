'use strict';

angular.module('runTracker').controller(
		'UserCtrl',
		function($scope, $http, $rootScope, $location) {
			// Menu
			$scope.user = {};

			if ($rootScope.user != null) {
				
				$scope.user = $rootScope.user;
				$scope.username = $scope.user.pseudo;
				$scope.display = "block !important";

				$http.get(
						"http://localhost:8080/taa/rest/seances/search/of/"
								+ $scope.user.pseudo).success(
						function(data, status, headers, config) {
							$scope.seancesOfUser = data;
							console.log("Succès de la récupération des séances de " + $scope.user.pseudo);
							console.log($scope.seancesOfUser);
						}).error(
						function(data, status, headers, config) {
							console.log("Impossible de récupérer les séances de " + $scope.user.pseudo);
						});

			} else {
				$scope.username = "";
				$scope.display = "none !important";
			}

			console.log('DISPLAY = ' + $scope.display);
			console.log('USERNAME = ' + $scope.username);

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

			$scope.date = Date.now();

		});