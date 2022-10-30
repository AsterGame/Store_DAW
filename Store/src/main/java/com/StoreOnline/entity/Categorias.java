package com.StoreOnline.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "tb_categorias" )
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdCategoria")
	private int codigoCate;
	@Column (name="NombreCategoria")
	private String nombreCate;
	@Column (name="Descripcion")
	private String descripcionCate;
	
	@OneToMany(mappedBy = "tipoCate")
	private List<Productos>listaCategorias;

	public int getCodigoCate() {
		return codigoCate;
	}

	public void setCodigoCate(int codigoCate) {
		this.codigoCate = codigoCate;
	}

	public String getNombreCate() {
		return nombreCate;
	}

	public void setNombreCate(String nombreCate) {
		this.nombreCate = nombreCate;
	}

	public String getDescripcionCate() {
		return descripcionCate;
	}

	public void setDescripcionCate(String descripcionCate) {
		this.descripcionCate = descripcionCate;
	}

	public List<Productos> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Productos> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	
	
	
}
