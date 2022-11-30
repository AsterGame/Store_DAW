package com.StoreOnline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.StoreOnline.entity.Pais;
import com.StoreOnline.entity.Producto;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.PaisService;
import com.StoreOnline.service.ProveedorService;
import com.StoreOnline.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



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
	public String grabar(
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
		//	p.setIdProv(codpro);
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
			
			if(p.getIdProv()==0)
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
	
	@RequestMapping("/consulta")
	@ResponseBody
	public List<Proveedor>consulta(@RequestParam("codigo")String cod){
		return servicioProv.listarProveedoresPorPais(cod);
	}
	

	@RequestMapping(value="consulta_proveedor")
	public String lista_Reporte( Model model ) {
		
		model.addAttribute("prove",servicioProv.lisProveedores());
		model.addAttribute("pais",servicioPs.listarTodos());
		
		return "consulta_proveedor";
		
	}
	
	@RequestMapping("/reporte")
	public void reporte (HttpServletResponse response,@RequestParam("codigo")String cod) {
		try {
			List<Proveedor>data= servicioProv.listarProveedoresPorPais(cod);
			File file = ResourceUtils.getFile ("classpath:reporte_pais.jrxml");
			JRBeanCollectionDataSource info = new JRBeanCollectionDataSource(data);
			JasperPrint print = Libreria.generarReporte(file, info);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}


