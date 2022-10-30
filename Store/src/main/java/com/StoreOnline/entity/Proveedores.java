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
@Table (name="tb_proveedores")
public class Proveedores {

	//Datos de la tabla proovedores
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdProveedor")
	private int codigoProv;
	@Column(name="NombreCia")
	private  String nombre;
	@Column(name="NombreContacto")
	private String nombreContacto ;
	@Column(name="CargoContacto")
	private String Cargo;
	@Column(name="Direccion")
	private String Direccion;
	@Column(name="idpais")
	private String pais;
	@Column(name="Telefono")
	private String telefono;
	@Column(name="Fax")
	private String fax;
	
	//Relacion
	@OneToMany (mappedBy = "tipoPro")
	private List<Productos>listaProductos;

	public int getCodigoProv() {
		return codigoProv;
	}

	public void setCodigoProv(int codigoProv) {
		this.codigoProv = codigoProv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public List<Productos> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	
}
