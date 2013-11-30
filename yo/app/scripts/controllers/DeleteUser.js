'use strict';

angular.module('runTracker')
  .controller('DeleteuserCtrl', function ($rootScope,$http,$scope) {
	  $scope.user = {};
	  $scope.user = $rootScope.user;
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
