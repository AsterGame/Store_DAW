package com.StoreOnline.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.StoreOnline.entity.Categoria;
import com.StoreOnline.entity.Producto;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.CategoriaService;
import com.StoreOnline.service.ProductoService;
import com.StoreOnline.service.ProveedorService;

@Controller
@RequestMapping ("/tables")
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
	

	@RequestMapping("menu")
	public String menuPrincipal() {
		return "index";
		
	}
	
	
	
	
	@RequestMapping(value="listar")
	public String lis( Model model ) {
		model.addAttribute("super",servicioProuctos.lisProductos());
		model.addAttribute("prove",servicioProveedores.lisProveedores());
		model.addAttribute("categ",servicioCategorias.lisCategorias());
		
		return "tables";
		
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
			
			
			//Proveedores aa
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
	
	return "redirect:/tables/listar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idProducto")int cod, RedirectAttributes redirect) {
		try {
			servicioProuctos.eliminar(cod);
			redirect.addFlashAttribute("Mensaje","Producto eliminado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("Mensaje","Error al eliminar un producto");
			e.printStackTrace();
		}
		return "redirect:/tables/listar";
	}
	
	
	
	
	@RequestMapping("/subir-archivo")
	public String subirArchivo(@RequestParam("data") MultipartFile archivo,
			@RequestParam("codigo") Integer cod,
			RedirectAttributes redirect) throws IOException {
		//
		String nomArchivo=archivo.getOriginalFilename();
		//
		byte[] bytes=archivo.getBytes();
		//
		String ruta="C://tienda//datosIMG//";
		//generar archivo
		Files.write(Paths.get(ruta+nomArchivo), bytes);
		
		servicioProuctos.actualizarIMG(bytes, nomArchivo, cod);
		redirect.addFlashAttribute("MENSAJE","Foto actualizada");
		return "redirect:/tables/listar";
	}
	
	
}
