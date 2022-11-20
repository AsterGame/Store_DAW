package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.UsuarioRepository;
import com.StoreOnline.entity.Enlace;
import com.StoreOnline.entity.Usuario;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	
	public Usuario loginUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	public List<Enlace> enlacesDelUsuario(int rol){
		return repo.traerEnlacesDelUsuario(rol);
	}
	
	
}
