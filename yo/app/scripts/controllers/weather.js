'use strict';

angular.module('runTracker').factory('weatherService', function($http) {
    return { 
      getWeather: function() {
        var weather = { temp: {}, clouds: null };
        $http.jsonp('http://api.openweathermap.org/data/2.5/weather?q=Rennes,at&units=metric&callback=JSON_CALLBACK').success(function(data) {
            if (data) {
                if (data.main) {
                    weather.temp.current = data.main.temp;
                    weather.temp.min = data.main.temp_min;
                    weather.temp.max = data.main.temp_max;
                }
                
                console.log(weather.temp.current);
                console.log(weather.temp.min);
                console.log(weather.temp.max);
                
                weather.clouds = data.clouds ? data.clouds.all : undefined;
                
                console.log(weather.clouds);
            }
        });

        return weather;
      }
    }; 
});

angular.module('runTracker').filter('temp', function($filter) {
    return function(input, precision) {
        if (!precision) {
            precision = 1;
        }
        var numberFilter = $filter('number');
        return numberFilter(input, precision) + '\u00B0C';
    };
});

angular.module('runTracker').controller('WeatherCtrl', function ($scope, weatherService) {
    $scope.weather = weatherService.getWeather();
});

angular.module('runTracker').directive('weatherIcon', function() {
    return {
        restrict: 'E', replace: true,
        scope: {
            cloudiness: '@'
        },
        controller: function($scope) {
            $scope.imgurl = function() {
                var baseUrl = 'https://ssl.gstatic.com/onebox/weather/128/';
                if ($scope.cloudiness < 20) {
                   //return baseUrl + 'sunny.png';
                	return '/images/weather/weatherClear.png';
                } else if ($scope.cloudiness < 90) {
                   //return baseUrl + '/partly_cloudy.png';
                	return '/images/weather/weatherSunnyCloudy.png';
                } else {
                	return '/images/weather/weatherCloudy.png';
                }
            };
        },
        template: '<div style="float:left"><img ng-src="{{ imgurl() }}"></div>'
    };
});
