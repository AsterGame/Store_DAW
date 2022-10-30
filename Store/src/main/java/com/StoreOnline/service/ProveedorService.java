package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.ProveedoresRepository;
import com.StoreOnline.entity.Proveedores;

@Service
public class ProveedorService {
	@Autowired
	private ProveedoresRepository repo;
	
	public List<Proveedores> lisProveedores(){
		return repo.findAll();
	}
	public Proveedores buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public void actualizar(Proveedores bean) {
		repo.save(bean);
	}
	
}
