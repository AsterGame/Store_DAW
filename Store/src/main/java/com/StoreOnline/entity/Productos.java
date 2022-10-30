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
@Table(name="tb_productos")
public class Productos {

	//Datos de la tabla productos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdProducto")
	private int codigoP;
	@Column(name="NombreProducto")
	private String nombreP;
	@Column(name="umedida")
	private String unidad;
	@Column(name="PrecioUnidad")
	private double precio;
	@Column(name="UnidadesEnExistencia")
	private int stockProd;
	
	//Datos del combo tb_proveedores (IdProveedor) y tb_categoria (IdCategoria)
	
	//Asociacion del tb_proveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Proveedores tipoPro;
	
	//Asociacion de tb_categoria
	@ManyToOne
	@JoinColumn (name="IdCategoria")
	private Categorias tipoCate;

	
	//metodos de lectura
	
	public int getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockProd() {
		return stockProd;
	}

	public void setStockProd(int stockProd) {
		this.stockProd = stockProd;
	}

	public Proveedores getTipoPro() {
		return tipoPro;
	}

	public void setTipoPro(Proveedores tipoPro) {
		this.tipoPro = tipoPro;
	}

	public Categorias getTipoCate() {
		return tipoCate;
	}

	public void setTipoCate(Categorias tipoCate) {
		this.tipoCate = tipoCate;
	}
	
	
	
	
	
	
}
