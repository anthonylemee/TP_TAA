'use strict';

angular
		.module('runTracker')
		.directive(
				'helloMaps',
				function($routeParams) {
					return function(scope,elem, attrs) {
						var mapOptions, latitude = attrs.latitude, longitude = attrs.longitude, map, mapStyles, markers = $routeParams.markers;

						latitude = latitude && parseFloat(latitude, 10);
						longitude = longitude && parseFloat(longitude, 10);

						mapStyles = [ {
							featureType : 'all',
							stylers : [ {
								hue : '#0000b0'
							}, {
								invert_lightness : 'true'
							}, {
								saturation : -30
							} ]
						} ];

						mapOptions = {
							zoom : 2,
							disableDefaultUI : true,
							center : new google.maps.LatLng(latitude, longitude),
							mapTypeId : google.maps.MapTypeId.ROADMAP,
							styles : mapStyles
						};

						map = new google.maps.Map(elem[0], mapOptions);
						
						var path = new google.maps.Polyline({
							path : markers,
							strokeColor : "#FF0000",
							strokeOpacity : 1.0,
							strokeWeight : 2
						});

						path.setMap(map);

					};
				});

angular.module('runTracker').controller('ParcoursCtrl',
		function($scope, $routeParams, $http) {

			console.log("Parcours : 	" + $routeParams.id);

			$routeParams.markers = [];
			$http.get("http://localhost:8080/taa/rest/ptsgps/search/Parcours/" + $routeParams.id).success(
					function(data, status, headers, config) {
						
					}).error(function(data, status, headers, config) {
				console.log("error" + data);
			}).then((function(data){
				console.log(data);
				$scope.myMakers = [];
				for (var point in data["data"]) {
					console.info(new google.maps.LatLng(data["data"][point].latitude, data["data"][point].longitude));
					$scope.myMakers += ["coucou" + point];
					console.info("Markers : " + $scope.myMarkers);
				}
				
			}));

			
			$scope.latitude = 48.100;
			$scope.longitude = -1.667;

		});

angular.service('markersService', function() {
	this.markers = [];
	this.getMarkerByTodoId = function(todoId) {
		var marker, i;
		for (i = this.markers.length - 1; i >= 0; i--) {
			marker = this.markers[i];
			if (marker.get("id") === todoId) {
				return marker;
			}
		}
		return false;
	};
});