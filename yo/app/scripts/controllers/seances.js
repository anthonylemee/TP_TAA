'use strict';

angular.module('runTracker').controller('SeancesCtrl',
		function($rootScope,$location,$http,$scope) {
			$scope.create = {};
			$scope.user = {};
			$scope.parcours = {};
			$scope.sports = {};
			$scope.meteos = {};
			$scope.time = {};
			$scope.user = $rootScope.user;
			$http.get("http://localhost:8080/taa/rest/sports").success(
					function(data, status, headers, config) {
						$scope.sports = data;
					}).error(function(data, status, headers, config) {
				console.log(data);
			});
			$http.get("http://localhost:8080/taa/rest/meteos").success(
					function(data, status, headers, config) {
						$scope.meteos = data;
					}).error(function(data, status, headers, config) {
				console.log(data);
			});
			$scope.createSeance = function (){
				console.log($scope.parcours);
				console.log($scope.sport);
				console.log($scope.meteo);
				$scope.create.sport = $scope.sport;
				$scope.create.meteo = $scope.meteo;
				console.log($scope.create);
				if($scope.user != null) {
					$http.put("http://localhost:8080/taa/rest/parcours/add",$scope.parcours)
					.success(function(data,status,headers,config){
				        console.log(data);
				        $scope.create.parcours = data;
						$scope.create.beginDate = $scope.time.timeBegin.toLocaleString();
						$scope.create.timeFin = $scope.time.timeFin.toLocaleString();
						$scope.create.utilisateur = $scope.user;
						$http.put("http://localhost:8080/taa/rest/seances/add",$scope.create)
						.success(function(data,status,headers,config){
					        console.log(data);
					        $location.path("/accueil");
						}).error(function(data,status,headers,config) {
							console.log(data);
						});
					}).error(function(data,status,headers,config) {
						console.log(data);
					});
				} else {
				console.log("vous n'etes pas connecté");
			}
			};
		});