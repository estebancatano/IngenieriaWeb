var app = angular.module('prestamos', [ 'ngRoute', 'ngCookies',
		'prestamos.controller', 'prestamos.service' ]);

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
		controller : 'controllerListaDispositivos'
	});

	// Ruta para: Solicitar una reserva
	$routeProvider.when('/solicitudReserva', {
		templateUrl : 'investigador/solicitudReserva.html',
		controller : 'controllerSolicitud'
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

// se ejecuta cuando se inicia el modulo angular
app.run(function($rootScope, Factory) {
	// Se ejecuta cada vez que cambia la ruta
	$rootScope.$on('$routeChangeStart', function() {
		// llamamos a checkStatus, el cual lo hemos definido en la factoria auth
		// la cu�l hemos inyectado en la acci�n run de la aplicaci�n
		Factory.validarEstado();
	});
});
