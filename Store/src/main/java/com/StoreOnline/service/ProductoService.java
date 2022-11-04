package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.ProductosRepository;
import com.StoreOnline.entity.Producto;

@Service
public class ProductoService {

	@Autowired
	private ProductosRepository repo;
	
	public List<Producto>lisProductos(){
		return repo.findAll();
	}
	
	public void grabar(Producto bean) {
		repo.save(bean);
	}
	
	public Producto buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void actualizarIMG(byte[] img,String nomAr,Integer cod) {
		repo.actualizarFoto(img, nomAr, cod);
	}
	
}
