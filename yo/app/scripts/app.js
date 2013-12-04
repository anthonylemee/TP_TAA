'use strict';

angular.module('runTracker', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute'
])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/login', {
        templateUrl: 'views/Login.html',
        controller: 'LoginCtrl'
      })
      .when('/accueil', {
        templateUrl: 'views/accueil.html',
        controller: 'UserCtrl'
      })
      .when('/seances', {
        templateUrl: 'views/seances.html',
        controller: 'SeancesCtrl'
      })
      .when('/SignIn', {
        templateUrl: 'views/SignIn.html',
        controller: 'SigninCtrl'
      })
      .when('/DeleteUser', {
        templateUrl: 'views/DeleteUser.html',
        controller: 'DeleteuserCtrl'
      })
      .when('/Parcours', {
        templateUrl: 'views/Parcours.html',
        controller: 'ParcoursCtrl'
      })
      .when('/UpdateUser', {
        templateUrl: 'views/UpdateUser.html',
        controller: 'UpdateuserCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
