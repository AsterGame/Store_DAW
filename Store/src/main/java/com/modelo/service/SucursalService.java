package com.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.dao.SucursalRepository;
import com.modelo.entity.Sucursal;

@Service
public class SucursalService {
	@Autowired
	private SucursalRepository repo;
	
	public List<Sucursal> listarSucursales(){
		return repo.findAll();
	}
	
	
}
