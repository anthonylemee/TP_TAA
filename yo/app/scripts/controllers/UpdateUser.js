'use strict';

angular.module('runTracker')
  .controller('UpdateuserCtrl', function ($rootScope,$http,$scope) {
	  $scope.user = $rootScope.user;
	  $scope.create = {};
	  $scope.pass = {};
	  $scope.isCorrectPassword = function() {
		  if($scope.create.password != null && $scope.pass.passConfirm != null){
			  return angular.equals($scope.create.password, $scope.pass.passConfirm);
		  }
		  return false;
	  };
	  var radios = document.getElementsByName('sex');
		if($rootScope.user.sex == "H") {
			radios[0].checked = true;
		} else {
			radios[1].checked = true;
		}
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
  });
