var app = angular.module('prestamos.controller', []);

// Controlador de login.html
// El servicio debe de estar en la misma página???????
app.controller('controllerLogin', function($scope, Login, $location, $cookies,
		Factory) {

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

// Controlador de indexInvestigador
app.controller('controllerInvestigador', function($scope, $location, $cookies) {
	$scope.user = $cookies.nombreUsuario;
	$scope.rol = 'Investigador';

});

app.controller('controllerAdministrador',
		function($scope, $location, $cookies) {
			$scope.user = $cookies.nombreUsuario;
			$scope.rol = 'Administrador';

		});

app.controller('controllerListaReservas', function($scope, $location, $cookies,
		Reserva) {
	$scope.user = $cookies.nombreUsuario;
	$scope.rol = 'Administrador';
	Reserva.obtenerReserva().success(function(data) {
		var lista = data.reservaDTOWS;
		var l = lista.length;
		var arreglo;
		console.log(lista);
		console.log(l);
		console.log(typeof (lista));
		if (lista.length > 1) {
			arreglo = lista;
		} else {
			var arr = [];
			arr.push(lista);
			console.log(arr);
			arreglo = arr;
		}
		console.log("Arreglo");
		console.log(arreglo);
		var listaReservas = [];
		for(var ele = 0; ele < arreglo.length;ele++){
			console.log(ele);
			if(arreglo[ele].aprobado == 'SI'){
				listaReservas.push(arreglo[ele]);
			}
		}
		$scope.reservas = listaReservas;
	});

	
	$scope.rechazar = function(reserva) {

		Reserva.modificarReserva(reserva.codigo, $scope.user).success(
				function(data) {

					if (data == '') {
						$location.url('/listaReservas');
					} else {
						alert(data);
					}
				});

	}

});

// Controlador de listarDispositivos
app.controller('controllerListaDispositivos', function($scope, Dispositivo,
		$location, $cookies, Factory) {
	$scope.user = $cookies.nombreUsuario;
	$scope.rol = 'Investigador';
	Dispositivo.obtenerDispositivos().success(function(data) {
		var lista = data.dispositivoDTOWS;
		var l = lista.length;
		console.log(lista);
		console.log(l);
		console.log(typeof (lista));
		if (lista.length > 1) {
			$scope.dispositivos = lista;
		} else {
			var arr = [];
			arr.push(lista);
			console.log(arr);
			$scope.dispositivos = arr;
		}
	});
	$scope.reservar = function(item) {
		$cookies.dispositivo = item;
		console.log(item);

		console.log("Hola");
		$location.url('/solicitudReserva');

	}
});

app.controller('controllerSolicitud',
		function($cookies, $location, $scope, Reserva) {
			$scope.user = $cookies.nombreUsuario;
			$scope.rol = 'Investigador';
			$scope.dispositivo = $cookies.dispositivo;

			$scope.aceptar = function() {

				var date;
				date = new Date();
				date = $scope.fechaPrestamo.getUTCFullYear()
						+ '-'
						+ ('00' + ($scope.fechaPrestamo.getUTCMonth() + 1))
								.slice(-2)
						+ '-'
						+ ('00' + $scope.fechaPrestamo.getUTCDate()).slice(-2)
						+ ' '
						+ ('00' + $scope.fechaPrestamo.getUTCHours()).slice(-2)
						+ ':'
						+ ('00' + $scope.fechaPrestamo.getUTCMinutes())
								.slice(-2)
						+ ':'
						+ ('00' + $scope.fechaPrestamo.getUTCSeconds())
								.slice(-2);
				var fecha = date.replace(' ', 'T');
				console.log(fecha);
				console.log($scope.numeroHoras);

				Reserva.insertarReserva($scope.dispositivo.codigo, $scope.user,
						fecha, $scope.numeroHoras).success(function(data) {

					if (data == "") {
						$location.url("/listaDispositivos");
					} else {
						alert(data);
					}
				});
			};

		});
