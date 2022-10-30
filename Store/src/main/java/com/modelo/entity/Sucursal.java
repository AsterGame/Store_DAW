package com.modelo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_sucursal")
	private Integer codigo;
	@Column(name = "nom_sucursal")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "codSucursal")
	private List<Supervisor> listaSuper;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Supervisor> getListaSuper() {
		return listaSuper;
	}

	public void setListaSuper(List<Supervisor> listaSuper) {
		this.listaSuper = listaSuper;
	}

	
	
	
}
