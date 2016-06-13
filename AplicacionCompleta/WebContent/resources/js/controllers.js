
var app = angular.module('prestamos.controller',[]);

// Controlador de login.html
// El servicio debe de estar en la misma página???????
app.controller('controllerLogin', function($scope, Login, $location, $cookies) {

	$scope.user = "";
	$scope.password = "";

	$scope.login = function() {
		console.log("Login");
		Login.validar($scope.user, $scope.password).success(function(data) {
			console.log("Data: \n" + data);
			if (data == "") {
				alert(data);
			} else {
				$cookies.usuario = $scope.user;
				if (data.rol.codigo == 1) {
					$location.url('/indexAdministrador');
				} else  {
					$location.url('/indexInvestigador');
				}
			}
		});

	};

});