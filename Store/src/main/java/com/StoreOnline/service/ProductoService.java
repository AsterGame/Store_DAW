package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.ProductosRepository;
import com.StoreOnline.entity.Productos;

@Service
public class ProductoService {

	@Autowired
	private ProductosRepository repo;
	
	public List<Productos>lisProductos(){
		return repo.findAll();
	}
	
	public void grabar(Productos bean) {
		repo.save(bean);
	}
	
	
}
