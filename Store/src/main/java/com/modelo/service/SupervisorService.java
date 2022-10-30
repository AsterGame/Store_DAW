package com.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.dao.SupervisorRepository;
import com.modelo.entity.Supervisor;

@Service
public class SupervisorService {

	@Autowired
	private SupervisorRepository repo;
	
	public List<Supervisor> listarSupervisores(){
		return repo.findAll();
	}
	public Supervisor buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public void actualizar(Supervisor bean) {
		repo.save(bean);
	}
	
}
