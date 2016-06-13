
var app = angular.module('prestamos.controller',[]);

// Controlador de login.html
// El servicio debe de estar en la misma página???????
app.controller('controllerLogin', function($scope, Login, $location, $cookies,Factory) {

	$scope.user = "";
	$scope.password = "";

	$scope.login = function() {
		console.log("Login");
		Login.validar($scope.user, $scope.password).success(function(data) {
			console.log("Data: \n" + data);
			if (data == "") {
				alert(data);
				$scope.user = "";
				$scope.password = "";
			} else {
				Factory.login($scope.user, data.rol.codigo);
				
			}
		});

	};

});