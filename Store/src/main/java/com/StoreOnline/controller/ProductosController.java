package com.StoreOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.StoreOnline.entity.Categoria;
import com.StoreOnline.entity.Producto;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.ProductoService;

@Controller
@RequestMapping ("/pro")
public class ProductosController {

	@Autowired 
	private ProductoService servicioProuctos;
	
	@RequestMapping("/listar")
	public String lis( Model model ) {
		model.addAttribute("super",servicioProuctos.lisProductos());
		return "index";
		
	}
	
	@RequestMapping("/grabar")
	public String grabar (@RequestParam ("codigoP")int cod,@RequestParam ("nombreP")String nombrePro,
			@RequestParam ("tipoPro")int codtipoPro,@RequestParam ("tipoCat")int tipoCate, @RequestParam ("unidad")String unidad,
			@RequestParam ("precio")double precio,@RequestParam ("stockProd")int unidaddeExistencia, RedirectAttributes redirect) 
	{
		try {

			//Productos
		/*	Producto p= new Producto();
			p.setCodigoP(cod);
			p.setNombreP(nombrePro);
			p.setUnidad(unidad);
			p.setPrecio(precio);
			p.setStockProd(unidaddeExistencia);
			
			//Proveedores
			Proveedores pr= new Proveedores();
			pr.setCodigoProv(codtipoPro);
			//Envio de objeto a productos
			p.setTipoPro(pr);
			
			//Categorias
			Categorias c =new Categorias();
			c.setCodigoCate(tipoCate);
			//Envio de objeto a productos
			p.setTipoCate(c);
			
			servicioProuctos.grabar(p);
			
			if(cod ==0)
				redirect.addFlashAttribute("MENSAJE","Producto Registrado");
			
			else
			 redirect.addFlashAttribute("Mensaje","Mendicamento actualizado");	
			
			*/
		}catch(Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al grabar");
			e.printStackTrace();
		}
	
	return null;
	}
	
	
	
}
