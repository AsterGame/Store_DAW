package com.StoreOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StoreOnline.entity.Productos;
import com.StoreOnline.service.ProductoService;

@Controller
@RequestMapping ("/")
public class ProductosController {

	@Autowired 
	private ProductoService servicioProuctos;
	
	
}
