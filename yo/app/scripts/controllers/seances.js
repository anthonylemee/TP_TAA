'use strict';

angular.module('runTracker')
  .controller('SeancesCtrl', function ($http,$scope,$rootScope,$location) {
	  $scope.create = {};
	  $scope.pass = {};
	  $scope.isCorrectPassword = function() {
		  if($scope.create.password != null && $scope.pass.passConfirm != null){
			  return angular.equals($scope.create.password, $scope.pass.passConfirm);
		  }
		  return false;
	  };
		$scope.createUser = function (){
			$scope.utilisateur = {};
			if($scope.create.pseudo != null && $scope.create.name != null && $scope.create.first_name != null){
				if($scope.create.password != null && $scope.pass.passConfirm != null && $scope.create.password == $scope.pass.passConfirm){
					var radios = document.getElementsByName('sex');
					if(radios[0].checked){
						$scope.create.sex = 'H';
					}else {
						$scope.create.sex = 'F';
					}
					$http.put("http://localhost:8080/taa/rest/Utilisateur/add",$scope.create)
					.success(function(data,status,headers,config){
						  $rootScope.user = data;
			    		  $location.path("/accueil");
					}).error(function(data,status,headers,config) {
						console.log(data);
					});
				} else {
					console.log("mots de passes différents");
				}
			} else {
				console.log("un des elements manquant : pseudo, nom, prenom");
			}
		};
  });
