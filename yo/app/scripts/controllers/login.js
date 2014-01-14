'use strict';

angular.module('runTracker')
  .controller('LoginCtrl', function ($scope,$http,$location,$rootScope) {
	  $scope.user = {};
	  $rootScope.user = {};
	    $scope.getUser = function() {
	    	if($scope.user.login != null && $scope.user.password != null){
		    	$http.get("http://localhost:8080/taa/rest/Utilisateur/search/"+
		    		$scope.user.login).
		    	  success(function (data, status, headers, config) {
		    	    // ...
		    		  	  if(data.password == $scope.user.password){
			    		  console.log(data);
			    		  $rootScope.user = data;
			    		  angular.element( document.querySelector( '.alert-danger' ) ).css('display', 'none');
			    		  angular.element( document.querySelector( '.alert-info' ) ).css('display', 'none');
			    		  angular.element( document.querySelector( '.alert-warning' ) ).css('display', 'none');
			    		  angular.element( document.querySelector( '.alert-success' ) ).css('display', 'block');
			    		  angular.element( document.querySelector( '.alert-success' ) ).html("Connexion réussie");
			    		  $location.path("/accueil");
		    		  }
		    		  //else console.log("login / mot de passe incorrect")
		    	  }).
		    	  error(function (data, status, headers, config) {
		    	    // ...
		    		  console.log("login / mot de passe incorrect");
		    		  angular.element( document.querySelector( '.alert-danger' ) ).css('display', 'block');
		    		  angular.element( document.querySelector( '.alert-info' ) ).css('display', 'none');
		    		  angular.element( document.querySelector( '.alert-warning' ) ).css('display', 'none');
		    		  angular.element( document.querySelector( '.alert-success' ) ).css('display', 'none');
		    		  angular.element( document.querySelector( '.alert-danger' ) ).html("login / mot de passe incorrect");
		    	  });
	    	} else {
	    		console.log("login / mot de passe inexistant");
	    	};
	    };
  });