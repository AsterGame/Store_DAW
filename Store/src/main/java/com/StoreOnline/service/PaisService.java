package com.StoreOnline.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.PaisRepository;
import com.StoreOnline.entity.Pais;
@Service
public class PaisService {
	@Autowired
	private PaisRepository repo;
	
	public void grabar(Pais bean) {
		repo.save(bean);
	}
	public void eliminar(String cod) {
		repo.deleteById(cod);
	}
	public Pais buscar(String cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Pais> listarTodos(){
		return repo.findAll();
	}
}
