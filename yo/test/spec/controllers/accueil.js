'use strict';

describe('Controller: AccueilCtrl', function () {

  // load the controller's module
  beforeEach(module('yoApp'));

  var AccueilCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AccueilCtrl = $controller('AccueilCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
