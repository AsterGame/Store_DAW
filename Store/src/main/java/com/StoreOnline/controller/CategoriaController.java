package com.StoreOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.StoreOnline.entity.Categoria;
import com.StoreOnline.service.CategoriaService;

@Controller
@RequestMapping ("/categoria")

public class CategoriaController {
	@Autowired 
	private CategoriaService servicioCat;

	@RequestMapping("/lista")
	public String inicio(Model model) {
		
		List<Categoria> data=servicioCat.lisCategorias();
	
			
				model.addAttribute("lista",data);
	
		return "categoria";
	
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("idcate") int codpro,
			             @RequestParam("nombreCategoria") String nom,
						 @RequestParam("descripcion") String des,
						 
					  
					     RedirectAttributes redirect) {
		try {
			//crear objeto
			Categoria c=new Categoria();
			//setear
			c.setIdcate(codpro);
			c.setNombreCategoria(nom);
			c.setDescripcion(des);
			
			servicioCat.grabar(c);
			
			if(codpro==0)
				//crear atributo
				redirect.addFlashAttribute("MENSAJE","Proveedor registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Proveedor actualizado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		
		return "redirect:/categoria/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Categoria buscar(@RequestParam("codigo") int codpro) {
		Categoria c=servicioCat.buscar(codpro);
		System.out.println(c.getNombreCategoria());
		return c;
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") int codpro,RedirectAttributes redirect) {
		try {
			servicioCat.eliminar(codpro);
			redirect.addFlashAttribute("MENSAJE","Proveedor eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		
		return "redirect:/categoria/lista";
	}
	

}


