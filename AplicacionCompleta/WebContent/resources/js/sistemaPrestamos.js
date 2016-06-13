/**
 * 
 */

var app = angular.module('prestamos', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/',{
		templateUrl:'login.html',
		controller: 'controllerLogin'
	});
	
	
}]);

//Controlador de login.html
app.controller('controllerLogin', function($scope){
	
	
	
});




