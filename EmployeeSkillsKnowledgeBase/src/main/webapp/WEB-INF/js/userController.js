var app = angular.module('eskApp', []);
app.controller('userController', function($scope,$http) {
var url="ESK/jersey/user/list";
   $http.get(url).success( function(response) { $scope.users = response; });
});