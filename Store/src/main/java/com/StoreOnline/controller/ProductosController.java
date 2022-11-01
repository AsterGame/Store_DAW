package com.StoreOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.StoreOnline.entity.Categoria;
import com.StoreOnline.entity.Producto;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.CategoriaService;
import com.StoreOnline.service.ProductoService;
import com.StoreOnline.service.ProveedorService;

@Controller
@RequestMapping ("/productos")
public class ProductosController {

	//Productos
	@Autowired 
	private ProductoService servicioProuctos;
	
	//Proveedores
	@Autowired 
	private ProveedorService servicioProveedores;
	
	//Categorias
	@Autowired
	private CategoriaService servicioCategorias;
	
	@RequestMapping("/listarmenu")
	public String listarMenu( Model model ) {
		model.addAttribute("super",servicioProuctos.lisProductos());
		
		return "index";
		
	}
	
	@RequestMapping("/buscarProducto")
	public String buscarP(@RequestParam("codigo") Integer cod)
	{
		return "page";
	}
	
	
	
	@RequestMapping("/listar")
	public String lis( Model model ) {
		model.addAttribute("super",servicioProuctos.lisProductos());
		model.addAttribute("prove",servicioProveedores.lisProveedores());
		model.addAttribute("categ",servicioCategorias.lisCategorias());
		
		return "productos";
		
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Producto buscar(@RequestParam("idProducto") Integer cod)
	{
		return servicioProuctos.buscarPorID(cod);
	}
	
	
	@RequestMapping("/grabar")
	public String actualizar (@RequestParam ("codigo_pro")int cod,@RequestParam ("nombre_pro")String nombrePro,
			@RequestParam ("tipo_pro")int codtipoPro,@RequestParam ("tipo_cat")int tipoCate, @RequestParam ("unidad")String unidad,
			@RequestParam ("precio")double precio,@RequestParam ("stock_prod")int unidaddeExistencia, RedirectAttributes redirect) 
	{
		try {

			//Productos
			Producto p= new Producto();
			p.setIdProducto(cod);
			p.setNombreProd(nombrePro);
			p.setUnidadM(unidad);
			p.setPrecioU(precio);
			p.setUnidadEx(unidaddeExistencia);
			
			
			//Proveedores
			Proveedor pr= new Proveedor();
			pr.setIdProv(codtipoPro);
			//Envio de objeto a productos
			p.setIdProveedor(pr);
			
			//Categorias
			Categoria c =new Categoria();
			c.setIdcate(tipoCate);
			//Envio de objeto a productos
			p.setIdCategoria(c);
			
			servicioProuctos.grabar(p);
		
			if(cod ==0)
				redirect.addFlashAttribute("MENSAJE","Producto Registrado");
			
			else
			 redirect.addFlashAttribute("Mensaje","Mendicamento actualizado");	
			
			
		}catch(Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al grabar");
			e.printStackTrace();
		}
	
	return "redirect:/productos/listar";
	}
	
	
	
}
