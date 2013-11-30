'use strict';

angular.module('runTracker').controller('AccueilCtrl',
		function($scope,$http, $rootScope,$location) {
			$scope.user = {};
			if ($rootScope.user != null) {
				$scope.user = $rootScope.user;
				var radios = document.getElementsByName('sex');
				if($scope.user.sex == "H") {
					radios[0].checked = true;
				} else {
					radios[1].checked = true;
				}
			}
			$scope.goSeances = function() {
				$location.path("/seances");
			};
			$scope.goAccueil = function() {
				$location.path("/accueil");
			};
			$scope.updateUser = function (){
				console.log($scope.user);
				var radios = document.getElementsByName('sex');
				if(radios[0].checked){
					$scope.user.sex = 'H';
				}else {
					$scope.user.sex = 'F';
				}
				if($scope.user.pseudo != null && $scope.user.name != null && $scope.user.first_name != null){
					$http.put("http://localhost:8080/taa/rest/Utilisateur/update",$scope.user)
					.success(function(data,status,headers,config){
						$rootScope.user = data;
						$location.path("/accueil");
					}).error(function(data,status,headers,config) {
						console.log(data);
					});
				} else {
					console.log("un des elements manquant : pseudo, nom, prenom");
				}
			};
			
			$scope.deleteUser = function (){
				console.log($scope.user);
				if($scope.user.pseudo != null && $scope.user.name != null && $scope.user.first_name != null){
					//delete by id a faire plutot ! et eviter son propre ID
					$http.post("http://localhost:8080/taa/rest/Utilisateur/delete/"+2)
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