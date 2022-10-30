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
	
	public List<Pais> lisSucursales(){
		return repo.findAll();
	}
	
	
}
