package com.StoreOnline.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tb_usuario")
public class Usuario {

	@Id
	@Column(name = "cod_usu")
	private Integer id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	
	
	@Column(name = "nom_usu")
	private String nom_usu;
	
	@Column(name = "ape_usu")
	private String ape_usu;
	
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom_usu() {
		return nom_usu;
	}


	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}


	public String getApe_usu() {
		return ape_usu;
	}


	public void setApe_usu(String ape_usu) {
		this.ape_usu = ape_usu;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	

	
	
	
	
	
	
	
}
