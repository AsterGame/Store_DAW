package com.modelo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_supervisor")
public class Supervisor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_supervisor")
	private Integer codigo;
	@Column(name = "nom_supervisor")
	private String nom;
	@Column(name = "ape_supervisor")
	private String ape;
	@Column(name="dni_supervisor")
	private int dni;
	
	@Column(name="num_hijos")
	private int num;
	
	
	@Column(name = "sueldo ")
	private double sueldo;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_sucursal")
	private Sucursal codSucursal;


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getApe() {
		return ape;
	}


	public void setApe(String ape) {
		this.ape = ape;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public Sucursal getCodSucursal() {
		return codSucursal;
	}


	public void setCodSucursal(Sucursal codSucursal) {
		this.codSucursal = codSucursal;
	}


	
	
	
	
}
