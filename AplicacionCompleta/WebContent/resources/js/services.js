/**
 * 
 */
var URL_LOGIN = 'http://localhost:8080/SistemaPrestamos/rest/Usuario/Validar';

var app = angular.module('prestamos.service', []);

app.service('Login', function($http) {
	this.validar = function(usuario, contraseña) {
		return $http({
			method : 'GET',
			url : URL_LOGIN,
			param : {
				login : usuario,
				clave: contraseña
			}

		});
	}

});
