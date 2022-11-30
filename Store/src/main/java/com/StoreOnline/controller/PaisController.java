package com.StoreOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.StoreOnline.entity.Pais;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.PaisService;
@Controller
@RequestMapping ("/pais")
public class PaisController {
	@Autowired 
	private PaisService servicioPais;

	@RequestMapping("/lista")
	public String inicio(Model model) {
		
		List<Pais> data=servicioPais.listarTodos();
	
			
				model.addAttribute("lista",data);
	
		return "pais";
	
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("idPais") String codpro,
			             @RequestParam("nombrePais") String nom,
					     RedirectAttributes redirect) {
		try {
			//crear objeto
			Pais p=new Pais();
			//setear
			p.setIdPais(codpro);
			p.setNombrePais(nom);
			
			servicioPais.grabar(p);
			
			if(codpro==null)
				//crear atributo
				redirect.addFlashAttribute("MENSAJE","Proveedor registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Proveedor actualizado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		
		return "redirect:/pais/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Pais buscar(@RequestParam("codigo") String codpro) {
		Pais p=servicioPais.buscar(codpro);
		System.out.println(p.getNombrePais());
		return p;
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") String codpro,RedirectAttributes redirect) {
		try {
			servicioPais.eliminar(codpro);
			redirect.addFlashAttribute("MENSAJE","Proveedor eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		
		return "redirect:/pais/lista";
	}
	

}


