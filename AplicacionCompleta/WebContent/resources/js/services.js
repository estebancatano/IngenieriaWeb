var URL_LOGIN = 'http://localhost:8080/SistemaPrestamos/rest/Usuario/Validar';
var URL_DISPOSITIVO = 'http://localhost:8080/SistemaPrestamos/rest/Dispositivo/Listar';

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