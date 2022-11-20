package com.StoreOnline.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tb_paises")
public class Pais {
	
	@Id
	@Column(name = "id_pais")
	private String idPais;
	@Column(name = "nombre_pais")
	private String nombrePais;
	
	//proveedor
		@JsonIgnore
		@OneToMany(mappedBy = "tipo")
		private List<Proveedor> listaProveedor;

		public String getIdPais() {
			return idPais;
		}

		public void setIdPais(String idPais) {
			this.idPais = idPais;
		}

		public String getNombrePais() {
			return nombrePais;
		}

		public void setNombrePais(String nombrePais) {
			this.nombrePais = nombrePais;
		}

		public List<Proveedor> getListaProveedor() {
			return listaProveedor;
		}

		public void setListaProveedor(List<Proveedor> listaProveedor) {
			this.listaProveedor = listaProveedor;
		}

		
}
