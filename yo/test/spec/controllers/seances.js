'use strict';

describe('Controller: SeancesCtrl', function () {

  // load the controller's module
  beforeEach(module('yoApp'));

  var SeancesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SeancesCtrl = $controller('SeancesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
