package com.StoreOnline.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	public Producto buscarUna(String nombreP) {
	  Producto p=null;
	 for(Producto x:servicioProuctos.lisProductos()) {
		 if(x.getNombreProd().equals(nombreP)) {
			return p=x;
		 }
	 }
	 
	 return p;
	}
    
	@RequestMapping("{nombreP}")
	public String lis( Model model, @PathVariable String nombreP ) {
		model.addAttribute("producto",buscarUna(nombreP));
	
		
		return "page";
		
	}

}
