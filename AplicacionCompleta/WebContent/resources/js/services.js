var URL_LOGIN = 'http://localhost:8080/SistemaPrestamos/rest/Usuario/Validar';
var URL_DISPOSITIVO = 'http://localhost:8080/SistemaPrestamos/rest/Dispositivo/Listar';
var URL_RESERVA = 'http://localhost:8080/SistemaPrestamos/rest/Reserva/Insertar';
var URL_LISTA_RESERVAS = 'http://localhost:8080/SistemaPrestamos/rest/Reserva/Listar';
var URL_MODIFICAR_RESERVA = 'http://localhost:8080/SistemaPrestamos/rest/Reserva/Actualizar';
var app = angular.module('prestamos.service', []);

app.service('Login', function($http) {
	this.validar = function(usuario, contrasena) {
		console.log("Servicio");
		console.log("Usuario: " + usuario);
		console.log("Contrasena: " + contrasena);
		return $http({
			method : 'GET',
			url : URL_LOGIN,
			params : {
				login : usuario,
				clave : contrasena
			}
		});
	}

});

app.service('Dispositivo', function($http) {
	this.obtenerDispositivos = function() {
		console.log("Servicio Dispositivo");
		return $http({
			method : 'GET',
			url : URL_DISPOSITIVO
		});
	}
});

app.service('Reserva', function($http) {
	this.insertarReserva = function(cod, inves, fecha, hora) {

		return $http({
			method : 'POST',
			url : URL_RESERVA,
			params : {
				dispositivo : cod,
				investigador : inves,
				fechaPrestamo : fecha,
				numeroHoras : hora
			}

		});
	}

	this.obtenerReserva = function() {
		return $http({
			method : 'GET',
			url : URL_LISTA_RESERVAS
		});

	}

	this.modificarReserva = function(cod, admin) {
		return $http({
			method : 'PUT',
			url : URL_MODIFICAR_RESERVA,
			params : {
				codigo : cod,
				administrador : admin,
				estado : "NO"
			}
		});

	}
});

app.factory('Factory', function($cookies, $location) {
	return {

		login : function(usuario, rol) {

			// creamos la cookie con el nombre que nos han pasado
			$cookies.nombreUsuario = usuario;
			$cookies.rol = rol;
			// mandamos a la lista de clientes

			if (rol == 1) {
				$location.url('/indexAdministrador');
			} else {
				$location.url('/indexInvestigador');
			}

		},

		validarEstado : function() {

			if (typeof ($cookies.nombreUsuario) == 'undefined') {
				$location.url('/');
			}
			// en el caso de que intente acceder al login y ya haya iniciado
			// sesi�n lo mandamos a
			// la lista de clientes
			if (typeof ($cookies.nombreUsuario) != 'undefined'
					&& $location.url() == '/') {

				if ($cookies.rol == 1) {
					$location.url('/indexAdministrador');
				} else {
					$location.url('/indexInvestigador');
				}
			}
		}
	};
});