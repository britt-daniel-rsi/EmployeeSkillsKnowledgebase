<!doctype html>
<html >

  <head>
     <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>JSON Web Token / AngularJS / Spring Boot example</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" type="text/css" href="/css/esk.css"/>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.5/dist/css/bootstrap.css" />
<!-- <script type="text/javascript" src="/js/userController.js"></script>-->
<script type="text/javascript" src="/webjars/angularjs/1.4.0/angular.js"></script>
<script type="text/javascript" src="/webjars/angular-route/1.4.1/angular-route.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/router.js"></script>
<script type="text/javascript" src="/js/home.js"></script>
<script type="text/javascript" src="/js/navigation.js"></script>
<script type="text/javascript" src="/js/login.js"></script>

<!doctype html>
<html>
<head>
    <title>Hello AngularJS</title>

</head>

<body ng-app="webApp" ng-cloak class="ng-cloak">
<div ng-controller="NavigationCtrl as navCtrl" class="container">
    <ul class="nav nav-pills" role="tablist">
        <li class="active"><a href="#/">home</a></li>
        <li><a href="#/login">Login</a></li>
        <li ng-show="authenticated"><a href="" ng-click="navCtrl.logout()">logout</a></li>
    </ul>
</div>
<div ng-view class="container"></div>


</body>
</html>