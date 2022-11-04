package com.StoreOnline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.StoreOnline.entity.Producto;
import com.StoreOnline.service.ProductoService;

@Controller
@RequestMapping ("/servicio")
public class ProductoWebService {
	
	//Productos
		@Autowired 
		private ProductoService servicioProuctos;
	
	@RequestMapping("/producto")
	@ResponseBody
	public List<Producto> listarMenu() {
		return servicioProuctos.lisProductos();
	}
	
	@RequestMapping("{numero}")
	public Optional<Producto>  buscarP(@PathVariable int numero)
	{
		
		return listarMenu().stream().filter(Producto-> Producto.getIdProducto()==numero ).findFirst();
	  
	}
	

}
