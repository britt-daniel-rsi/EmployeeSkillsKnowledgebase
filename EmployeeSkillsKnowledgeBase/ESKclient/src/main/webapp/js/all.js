var app = angular.module('eskApp', []);
app.controller('userController', function($scope,$http) {
var url="ESK/jersey/user/list";
   $http.get(url).success( function(response) { $scope.users = response; });
});
'use strict';

angular.module('app', ['ngRoute', 'ngMessages', 'ngAria', 'xeditable', 'app.constants', 'app.directives', 'app.controllers', 'app.services']);
'use strict';

angular.module('app').config([ '$routeProvider', '$httpProvider', '$locationProvider', function($routeProvider, $httpProvider, $locationProvider) {

    $locationProvider.html5Mode(true);

    var user = ['$rootScope', 'userService','storageService', 'storageConstant', function ($rootScope, userService, storageService, storageConstant) {
        var user =  storageService.getSessionItem(storageConstant.USER);

        if(user === null || user === undefined) {
            userService.retrieve()
                .then(function (user) {
                    storageService.setSessionItem(storageConstant.USER, user);

                    $rootScope.user = user;
                });
        } else {
            $rootScope.user = user;
        }
    }];

    var clear = ['$rootScope', 'storageService', 'storageConstant', function ($rootScope, storageService, storageConstant) {
        storageService.removeSessionItem(storageConstant.USER);

        delete $rootScope.user;
    }];

	// ======= router configuration =============

	$routeProvider
		.when('/main', {
            title: 'Main',
			templateUrl: 'html/partials/view/main.html'
		})
		.when('/customer/search', {
            title: 'Customer Search',
			controller: 'CustomerController',
			templateUrl: 'html/partials/view/customer_search.html',
            resolve: {
                user: user
            }
		})
		.when('/login', {
            title: 'Login',
			templateUrl: 'html/partials/view/login.html',
            controller: 'LoginController',
            resolve: {
                clear: clear
            }
		})
		.otherwise({ redirectTo : "/main"});
	
	// ======== http configuration ===============

    $httpProvider.interceptors.push(function ($q, $location, messageService, storageService, storageConstant) {
        return {
            'request': function(request) {
                messageService.clearError();

                var authToken = storageService.getSessionItem(storageConstant.AUTH_TOKEN);

                if (authToken) {
                    request.headers['X-AUTH-TOKEN'] = authToken;
                }

                return request;
            },
            'response': function (response) {
                return response;
            },
            'responseError': function (rejection) {
                switch (rejection.status) {
                    case 400: {
                        break;
                    }
                    case 401:
                    case 403: {
                        $location.path("/login");

                        break;
                    }
                    case 500: {
                        break;
                    }
                    default : {
                        messageService.error("UNKNOWN_ERROR", "An error has occurred, please try again.");

                        break;
                    }
                }

                return $q.reject(rejection);
            }
        };
    });
}]);
'use strict';

angular.module('app.constants', []);
'use strict';

angular.module('app.controllers', ['app.services']);
'use strict';

angular.module('app.directives', ['app.services']);

'use strict';

angular.module('app').run(['$rootScope', '$http', '$location', 'titleService', function ($rootScope, $http, $location, titleService) {

    $rootScope.navigateTo = "/main";

    $rootScope.$on('$routeChangeSuccess', function(event, next, current) {
        titleService.changeTitle();

        if ($location.path().indexOf("/login") == -1) {
            $rootScope.navigateTo = $location.path();
        }
    });
}]);
'use strict';

angular.module('app.services', ['app.constants']);
'use strict';

angular.module('app.constants').constant('propertiesConstant', {
    API_URL: '/api'
});
'use strict';

angular.module('app.constants').constant('storageConstant', {
    USER: 'user',
    AUTH_TOKEN: 'authToken'
});
'use strict';

