angular.module('runTracker', [])
.service('infosUser', function () {
    var infosUser = '[]';

    return {
        getInfosUser: function () {
            return infosUser;
        },
        setInfosUser: function(value) {
        	infosUser = value;
        }
    };
});