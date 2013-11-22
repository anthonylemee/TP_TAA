'use strict';

angular.module('runTracker').controller('AccueilCtrl',
		function($scope,$http, $rootScope,$location) {
			$scope.user = {};
			if ($rootScope.user != null) {
				$scope.user = $rootScope.user;
			}
			$scope.goToSeances = function() {
				$location.path("/seances");
			};
			$scope.create = {};
			$scope.createUser = function (){
				$scope.utilisateur = {};
				if($scope.create.pseudo != null && $scope.create.name != null && $scope.create.first_name != null){
					console.log( $scope.create );
					$http.put("http://localhost:8080/taa/rest/Utilisateur/add",$scope.create)
					.success(function(data,status,headers,config){
				        console.log(data);
					}).error(function(data,status,headers,config) {
						console.log(data);
					});
				} else {
					console.log("un des elements manquant : pseudo, nom, prenom");
				}
			};
			
			$scope.updateUser = function (){
				console.log($scope.user);
				if($scope.user.pseudo != null && $scope.user.name != null && $scope.user.first_name != null){
					$http.put("http://localhost:8080/taa/rest/Utilisateur/update",$scope.user)
					.success(function(data,status,headers,config){
				        console.log(data);
					}).error(function(data,status,headers,config) {
						console.log(data);
					});
				} else {
					console.log("un des elements manquant : pseudo, nom, prenom");
				}
			};
		});