package com.StoreOnline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer idProducto;
	@Column(name = "nombre_producto")
	private String nombreProd;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor idProveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria idCategoria;
	

	@Column(name = "umedida")
	private String unidadM;
	
	@Column(name="precio_unidad")
	private double precioU;
	
	@Column(name="unidades_existencia")
	private int unidadEx;
	
	//agregando atributos nuevos 2-11-2022(dd-mm-yy)
    private byte[] foto;
    
	@Column(name="nombre_foto")
	private String nombreArchivo;
	
	
	

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public Proveedor getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getUnidadM() {
		return unidadM;
	}

	public void setUnidadM(String unidadM) {
		this.unidadM = unidadM;
	}

	public double getPrecioU() {
		return precioU;
	}

	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}

	public int getUnidadEx() {
		return unidadEx;
	}

	public void setUnidadEx(int unidadEx) {
		this.unidadEx = unidadEx;
	}
	
	
	


}
