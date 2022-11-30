package com.StoreOnline.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.StoreOnline.entity.Proveedor;




public interface ProveedoresRepository extends JpaRepository<Proveedor, Integer>{

	
	@Query("select e from Proveedor e Where e.tipo.idPais=?1")
	public List<Proveedor> listAllByProyecto(String codPro);
}
