'use strict';
angular
    .module('webApp')
    .controller('HomeCtrl',['$scope', '$http', function($scope, $http) {
        console.log("HomeCtrl created.");

        var vm = this;
        vm.greeting = "Hello world";

        $http.get('/ESK/jersey/user/list').success(function(data) {
            $scope.users = data;
        })

    }]);