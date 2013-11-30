'use strict';

describe('Controller: ParcoursCtrl', function () {

  // load the controller's module
  beforeEach(module('yoApp'));

  var ParcoursCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ParcoursCtrl = $controller('ParcoursCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
