var app = angular.module('app', ['ngRoute', 'ngSanitize']);


app.config(['$routeProvider', '$locationProvider',
  function ($routeProvider, $locationProvider)
  {
    $routeProvider.otherwise(
    {
      redirectTo: '/'
    })
    .when('/',
    {
      templateUrl: GBL_COFG.urlTemplate('inicio.html')
    })
    .when('/info',
    {
      templateUrl: GBL_COFG.urlTemplate('info.html'),
/*      controller: 'ngAppControllerAbout'*/
    })
    .when('/test',
    {
      templateUrl: GBL_COFG.urlTemplate('test.html'),
      controller: 'ng-app-controller-test'
    })
    .when('/kirby',
    {
      templateUrl: GBL_COFG.urlTemplate('kirby.html'),
    })
     .when('/formInsert', //controlador de java
    {
      templateUrl: GBL_COFG.urlTemplate('formInsert.html'),
      controller: 'ng-app-controller-edit'
    })
    .when('/search',
    {
      templateUrl: GBL_COFG.urlTemplate('search.html'),
      controller: 'ng-app-controller-search'
    })
    ;
  }]);


