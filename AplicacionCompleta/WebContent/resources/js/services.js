
var URL_LOGIN = 'http://localhost:8080/SistemaPrestamos/rest/Usuario/Validar';

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
				clave: contrasena
			}
		});
	}

});
