'use strict';
angular
    .module('webApp')
    .config(function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl : '/home',
            controller : 'HomeCtrl as homeCtrl'
        }).when('/login', {
            templateUrl : '/login',
            controller : 'LoginCtrl as loginCtrl'
        }).otherwise('/');
    });