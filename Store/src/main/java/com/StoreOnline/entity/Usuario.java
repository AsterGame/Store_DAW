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
	@Column(name = "id_usuario")
	private Integer id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	
	
	@Column(name = "nombre_usuario")
	private String nombre_usario;
	
	@Column(name = "fecha_nacimiento")
	private String fecha_nacimiento;
	
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;
	
	//Metodos de lecutra

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

	public String getNombre_usario() {
		return nombre_usario;
	}

	public void setNombre_usario(String nombre_usario) {
		this.nombre_usario = nombre_usario;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	

	
	
	
	
	
	
	
}
