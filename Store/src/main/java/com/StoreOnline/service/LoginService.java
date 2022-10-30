package com.StoreOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreOnline.dao.LoginRepository;
import com.StoreOnline.entity.Login;

@Service
public class LoginService {
	@Autowired
	private LoginRepository repo;
	
	public List<Login> lisLogin(){
		return repo.findAll();
	}
	
	
}
