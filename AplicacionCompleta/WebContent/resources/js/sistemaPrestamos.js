var app = angular.module('prestamos', [ 'ngRoute', 'ngCookies', 'prestamos.controller', 'prestamos.service' ]);

app.config([ '$routeProvider', function($routeProvider) {

	// Ruta para el login
	$routeProvider.when('/', {
		templateUrl : 'login.html',
		controller : 'controllerLogin'
	});

	// Investigador
	// Ruta para: Bienvenido investigador
	$routeProvider.when('/indexInvestigador', {
		templateUrl : 'investigador/indexInvestigador.html',
		controller : 'controllerInvestigador'
	});

	// Ruta para: Listar dispositivos
	$routeProvider.when('/listaDispositivos', {
		templateUrl : 'investigador/listarDispositivos.html',
		controller : 'controllerInvestigador'
	});

	// Ruta para: Solicitar una reserva
	$routeProvider.when('/solicitudReserva', {
		templateUrl : 'investigador/solicitudReserva.html',
		controller : 'controllerInvestigador'
	});

	// Administrador
	// Ruta para: Bienvenido Administrador
	$routeProvider.when('/indexAdministrador', {
		templateUrl : 'administrador/indexAdministrador.html',
		controller : 'controllerAdministrador'
	});

	// Ruta para: Listar reservas
	$routeProvider.when('/listaReservas', {
		templateUrl : 'administrador/listarReservas.html',
		controller : 'controllerAdministrador'
	});

} ]);
