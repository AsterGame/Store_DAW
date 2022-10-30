package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.UsuariosRepository;
import com.StoreOnline.entity.Usuarios;

@Service
public class UsuarioService {
	@Autowired
	private UsuariosRepository repo;
	
	public List<Usuarios> listarUsuario(){
		return repo.findAll();
	}
	public Usuarios buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public void actualizar(Usuarios bean) {
		repo.save(bean);
	}
	
}
