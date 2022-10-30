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
}