angular.module('app.controllers').controller('CustomerController',['$rootScope', '$scope', 'customerService', 'messageService', function ($rootScope, $scope, customerService, messageService) {

    customerService.getCustomers().then(
        function success(customers) {
            $scope.customers = customers;
        },
        function error() {
            messageService.error("CUSTOMERS_GET_FAILURE", "Oooooops something went wrong, please try again");
        });

    $scope.remove = function remove(id) {
        customerService.deleteCustomer(id).then(
            function success(response) {
                if (response) {
                    angular.forEach($scope.customers, function (customer, index) {
                        if (id == customer.id) {
                            $scope.customers.splice(index, 1);
                        }
                    });
                }
            },
            function error() {
                messageService.error("CUSTOMER_DELETE_FAILURE", "Oooooops something went wrong, please try again");
            });
    };

    $scope.save = function (id) {
        angular.forEach($scope.customers, function (customer) {
                if (id == customer.id) {
                    customerService.saveCustomer(customer).then(
                        function success(response) {});
                }
            },
            function error() {
                messageService.error("CUSTOMER_SAVE_FAILURE", "Oooooops something went wrong, please try again");
            });
    };
}]);
'use strict';

angular.module('app.controllers').controller('LoginController', ['$location', '$rootScope', '$scope', 'authenticationService', 'messageService', function ($location, $rootScope, $scope, authenticationService, messageService) {
    $scope.login = function (credentials) {
        authenticationService.login(credentials)
            .then(function() {
                $location.path($rootScope.navigateTo);
            })
            .catch(function () {
                messageService.error("LOGIN_FAILURE", "We were unable to log you in, please try again.");
            });
    };
}]);
'use strict';

angular.module('app.controllers').controller('MenuController', ['$location', '$scope', 'authenticationService', 'messageService', function ($location, $scope, authenticationService, messageService) {
    $scope.logout = function logout() {
        authenticationService.logout()
            .then(function() {
                $location.path("/logout");
            })
            .catch(function () {
                messageService.error("LOGOUT_FAILURE", "We were unable to log you out, please try again.");
            });
    };
}]);
'use strict';

angular.module('app.directives').directive('exampleFocus', function ($timeout) {
    return {
        scope: {
            trigger: '@exampleFocus'
        },
        link: function (scope, element) {
            scope.$watch('trigger', function () {
                $timeout(function () {
                    element[0].focus();
                });
            });
        }
    };
});

'use strict';

angular.module('app.services').service('authenticationService', ['$http', '$q', 'base64Service', 'storageService', 'storageConstant', 'propertiesConstant', function ($http, $q, base64Service, storageService, storageConstant, propertiesConstant) {
    this.login = function (credentials) {
        var d = $q.defer();

        $http.defaults.headers.common.Authorization = 'Basic ' + base64Service.encode(credentials.email + ':' + credentials.password);

        $http.post(propertiesConstant.API_URL + '/auth/login', null)
            .success(function (data, status, headers, config) {

                storageService.setSessionItem(storageConstant.AUTH_TOKEN, headers('X-AUTH-TOKEN'));

                delete $http.defaults.headers.common.Authorization;

                d.resolve();
            })
            .error(function () {
                d.reject();
            });

        return d.promise;
    };

    this.logout = function () {
        var d = $q.defer();

        $http.post(propertiesConstant.API_URL + '/auth/logout', null)
            .success(function () {

                storageService.removeSessionItem(storageConstant.AUTH_TOKEN);
                storageService.removeSessionItem(storageConstant.USER);

                d.resolve();
            })
            .error(function () {
                d.reject();
            });

        return d.promise;
    };
}]);
'use strict';

