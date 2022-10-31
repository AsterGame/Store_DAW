package com.StoreOnline.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
		@OneToMany(mappedBy = "idPais")
		private List<Proveedor> listaProveedor;
}
