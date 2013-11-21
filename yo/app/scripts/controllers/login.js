'use strict';

angular.module('runTracker')
  .controller('LoginCtrl', function ($scope,$http,$location) {
	  $scope.user = {};
	    $scope.getUser = function() {
	    	if($scope.user.login != null){
		    	$http({ method: 'GET', url: 'http://localhost:8080/taa/rest/Utilisateur/search/',
		    		data: { id: $scope.user.login },
		    		headers: { "Content-Type": "application/json; charset=utf-8" }
		    	}).
		    	  success(function (data, status, headers, config) {
		    	    // ...
		    		  alert(data)
		    	  }).
		    	  error(function (data, status, headers, config) {
		    	    // ...
		    		  alert(data)
		    	  });
	    	} else {
	    		alert("oups")
	    	}
	    }
  });

angular.module('runTracker')
	.factory('myService', function($http, $location) {
	   return {
	        getUser: function() {
	             // return the promise directly.
	             return $http.get('/rest/Utilisateur/search/'+$scope.user.login)
	                       .then(function(result) {
	                            // resolve the promise as the data
	                    	   	// $location.path("/")
	                    	   	return result.data;
	                        });
	        }
	   }
	});