angular.module('app.services').service('base64Service', function () {
    var keyStr = "ABCDEFGHIJKLMNOP" +
        "QRSTUVWXYZabcdef" +
        "ghijklmnopqrstuv" +
        "wxyz0123456789+/" +
        "=";
    this.encode = function (input) {
        var output = "",
            chr1, chr2, chr3 = "",
            enc1, enc2, enc3, enc4 = "",
            i = 0;

        while (i < input.length) {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);

            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;

            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }

            output = output +
            keyStr.charAt(enc1) +
            keyStr.charAt(enc2) +
            keyStr.charAt(enc3) +
            keyStr.charAt(enc4);
            chr1 = chr2 = chr3 = "";
            enc1 = enc2 = enc3 = enc4 = "";
        }

        return output;
    };

    this.decode = function (input) {
        var output = "",
            chr1, chr2, chr3 = "",
            enc1, enc2, enc3, enc4 = "",
            i = 0;

        // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

        while (i < input.length) {
            enc1 = keyStr.indexOf(input.charAt(i++));
            enc2 = keyStr.indexOf(input.charAt(i++));
            enc3 = keyStr.indexOf(input.charAt(i++));
            enc4 = keyStr.indexOf(input.charAt(i++));

            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;

            output = output + String.fromCharCode(chr1);

            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }

            chr1 = chr2 = chr3 = "";
            enc1 = enc2 = enc3 = enc4 = "";
        }
    };
});
'use strict';

angular.module('app.services').service('customerService', [ '$http', '$q', 'propertiesConstant', function ($http, $q, propertiesConstant) {
    this.getCustomers = function () {
        var d = $q.defer();

        $http.get(propertiesConstant.API_URL + '/customer/customers/retrieve')
            .success(function (customers) {
                d.resolve(customers);
            })
            .error(function () {
                d.reject();
            });

        return d.promise;
    };

    this.deleteCustomer = function (id) {
        var d = $q.defer();

        $http.delete(propertiesConstant.API_URL + '/customer/delete/' + id)
            .success(function (response) {
                d.resolve(response);
            })
            .error(function () {
                d.reject();
            });

        return d.promise;
    };

    this.saveCustomer = function (customer) {
        var d = $q.defer();

        $http.post(propertiesConstant.API_URL + '/customer/save', customer)
            .success(function (response) {
                d.resolve(response);
            })
            .error(function () {
                d.reject();
            });

        return d.promise;
    };
}]);
'use strict';

angular.module('app.services').service('messageService', ['$rootScope', function ($rootScope) {
    $rootScope.errors = [];
    $rootScope.alerts = [];

    this.error = function (code, message) {
        $rootScope.errors.push({ code: code, message: message });
    };

    this.info = function (code, message) {
        $rootScope.alerts.push({ code: code, message: message });
    };

    this.clearError = function () {
        $rootScope.errors = [];
    };

    this.clearInfo = function () {
        $rootScope.alerts = [];
    }
}]);
'use strict';

angular.module('app.services').service('storageService', ['$rootScope', '$window', function ($rootScope, $window) {
    this.getLocalItem = function (key) {
        return JSON.parse($window.localStorage.getItem(key));
    };

    this.setLocalItem = function (key, item) {
        $window.localStorage.setItem(key, JSON.stringify(item));
    };

    this.removeLocalItem = function(key) {
        $window.localStorage.removeItem(key);
    };

    this.getSessionItem = function (key) {
        return JSON.parse($window.sessionStorage.getItem(key));
    };

    this.setSessionItem = function (key, item) {
        $window.sessionStorage.setItem(key, JSON.stringify(item));
    };

    this.removeSessionItem = function(key) {
        $window.sessionStorage.removeItem(key);
    }
}]);
'use strict';

angular.module('app.services').service('titleService', ['$route', '$window', function ($route, $window) {

    var title = $window.document.title;

    this.changeTitle = function () {
        $window.document.title = title + " - " + $route.current.title;
    };
}]);
'use strict';

angular.module('app.services').service('userService', ['$http', '$q', 'propertiesConstant', function ($http, $q, propertiesConstant) {
    this.retrieve = function retrieve() {
        var d = $q.defer();

        $http.get(propertiesConstant.API_URL + '/user/retrieve')
            .success(function (user) {
                d.resolve(user);
            })
            .error(function () {
                d.reject();
            });

        return d.promise;
    };
}]);
