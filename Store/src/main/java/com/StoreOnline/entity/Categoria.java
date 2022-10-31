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
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idcate;
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	//producto 
		@JsonIgnore
		@OneToMany(mappedBy = "idCategoria")
		private List<Producto> listaCategoria;

		

		public Integer getIdcate() {
			return idcate;
		}

		public void setIdcate(Integer idcate) {
			this.idcate = idcate;
		}

		public String getNombreCategoria() {
			return nombreCategoria;
		}

		public void setNombreCategoria(String nombreCategoria) {
			this.nombreCategoria = nombreCategoria;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public List<Producto> getListaCategoria() {
			return listaCategoria;
		}

		public void setListaCategoria(List<Producto> listaCategoria) {
			this.listaCategoria = listaCategoria;
		}
	
		
		
}
