package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.CategoriasRepository;
import com.StoreOnline.entity.Categorias;

@Service
public class CategoriaService {
	@Autowired
	private CategoriasRepository repo;
	
	public List<Categorias> lisCategorias(){
		return repo.findAll();
	}
	
	
}
