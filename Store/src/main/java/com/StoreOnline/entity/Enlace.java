package com.StoreOnline.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="tb_enlace")
public class Enlace {
	
	@Id
	@Column(name = "idenlace")
	private Integer codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "ruta")
	private String ruta;

	@JsonIgnore
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace>listarRolEnlace;
	
	
	
	//Metodos de lectura

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<RolEnlace> getListarRolEnlace() {
		return listarRolEnlace;
	}

	public void setListarRolEnlace(List<RolEnlace> listarRolEnlace) {
		this.listarRolEnlace = listarRolEnlace;
	}
	
	
	
}
