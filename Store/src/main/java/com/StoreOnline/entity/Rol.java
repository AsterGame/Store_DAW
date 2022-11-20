package com.StoreOnline.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="tb_rol")
public class Rol {
	
	@Id
	@Column(name = "idrol")
	private Integer codigo;
	
	@Column(name = "descripcion")
	private String descripcion;

	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<Usuario>listaUsuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<RolEnlace>listadoEnlace;
	
	
	
	
	//Metodos de lectura
	
	public String getDescripcion() {
		return descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<RolEnlace> getListadoEnlace() {
		return listadoEnlace;
	}

	public void setListadoEnlace(List<RolEnlace> listadoEnlace) {
		this.listadoEnlace = listadoEnlace;
	}
	
	

	
	
	
}
