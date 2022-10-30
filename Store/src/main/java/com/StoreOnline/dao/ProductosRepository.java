package com.StoreOnline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreOnline.entity.Productos;

public interface ProductosRepository  extends JpaRepository<Productos,Integer>{

}
