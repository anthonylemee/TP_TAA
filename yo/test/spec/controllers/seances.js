'use strict';

describe('Controller: SeancesController', function () {

  // load the controller's module
  beforeEach(module('runTracker'));

  var SeancesCtrl,scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SeancesCtrl = $controller('SeancesController', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
