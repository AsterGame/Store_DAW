package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.CategoriasRepository;
import com.StoreOnline.entity.Categoria;


@Service
public class CategoriaService {
	@Autowired
	private CategoriasRepository repo;
	public void grabar(Categoria bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Categoria buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Categoria> lisCategorias(){
		return repo.findAll();
	}
	
	
}
