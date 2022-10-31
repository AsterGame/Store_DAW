package com.StoreOnline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreOnline.entity.Producto;

public interface ProductosRepository  extends JpaRepository<Producto,Integer>{

}
