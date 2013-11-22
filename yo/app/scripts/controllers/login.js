'use strict';

angular.module('runTracker')
  .controller('LoginCtrl', function ($scope,$http,$location,$rootScope) {
	  $scope.user = {};
	  $rootScope.user = {};
	    $scope.getUser = function() {
	    	if($scope.user.login != null && $scope.user.password != null){
	    		console.log($scope.user.login);
		    	$http.get("http://localhost:8080/taa/rest/Utilisateur/search/"+
		    		$scope.user.login).
		    	  success(function (data, status, headers, config) {
		    	    // ...
		    		  //var pass = data[x] if(pass == $scope.user.password)
		    		  console.log(data);
		    		  $rootScope.user = data;
		    		  $location.path("/accueil");
		    		  //else console.log("login / mot de passe incorrect")
		    	  }).
		    	  error(function (data, status, headers, config) {
		    	    // ...
		    		  console.log("login / mot de passe incorrect");
		    	  });
	    	} else {
	    		console.log("login / mot de passe inexistant");
	    	}
	    };
  });