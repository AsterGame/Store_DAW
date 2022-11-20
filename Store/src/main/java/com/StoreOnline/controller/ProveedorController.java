package com.StoreOnline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.StoreOnline.entity.Pais;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.PaisService;
import com.StoreOnline.service.ProveedorService;



@Controller
@RequestMapping ("/proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorService servicioProv;
	@Autowired
	private PaisService servicioPs;



	@RequestMapping("/lista")
	public String inicio(Model model) {
		
		List<Proveedor> data=servicioProv.lisProveedores();
		List<Pais> dataTipo=servicioPs.listarTodos();
			
				model.addAttribute("lista",data);
				model.addAttribute("paises",dataTipo);
	
		return "proveedor";
	
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("idProv") int codpro,
			             @RequestParam("nombreCia") String nom,
						 @RequestParam("nombreContacto") String des,
						 @RequestParam("cargoContacto") String car,
						 @RequestParam("direccion") String dir,
						  @RequestParam("tipo") String codTipo,
					     @RequestParam("telefono")String tel,
					     @RequestParam("fax") String fax,
					  
					     RedirectAttributes redirect) {
		try {
			//crear objeto
			Proveedor p=new Proveedor();
			//setear
			p.setIdProv(codpro);
			p.setNombreCia(nom);
			p.setNombreContacto(des);
			p.setCargoContacto(car);
			p.setDireccion(dir);
			p.setTelefono(tel);
			p.setFax(fax);
			
			//crear objeto
			Pais ps=new Pais();
		
			ps.setIdPais(codTipo);
			
			p.setTipo(ps);
		servicioProv.grabar(p);
			
			if(codpro==0)
				//crear atributo
				redirect.addFlashAttribute("MENSAJE","Proveedor registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Proveedor actualizado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		
		return "redirect:/proveedor/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Proveedor buscar(@RequestParam("codigo") int codpro) {
		Proveedor p=servicioProv.buscarPorID(codpro);
		System.out.println(p.getNombreCia());
		return p;
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") int codpro,RedirectAttributes redirect) {
		try {
			servicioProv.eliminar(codpro);
			redirect.addFlashAttribute("MENSAJE","Proveedor eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		
		return "redirect:/proveedor/lista";
	}
	

}


