package com.StoreOnline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreOnline.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
