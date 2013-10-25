'use strict';

angular.module('yoApp')
  .controller('MainCtrl', function ($scope, $resource) {
    var Book = $resource('./rest/books/:isbn');
    $scope.books = Book.query();
  });	  

/*angular.module('yoApp').controller('MainCtrl', function($scope) {
    $scope.uiConfig = {
      calendar:{
        height: 450,
        editable: true,
        header:{
          left: 'month basicWeek basicDay agendaWeek agendaDay',
          center: 'title',
          right: 'today prev,next'
        },
        dayClick: $scope.alertEventOnClick,
        eventDrop: $scope.alertOnDrop,
        eventResize: $scope.alertOnResize
      }
    };
});*/

