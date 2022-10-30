package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modelo.entity.Sucursal;
import com.modelo.entity.Supervisor;
import com.modelo.service.SucursalService;
import com.modelo.service.SupervisorService;

@Controller
@RequestMapping("/sucursales")
public class EdiController {
	@Autowired
	private SucursalService servicioSuc;
	
	@Autowired
	private SupervisorService servicioSuper;
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		model.addAttribute("super",servicioSuper.listarSupervisores());
		model.addAttribute("sucur",servicioSuc.listarSucursales());
		
		return "consulta-apellido";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Supervisor buscar(@RequestParam("codigo") Integer cod) {
		return servicioSuper.buscarPorID(cod);
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom, @RequestParam("apellido") String ape,
			@RequestParam("dni") int dni,
			@RequestParam("hijos") int hijos,
			@RequestParam("sueldo") double sueldo,@RequestParam("sucursal") int codSucursal,
			RedirectAttributes redirect) {
		try {
			
			
			Supervisor edi=new Supervisor();
			edi.setCodigo(cod);
			edi.setNom(nom);
			edi.setApe(ape);
			edi.setDni(dni);
			edi.setNum(hijos);
			edi.setSueldo(sueldo);
			Sucursal dis=new Sucursal();
			dis.setCodigo(codSucursal);
			edi.setCodSucursal(dis);
			servicioSuper.actualizar(edi);
			
			redirect.addFlashAttribute("MENSAJE","Supervisor actualizado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la actualización");
			e.printStackTrace();
		}
		return "redirect:/sucursales/lista";
	}
	
}
