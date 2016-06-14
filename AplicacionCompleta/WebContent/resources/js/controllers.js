
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

//Controlador de indexInvestigador
app.controller('controllerInvestigador', function($scope, $location, $cookies) {
	$scope.user = $cookies.nombreUsuario;
	$scope.rol = 'Investigador';
	$scope.mostrarDispositivos = function(){
		$location.url('/listaDispositivos');
	};
});
//Controlador de listarDispositivos
app.controller('controllerListaDispositivos', function($scope, Dispositivo, $location, $cookies,Factory) {
		$scope.user = $cookies.nombreUsuario;
		$scope.rol = 'Investigador';
		Dispositivo.obtenerDispositivos().success(function(data) {	
			var lista = data.dispositivoDTOWS;
			var l = lista.length;
			console.log(lista);
			console.log(l);
			console.log(typeof(lista));
			if(lista.length > 1){
				$scope.dispositivos = lista;
			}else{
				var arr = [];
				arr.push(lista);
				console.log(arr);
				$scope.dispositivos = arr;
			}
		});
});
