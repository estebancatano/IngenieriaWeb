package co.edu.udea.iw.dto;

import java.util.Date;

public class Dispositivo {
		private long codigo;
		private String descripcion;
		private String tipo;
		private String marca;
		private String valor;
		private Date fechaAdquisicion;
		private String eliminado;
		private Date fechaEliminacion;
		private String administradorElimina;
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		public Date getFechaAdquisicion() {
			return fechaAdquisicion;
		}
		public void setFechaAdquisicion(Date fechaAdquisicion) {
			this.fechaAdquisicion = fechaAdquisicion;
		}
		public String getEliminado() {
			return eliminado;
		}
		public void setEliminado(String eliminado) {
			this.eliminado = eliminado;
		}
		public Date getFechaEliminacion() {
			return fechaEliminacion;
		}
		public void setFechaEliminacion(Date fechaEliminacion) {
			this.fechaEliminacion = fechaEliminacion;
		}
		public String getAdministradorElimina() {
			return administradorElimina;
		}
		public void setAdministradorElimina(String administradorElimina) {
			this.administradorElimina = administradorElimina;
		}
		
		
				
}
