package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.ProveedoresRepository;
import com.StoreOnline.entity.Producto;
import com.StoreOnline.entity.Proveedor;

@Service
public class ProveedorService {
	@Autowired
	private ProveedoresRepository repo;
	
	public List<Proveedor> lisProveedores(){
		return repo.findAll();
	}
	public Proveedor buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public void grabar(Proveedor bean) {
		repo.save(bean);
	}
	public void eliminar(Integer codpro) {
		repo.deleteById(codpro);
	}
	
	public List<Proveedor> listarProveedoresPorPais (String cod){
		return repo.listAllByProyecto(cod);
	}
	
}
